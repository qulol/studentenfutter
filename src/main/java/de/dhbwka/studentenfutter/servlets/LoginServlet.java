package de.dhbwka.studentenfutter.servlets;

import de.dhbwka.studentenfutter.model.afe.UserPasswordBean;
import de.dhbwka.studentenfutter.model.bean.UserBean;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns = "/login")
public class LoginServlet extends AbstractServlet {

    @Override
    protected void handleDoGet(HttpServletRequest req, HttpServletResponse res) throws Exception {
        res.sendRedirect(req.getContextPath().concat("/jsp/login.jsp"));
    }

    @Override
    protected void handleDoPost(HttpServletRequest req, HttpServletResponse res) throws Exception {
        String inputUsername = req.getParameter("username");
        String inputPassword = req.getParameter("password");

        res.setContentType("text/html");

        var password = getDataAccess()
                .query("select password from user where name=?")
                .withParam(inputUsername)
                .collectAs(String.class)
                .get();

        if(password.isEmpty() || !password.get().equals(inputPassword)) {
            req.setAttribute("login_error", true); //todo beans und so
            req.getRequestDispatcher(req.getContextPath().concat("/jsp/login.jsp")).forward(req, res);
            return;
        }

        HttpSession session = req.getSession();
        session.setAttribute("user", new UserBean());
        session.setMaxInactiveInterval(60 * 60); // Session expires after 60 minutes
        res.sendRedirect(req.getContextPath().concat("/index"));
    }
}