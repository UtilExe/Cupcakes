package PresentationLayer;

import DBAccess.UserMapper;
import FunctionLayer.Initialisation;
import FunctionLayer.LoginSampleException;
import Objects.Cupcake;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Redirect extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {

        String destination = request.getParameter("destination");

        HttpSession session = request.getSession();

        if(destination.equals("cupcakes")) {
            request.setAttribute("toppings", Initialisation.getToppingList());
            request.setAttribute("bottoms", Initialisation.getBottomsList());
        }

        if(destination.equals("admin")) {
            request.setAttribute("custs", Initialisation.getUserEmailList());
        }

        if(destination.equals("cart")) {
            session.setAttribute("kurv", BuildCupcake.cart);
            int total = 0;
            for (Cupcake c: BuildCupcake.cart) {
                total += (c.getBottomPrice()+c.getToppingPrice())*c.getQuantity();
            }
            session.setAttribute("total", total);
        }


        return destination;
    }
}
