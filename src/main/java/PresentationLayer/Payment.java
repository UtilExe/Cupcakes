package PresentationLayer;

import DBAccess.UserMapper;
import FunctionLayer.LoginSampleException;
import Objects.Cupcake;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;

import static PresentationLayer.BuildCupcake.cart;

public class Payment extends Command {

     /**
     @author Daniel, Emil, Jannich, Jimmy
     @param email - Gets the session email as an Object and converts email to a String.
     @return If the user is not logged in, it will return createAccount.jsp, else cart.jsp
     */

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        cart = (ArrayList<Cupcake>) session.getAttribute("cart");

        String email = String.valueOf(session.getAttribute("email"));

        if(!(email.contains("@"))) {
            request.setAttribute("createAccountBesked1", "Du skal være logget ind for at oprette en ordre.");
            return "createAccount";
        }

        try {
            UserMapper.createOrder(email);

            for (Cupcake c : cart) {
                int quantity = c.getQuantity();
                int sum = (c.getBottomPrice() + c.getToppingPrice()) * quantity;
                int toppingID = c.getToppingID();
                int bottomID = c.getBottomID();
                UserMapper.createOrderLine(email, quantity, sum, toppingID, bottomID);
            }

            UserMapper.adjustSaldo(email, getTotal(cart));

            if(cart.isEmpty()) {
                request.setAttribute("beskedPayment1", "Din indkøbskurv er tom!");
            } else {
                request.setAttribute("beskedPayment2", "Ordre oprettet, den kan nu hentes i butikken!");
            }

            cart.clear();
            session.setAttribute("total", 0);

        } catch(Exception e) {
            session.setAttribute("total", 0);
            e.printStackTrace();
        }
        return "cart";
    }

     /**
      *
      * @param total is the sum of all total cupcakes in the cart.
      * @return total
      */
    public static int getTotal(ArrayList<Cupcake> cart) {
        int total = 0;
        for (Cupcake c: cart) {
            total += (c.getBottomPrice()+c.getToppingPrice())*c.getQuantity();
        }
        return total;
    }
}
