package DBAccess;

import Objects.Bottom;
import FunctionLayer.LoginSampleException;
import Objects.Topping;
import FunctionLayer.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * The purpose of UserMapper is to...
 *
 * @author kasper
 */
public class UserMapper {

    public static void createUser(User user) throws LoginSampleException {
        try {
            Connection con = Connector.connection();
            String SQL = "INSERT INTO Users (username, email, password, /*create_time,*/ mobil_nr /*, saldo */) VALUES (?, ?, ?,/* ?, */ ? /*, ? */)";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getPassword());
            ps.setInt(4, user.getMobilNr());
            ps.executeUpdate();
            ResultSet rs = ps.executeQuery();
            con.close();
            ps.close();
            rs.close();
        } catch (SQLException | ClassNotFoundException ex) {
            throw new LoginSampleException(ex.getMessage());
        }
    }

    /*
    public static User login(String email, String password) throws LoginSampleException {
        try {
            Connection con = Connector.connection();
            String SQL = "SELECT id, role FROM Users "
                    + "WHERE email=? AND password=?";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setString(1, email);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                String role = rs.getString("role");
                int id = rs.getInt("id");
                User user = new User(email, password, role);
                user.setId(id);
                con.close();
                ps.close();
                rs.close();
                return user;
            } else {
                throw new LoginSampleException("Could not validate user");
            }
        } catch (ClassNotFoundException | SQLException ex) {
            throw new LoginSampleException(ex.getMessage());
        }
    }
*/
    public static void supportMessage(String email, String msg) {
        try {
            Connection con = Connector.connection();
            String SQL = "INSERT INTO cupcake.support VALUES (0, '" + msg + "', '" + email + "');";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.executeUpdate();
        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }

    public static ArrayList<Topping> getTopping() {
        ArrayList<Topping> toppingList = new ArrayList<>();
        try {
            Connection con = Connector.connection();
            String SQL = "SELECT * FROM cupcake.topping;";
            PreparedStatement ps = con.prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int ID = rs.getInt("idTopping");
                String name = rs.getString("navn");
                int price = rs.getInt("pris");

                toppingList.add(new Topping(ID, name, price));
            }

            /*
            RETURNERER NULL HVIS VI CLOSER. HVORFOR?
            con.close();
            ps.close();
            rs.close();
            */

        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println("Kan ikke kommunikere korrekt med databasen.");
        }
        return toppingList;
    }


    public static ArrayList<Bottom> getBottom() {
        ArrayList<Bottom> bottomList = new ArrayList<>();
        try {
            Connection con = Connector.connection();
            String SQL = "SELECT * FROM cupcake.bottom;";
            PreparedStatement ps = con.prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int ID = rs.getInt("idBottom");
                String name = rs.getString("navn");
                int price = rs.getInt("pris");

                bottomList.add(new Bottom(ID, name, price));
            }

            /*
            RETURNERER NULL HVIS VI CLOSER. HVORFOR?
            con.close();
            ps.close();
            rs.close();
            */

        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println("Kan ikke kommunikere korrekt med databasen.");
            ex.printStackTrace();
        }
        return bottomList;
    }

}