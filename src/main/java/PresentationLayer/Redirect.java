package PresentationLayer;

import DBAccess.UserMapper;
import FunctionLayer.Initialisation;
import FunctionLayer.LoginSampleException;
import Objects.Cupcake;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;

import static PresentationLayer.BuildCupcake.cart;

public class Redirect extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {

        String destination = request.getParameter("destination");

        HttpSession session = request.getSession();
        cart = (ArrayList<Cupcake>) session.getAttribute("cart");

        if (destination.equals("cupcakes")) {
            request.setAttribute("toppings", Initialisation.getToppingList());
            request.setAttribute("bottoms", Initialisation.getBottomsList());
        }

        if (destination.equals("admin")) {
            request.setAttribute("custs", Initialisation.getUserEmailList());
            request.setAttribute("orders", Initialisation.getOrderList());
        }

        if (destination.equals("cart")) {
            if (!() {
                int total = 0;
                for (Cupcake c : cart) {
                    total += (c.getBottomPrice() + c.getToppingPrice()) * c.getQuantity();
                }
                session.setAttribute("total", total);
            } else {
                session.setAttribute("total", 0);
            }
        }


        return destination;
    }
}
