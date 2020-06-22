package de.dhbwka.studentenfutter.servlets;

import de.dhbwka.studentenfutter.database.DatabaseAccess;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.sql.Timestamp;

@WebServlet(urlPatterns = "/register")
public class RegisterServlet extends AbstractServlet {

    @Override
    protected void handleDoGet(HttpServletRequest req, HttpServletResponse res) throws Exception {
    }

    @Override
    protected void handleDoPost(HttpServletRequest req, HttpServletResponse res) throws Exception {
        String enteredUsername = req.getParameter("username");
        String enteredPassword = req.getParameter("password");
        String passwordRepeat = req.getParameter("password_repeat");

        res.setContentType("text/html");

        var userExists =
                getDataAccess().query("select id_user from user where name=?")
                .withParam(enteredUsername).collectAs(String.class).get().isPresent();

        if(userExists) {
            res.getWriter().print("User already exists. Please login."); //Todo
            req.getRequestDispatcher("/register.html").include(req, res);
            return;
        }

        if(!enteredPassword.equals(passwordRepeat)) {
            res.getWriter().print("Passwords don't match."); //Todo
            req.getRequestDispatcher("/register.html").include(req, res);
            return;
        }

        if (addUser(enteredUsername, enteredPassword)) {
            res.sendRedirect("login.html");
        }
    }

    private boolean addUser(String username, String password) throws SQLException {
        DatabaseAccess access = getDataAccess();

        access.query("insert into user (name, creation_date) values (?, ?)")
                .withParam(username)
                .withParam(new Timestamp(System.currentTimeMillis()))
                .run();

        var userId = access.query("select id_user from user where name=?")
                .withParam(username)
                .collectAs(Integer.class).get().get();

        access.query("insert into password (id_user, password) values (?, ?)")
                .withParam(userId)
                .withParam(password)
                .run();
        return true;
    }
}