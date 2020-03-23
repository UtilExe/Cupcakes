package PresentationLayer;

import DBAccess.UserMapper;
import FunctionLayer.LoginSampleException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Contact extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {
        String email = request.getParameter("email");
        String msg = request.getParameter("message");
        if (email.equals("")) {
            request.setAttribute("beskedContact", "Dit email felt er tomt!");
        } else {
            try {
                UserMapper.supportMessage(email, msg);
                request.setAttribute("beskedContact", "Din besked er sendt, vi svarer snarest muligt!");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return "contact";
    }
}
