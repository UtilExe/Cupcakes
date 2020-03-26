package PresentationLayer;

import DBAccess.UserMapper;
import FunctionLayer.LoginSampleException;
import Objects.User;
import Objects.Order;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;

public class CustomerList extends Command  {

    /**
     @author Daniel, Emil, Jannich, Jimmy
     @param email - Gets the email parameter from customerList.jsp
     @return returns customerList.jsp after setting the attributes for the customer's information.
     */

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) {

        String email = request.getParameter( "email" );
        ArrayList<User> customerList = UserMapper.getUserInfo(email);
        HttpSession session = request.getSession();

        ArrayList<Order> custOrderList = UserMapper.getCustOrders(email);

        request.setAttribute("email", email);
        request.setAttribute("custOrders",custOrderList);
        request.setAttribute("beskedCustList", "Tidligere order:");
        session.setAttribute("customerList", customerList);
        return "customerList";
    }
}
