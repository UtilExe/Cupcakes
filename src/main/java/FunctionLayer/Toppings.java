package FunctionLayer;

import DBAccess.UserMapper;
import Objects.Topping;

import java.util.List;

public class Toppings {

    private static List<Topping> toppingList;

    public static void initTopppings(){
        if (toppingList == null){
            toppingList = UserMapper.getTopping();
            }
    }

    public static List<Topping> getToppingList() {
        return toppingList;
    }
}
