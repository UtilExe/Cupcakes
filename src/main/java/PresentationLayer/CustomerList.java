package PresentationLayer;

import DBAccess.UserMapper;
import FunctionLayer.Initialisation;
import FunctionLayer.LoginSampleException;
import FunctionLayer.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class CustomerList extends Command  {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {

        String email = request.getParameter( "email" );
        ArrayList<User> customerList = UserMapper.getUserInfo(email);
        HttpSession session = request.getSession();

        HashMap<Integer, Date> custOrderList = UserMapper.getCustOrders(email);

        for(Map.Entry<Integer, Date> entry : custOrderList.entrySet()) {
            Integer ID = entry.getKey();
            Date date = entry.getValue();
        }

        request.setAttribute("email", email);
        request.setAttribute("custOrders",custOrderList);
        session.setAttribute("customerList", customerList);
        return "customerList";
    }
}
