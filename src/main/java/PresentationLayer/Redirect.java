package PresentationLayer;

import FunctionLayer.Kode;
import FunctionLayer.LoginSampleException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Redirect extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {

        String destination = request.getParameter("destination");

        if(destination.equals("cupcakes")) {
            request.setAttribute("toppings", Kode.getToppingList());
            request.setAttribute("bottoms", Kode.getBottomsList());
        }

        return destination;
    }
}
