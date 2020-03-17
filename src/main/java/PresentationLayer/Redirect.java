package PresentationLayer;

import FunctionLayer.CupcakeFunctions;
import FunctionLayer.LoginSampleException;
import Objects.Cupcake;
import Objects.Topping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

public class Redirect extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {

        String destination = request.getParameter("destination");
        //int antalCupcakes = Integer.parseInt(request.getParameter("antal"));
        //request.setAttribute("antal", antalCupcakes);

        if(destination.equals("cupcakes")) {
            request.setAttribute("toppings", CupcakeFunctions.getToppingList());
            request.setAttribute("bottoms", CupcakeFunctions.getBottomsList());
        }


        return destination;
    }
}
