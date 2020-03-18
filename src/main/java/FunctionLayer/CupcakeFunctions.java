package FunctionLayer;

import DBAccess.UserMapper;
import Objects.Bottom;
import Objects.Topping;

import java.util.ArrayList;
import java.util.List;

public class CupcakeFunctions {
    //Creating lists
    private static List<Bottom> bottomList;
    private static List<Topping> toppingList;

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

    //Get lists
    public static List<Bottom> getBottomsList() {
        return bottomList;
    }
    public static List<Topping> getToppingList() {
        return toppingList;
    }

}
