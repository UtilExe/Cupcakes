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
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {

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
