package PresentationLayer;

import FunctionLayer.LoginSampleException;
import FunctionLayer.Toppings;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Redirect extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {

        String destination = request.getParameter("destination");

        if(destination.equals("cupcakes")) {
            request.setAttribute("toppings", Toppings.getToppingList());
        }

        return destination;
    }
}
