package de.dhbwka.studentenfutter.servlets;

import de.dhbwka.studentenfutter.bean.UserBean;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/logout")
public class LogoutServlet extends AbstractServlet {
    @Override
    protected void handleDoGet(HttpServletRequest req, HttpServletResponse res) throws Exception {
        ((UserBean)req.getSession().getAttribute("user")).logout();
        req.getRequestDispatcher("/jsp/index.jsp").forward(req, res);
    }
}