package de.dhbwka.studentenfutter.servlets;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/login")
public class LoginServlet extends AbstractServlet {

    @Override
    protected void handleDoGet(HttpServletRequest req, HttpServletResponse res) throws Exception {
    }

    @Override
    protected void handleDoPost(HttpServletRequest req, HttpServletResponse res) throws Exception {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        res.setContentType("text/html");

        if(username.equals("user") && password.equals("passwort")) {
            res.sendRedirect("index.html");
        }
        else {
            res.getWriter().print("Wrong username or password. Please try again!");
            req.getRequestDispatcher("/login.html").include(req, res);
        }
    }
}