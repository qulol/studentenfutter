package de.dhbwka.studentenfutter.servlets;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

@WebServlet(urlPatterns = "/register")
public class RegisterServlet extends AbstractServlet {

    @Override
    protected void handleDoGet(HttpServletRequest req, HttpServletResponse res) throws Exception {
        req.getRequestDispatcher(req.getContextPath().concat("/jsp/register.jsp")).forward(req, res);
    }

    @Override
    protected void handleDoPost(HttpServletRequest req, HttpServletResponse res) throws Exception {
        String inputUsername = req.getParameter("username");
        String inputPassword = req.getParameter("password");
        String inputPasswordRepeat = req.getParameter("password_repeat");

        var db = getDataAccess();

        var userExists =
                db.query("select id_user from user where name=?")
                .withParam(inputUsername).collectAs(Integer.class).get().isPresent();

        //todo outsource to error handler method

        if(userExists) {
            req.setAttribute("username_exists_error", true);
            req.getRequestDispatcher(req.getContextPath().concat("/jsp/register.jsp")).forward(req, res);
            return;
        }

        if(!inputPassword.equals(inputPasswordRepeat)) {
            req.setAttribute("password_repeat_error", true);
            req.getRequestDispatcher(req.getContextPath().concat("/jsp/register.jsp")).forward(req, res);
            return;
        }

        db.query("insert into user (name, password) values (?, ?)")
                .withParam(inputUsername)
                .withParam(inputPassword)
                .run();

        req.setAttribute("register_success", true);
        req.getRequestDispatcher(req.getContextPath().concat("/jsp/login.jsp")).forward(req, res);
    }
}