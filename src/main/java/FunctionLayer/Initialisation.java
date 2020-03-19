package FunctionLayer;

import DBAccess.UserMapper;
import Objects.Bottom;
import Objects.Topping;

import java.util.ArrayList;
import java.util.List;

public class Initialisation {
    //Creating lists
    private static List<Bottom> bottomList;
    private static List<Topping> toppingList;
    private static List<String> userEmailList;

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

    //Get lists
    public static List<Bottom> getBottomsList() {
        return bottomList;
    }
    public static List<Topping> getToppingList() {
        return toppingList;
    }
    public static List<String> getUserEmailList() { return userEmailList; }

}
