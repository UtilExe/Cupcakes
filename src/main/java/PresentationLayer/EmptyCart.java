package PresentationLayer;

import FunctionLayer.LoginSampleException;
import Objects.Cupcake;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;

public class EmptyCart extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {

        HttpSession session = request.getSession();
        ArrayList<Cupcake> cart = (ArrayList<Cupcake>) session.getAttribute("cart");

        BuildCupcake.cart.clear();

        session.setAttribute("total", 0);

        return "cart";
    }
}
