package de.dhbwka.studentenfutter.servlets;

import de.dhbwka.studentenfutter.database.DatabaseAccess;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns = "/login")
public class LoginServlet extends AbstractServlet {

    @Override
    protected void handleDoGet(HttpServletRequest req, HttpServletResponse res) throws Exception {
    }

    @Override
    protected void handleDoPost(HttpServletRequest req, HttpServletResponse res) throws Exception {
        String enteredUsername = req.getParameter("username");
        String enteredPassword = req.getParameter("password");

        res.setContentType("text/html");

        DatabaseAccess access = getDataAccess();

        var user = access
                .query("select id_user from user where name=?")
                .withParam(enteredUsername)
                .collectAs(Integer.class).get();

        if (user.isPresent()) {
            var userId = user.get();
            var password = access
                    .query("select password from password where id_user=?")
                    .withParam(userId)
                    .collectAs(String.class).get();

            if (password.isPresent()) {
                var pass = password.get();

                if(pass.equals(enteredPassword)) {
                    HttpSession session = req.getSession();
                    session.setAttribute("userId", userId);
                    session.setMaxInactiveInterval(60 * 60); // Session expires after 60 minutes

                    res.sendRedirect("index");
                }
            }
        }
    }
}