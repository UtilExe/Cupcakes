package PresentationLayer;

import DBAccess.UserMapper;
import FunctionLayer.CupcakeFunctions;
import FunctionLayer.LoginSampleException;
import Objects.Bottom;
import Objects.Cupcake;
import Objects.Topping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.lang.reflect.Array;
import java.nio.file.attribute.UserDefinedFileAttributeView;
import java.util.ArrayList;


public class BuildCupcake extends Command {

    private static ArrayList<Cupcake> cart = new ArrayList<>();

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {
        ArrayList<Bottom> bottoms = UserMapper.getBottom();
        ArrayList<Topping> toppings = UserMapper.getTopping();

        HttpSession session = request.getSession();
        int antal = Integer.parseInt(request.getParameter("antal"));

        String bottom = request.getParameter("bund");
        String topping = request.getParameter("top");

        Cupcake temp = new Cupcake(getTopping(toppings, topping), getBottom(bottoms, bottom), antal);
        cart.add(temp);

        session.setAttribute("cupcake", temp);

        request.setAttribute("toppings", CupcakeFunctions.getToppingList());
        request.setAttribute("bottoms", CupcakeFunctions.getBottomsList());

        return "cupcakes";
    }

    public static Topping getTopping(ArrayList<Topping> toppings, String topping) {
        for (Topping t : toppings) {
            if(topping.contains(t.getName())) {
                Topping top = new Topping(t.getID(), t.getName(), t.getPrice());
                return top;
            }
        }
        return null;


    }

    public static Bottom getBottom(ArrayList<Bottom> bottoms, String bottom) {
        for (Bottom b: bottoms) {
            System.out.println(b.getName());
            if(bottom.contains(b.getName())) {
                Bottom bot = new Bottom(b.getID(),b.getName(),b.getPrice());
                System.out.println("Du ramte");
                return bot;
            }
        }
        return null;
    }
}
