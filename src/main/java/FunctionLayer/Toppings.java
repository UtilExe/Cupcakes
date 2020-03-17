package FunctionLayer;

import DBAccess.Connector;

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
            toppingList = new ArrayList<>();


                try {
                    String query = "SELECT * FROM cupcake.topping";
                    Connection myConnector = null;
                    PreparedStatement pstmt = null;
                    ResultSet resultSet = null;
                    myConnector = Connector.connection();

                    pstmt = myConnector.prepareStatement(query);
                    resultSet = pstmt.executeQuery();
                    while (resultSet.next()) {
                        int ID = resultSet.getInt("idTopping");
                        String name = resultSet.getString("navn");
                        int price = resultSet.getInt("pris");

                        toppingList.add(new Topping(ID, name, price));

                    }

                    resultSet.close();
                    pstmt.close();
                    myConnector.close();
                } catch (SQLException | ClassNotFoundException ex) {
                    System.out.println("Kan ikke kommunikere korrekt med databasen.");
                }
            }
    }

    public static List<Topping> getToppingList() {
        return toppingList;
    }
}
