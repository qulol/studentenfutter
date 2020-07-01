package de.dhbwka.studentenfutter.servlets;

import de.dhbwka.studentenfutter.bean.UserBean;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/logout")
public class LogoutServlet extends AbstractServlet {
    @Override
    protected void handleDoGet(HttpServletRequest req, HttpServletResponse res) throws Exception {
        var user = ((UserBean)req.getSession().getAttribute("user"));
        var shoppingcart = user.getShoppingCard();

        //todo

        user.logout();
        res.sendRedirect("/jsp/index.jsp");
    }
}