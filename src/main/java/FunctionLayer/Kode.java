package FunctionLayer;

import DBAccess.UserMapper;
import Objects.Bottom;
import Objects.Cupcake;
import Objects.Topping;

import java.util.ArrayList;
import java.util.List;

public class Kode {
    //Creating lists
    private static List<Bottom> bottomList;
    private static List<Topping> toppingList;
    private static ArrayList<Topping> cupcakeList;

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
    public static void initCupcakes(){
        if (cupcakeList == null){
            cupcakeList = UserMapper.getCupcakes();
        }
    }

    //Get lists
    public static List<Bottom> getBottomsList() {
        return bottomList;
    }
    public static List<Topping> getToppingList() {
        return toppingList;
    }
    public static ArrayList<Topping> getCupcakeList() {
        return cupcakeList;
    }
}
