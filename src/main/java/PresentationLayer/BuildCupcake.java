package PresentationLayer;

import FunctionLayer.CupcakeFunctions;
import FunctionLayer.LoginSampleException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class BuildCupcake extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {

        HttpSession session = request.getSession();
        //int antal = Integer.parseInt(request.getParameter("antal"));

        String hejhej = request.getParameter("bund");

        session.setAttribute("besked", hejhej);

        request.setAttribute("toppings", CupcakeFunctions.getToppingList());
        request.setAttribute("bottoms", CupcakeFunctions.getBottomsList());

        return "cupcakes";
    }
}
