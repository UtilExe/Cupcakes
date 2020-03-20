package PresentationLayer;

import DBAccess.UserMapper;
import FunctionLayer.LoginSampleException;
import Objects.Order;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;

public class OrderList extends Command{
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {
        HttpSession session = request.getSession();
        int orderSearchID = Integer.parseInt(request.getParameter("orderSearchID"));
        Order order = UserMapper.getFullOrder(orderSearchID);

        session.setAttribute("orders", order);
        return "orderList";
    }
}
