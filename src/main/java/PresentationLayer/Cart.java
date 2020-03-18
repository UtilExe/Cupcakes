package PresentationLayer;

import FunctionLayer.LoginSampleException;
import Objects.Cupcake;
import Objects.Topping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class Cart extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {

       ArrayList<Cupcake> cupcake = new ArrayList<Cupcake>();


       return "cart";
    }
}
