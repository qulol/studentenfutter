package de.dhbwka.studentenfutter.servlets;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.sql.Timestamp;

@WebServlet(urlPatterns = "/register")
public class RegisterServlet extends AbstractServlet {

    @Override
    protected void handleDoGet(HttpServletRequest req, HttpServletResponse res) throws Exception {
        req.getRequestDispatcher("/jsp/register.jsp").forward(req, res);
    }

    @Override
    protected void handleDoPost(HttpServletRequest req, HttpServletResponse res) throws Exception {
        String inputUsername = req.getParameter("username");
        String inputPassword = req.getParameter("password");
        String inputPasswordRepeat = req.getParameter("password_repeat");

        var userExists =
                getDataAccess().query("select id_user from user where name=?")
                .withParam(inputUsername).collectAs(Integer.class).get().isPresent();

        if(userExists) {
            res.getWriter().print("User already exists. Please login."); //Todo
            req.getRequestDispatcher("/jsp/register.jsp").include(req, res);
            return;
        }

        if(!inputPassword.equals(inputPasswordRepeat)) {
            res.getWriter().print("Passwords don't match."); //Todo
            req.getRequestDispatcher("/jsp/register.jsp").include(req, res);
            return;
        }

        addUser(inputUsername, inputPassword);
        res.sendRedirect("/login");
    }

    private void addUser(String username, String password) throws SQLException {
        getDataAccess().query("insert into user (name, password, creation_date) values (?, ?, ?)")
                .withParam(username)
                .withParam(password)
                .withParam(new Timestamp(System.currentTimeMillis()))
                .run();
    }
}