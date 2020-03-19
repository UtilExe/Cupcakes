package PresentationLayer;

import FunctionLayer.LogicFacade;
import FunctionLayer.LoginSampleException;
import FunctionLayer.User;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Register extends Command {

    @Override
    String execute( HttpServletRequest request, HttpServletResponse response ) throws LoginSampleException {
        String username = request.getParameter( "username" );
        String email = request.getParameter( "email" );
        String password = request.getParameter( "password" );
        int mobilNr = Integer.parseInt((request.getParameter("mobilNr")).replace(" ", ""));

        try {
            User user = LogicFacade.createUser(username, email, password, mobilNr);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
            HttpSession session = request.getSession();

        request.setAttribute("username", username);
        request.setAttribute("email", email);
        request.setAttribute("password", password);
        request.setAttribute("mobilNr", mobilNr);
          /*  session.setAttribute("email",email);
            session.setAttribute( "user", user );

           */
            return "createAccount";
        }
    }