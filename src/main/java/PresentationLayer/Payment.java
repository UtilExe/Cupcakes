package PresentationLayer;

import DBAccess.UserMapper;
import FunctionLayer.LogicFacade;
import FunctionLayer.LoginSampleException;
import FunctionLayer.User;
import Objects.Cupcake;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.constraints.Null;
import java.util.ArrayList;

public class Payment extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {
        HttpSession session = request.getSession();

        String email = String.valueOf(session.getAttribute("email"));

        if(!(email.contains("@"))) {
            request.setAttribute("beskedFejlLogin", "Du skal være logget ind for at oprette en ordre.");
            BuildCupcake.cart.clear();
            session.setAttribute("total", 0);
            return "createAccount";
        }

        try {
            UserMapper.createOrder(email);

            for (Cupcake c : BuildCupcake.cart) {
                int quantity = c.getQuantity();
                int sum = (c.getBottomPrice() + c.getToppingPrice()) * quantity;
                int toppingID = c.getToppingID();
                int bottomID = c.getBottomID();
                UserMapper.createOrderLine(email, quantity, sum, toppingID, bottomID);
            }

            UserMapper.adjustSaldo(email, getTotal(BuildCupcake.cart));

            request.setAttribute("beskedSuccessBetal", "Din ordre er oprettet og du kan nu hente den i butikken!");

            BuildCupcake.cart.clear();
            session.setAttribute("total", 0);

        } catch(Exception e) {
            session.setAttribute("total", 0);
            e.printStackTrace();
        }
        return "cart";
    }

    public static int getTotal(ArrayList<Cupcake> cart) {
        int total = 0;
        for (Cupcake c: BuildCupcake.cart) {
            total += (c.getBottomPrice()+c.getToppingPrice())*c.getQuantity();
        }
        return total;
    }
}
