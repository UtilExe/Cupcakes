package FunctionLayer;

import DBAccess.Connector;
import DBAccess.UserMapper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
