package PresentationLayer;

import DBAccess.UserMapper;
import FunctionLayer.LoginSampleException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddBalance extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {
        String email = request.getParameter("email");
        int amount;

        try {
            amount = Integer.parseInt(request.getParameter("addBalanceAmount"));
            UserMapper.addBalanceToSaldo(email, amount);
        } catch(Exception e) {
            request.setAttribute("addBalanceError", "Du har ikke indtastet et tal.");
        }

        return "admin";
    }

}
