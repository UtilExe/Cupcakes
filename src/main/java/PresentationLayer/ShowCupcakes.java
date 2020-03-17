package PresentationLayer;

import FunctionLayer.LoginSampleException;
import FunctionLayer.Toppings;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ShowCupcakes extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {
        request.setAttribute("toppings", Toppings.getToppingList());



        return "ShowCupcakes";
    }
}
