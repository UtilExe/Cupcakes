package PresentationLayer;

import DBAccess.UserMapper;
import FunctionLayer.Initialisation;
import FunctionLayer.LoginSampleException;
import FunctionLayer.User;

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

        request.setAttribute("email", email);
        session.setAttribute("customerList", customerList);
        return "customerList";
    }
}
