package PresentationLayer;

import DBAccess.UserMapper;
import FunctionLayer.LoginSampleException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RemoveOrder extends Command {

    /**
     @author Daniel, Emil, Jannich, Jimmy
     @param email - Gets the email parameter from admin.jsp
     @return returns admin.jsp after calling the removeOrder method in UserMapper
     */

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) {
        String email = request.getParameter("email");
        int orderID = Integer.parseInt(request.getParameter("order"));

        UserMapper.removeOrder(email, orderID);

        return "admin";
    }

}
