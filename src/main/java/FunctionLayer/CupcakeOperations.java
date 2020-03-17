package FunctionLayer;

import DBAccess.UserMapper;
import Objects.Cupcake;

import java.util.List;

public class CupcakeOperations {

    private static List<Cupcake> cupcakeList;

    public static void initCupcakes(){
        if (cupcakeList == null){
            toppingList = UserMapper.getTopping();
        }
    }

    public static List<Cupcake> getToppingList() {
        return toppingList;
    }



}
