package PresentationLayer;

import DBAccess.UserMapper;
import FunctionLayer.LogicFacade;
import FunctionLayer.LoginSampleException;
import FunctionLayer.User;
import Objects.Cupcake;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;

public class Payment extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {
        HttpSession session = request.getSession();

        String email = String.valueOf(session.getAttribute("email"));

        UserMapper.createOrder(email);

        int count = 0;
        for (Cupcake c: BuildCupcake.cart) {
            count++;
            int quantity = c.getQuantity();
            int sum = getTotal(BuildCupcake.cart);
            int toppingID = c.getToppingID();
            int bottomID = c.getBottomID();
            UserMapper.createOrderLine(email, count, quantity, sum, toppingID, bottomID);
        }

        UserMapper.adjustSaldo(email, getTotal(BuildCupcake.cart));

        request.setAttribute("besked", "Din ordre er oprettet og du kan nu hente den i butikken!");

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
