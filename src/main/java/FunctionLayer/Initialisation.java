package FunctionLayer;

import DBAccess.UserMapper;
import Objects.Bottom;
import Objects.Topping;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

public class Initialisation {
    //Creating lists
    private static List<Bottom> bottomList;
    private static List<Topping> toppingList;
    private static List<String> userEmailList;
    private static List<Integer> orderList;

    //Inits
    public static void initBottoms(){
        if (bottomList == null){
            bottomList = UserMapper.getBottom();
        }
    }
    public static void initTopppings(){
        if (toppingList == null){
            toppingList = UserMapper.getTopping();
        }
    }
    public static void initEmails() {
        if (userEmailList == null) {
            userEmailList = UserMapper.getUsersEmails();
        }
    }

    public static void initOrders() {
        if(orderList == null) {
            orderList = UserMapper.getOrders();
        }
    }

    //Get lists
    public static List<Bottom> getBottomsList() { return bottomList; }

    public static List<Topping> getToppingList() { return toppingList; }

    public static List<String> getUserEmailList() { return userEmailList; }

    public static List<Integer> getOrderList() { return orderList; }

}
