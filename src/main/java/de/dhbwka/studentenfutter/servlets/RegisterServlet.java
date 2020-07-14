package de.dhbwka.studentenfutter.servlets;

import de.dhbwka.studentenfutter.bean.verification.RegisterVerificationBean;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/register")
public class RegisterServlet extends AbstractServlet {

    @Override
    protected void handleDoGet(HttpServletRequest req, HttpServletResponse res) throws Exception {
        req.getRequestDispatcher(req.getContextPath().concat("/jsp/register.jsp")).forward(req, res);
    }

    @Override
    protected void handleDoPost(HttpServletRequest req, HttpServletResponse res) throws Exception {
        var inputUsername = req.getParameter("username");
        var inputPassword = req.getParameter("password");
        var inputPasswordRepeat = req.getParameter("password_repeat");
        var verification = (RegisterVerificationBean)getServletContext()
                .getAttribute("registerVerification");


        if (!verification.isValidUsername(inputUsername)) {
            req.setAttribute("register_error", verification.getUsernameVerificationMessage());
            req.getRequestDispatcher(req.getContextPath().concat("/jsp/register.jsp")).forward(req, res);
            return;
        }

        if (!verification.isValidPassword(inputPassword)) {
            req.setAttribute("register_error", verification.getPasswordVerificationMessage());
            req.getRequestDispatcher(req.getContextPath().concat("/jsp/register.jsp")).forward(req, res);
            return;
        }

        var db = getDataAccess();

        var userExists =
                db.query("select id_user from user where name=?")
                .withParam(inputUsername).collectAs(Integer.class).get().isPresent();

        if(userExists) {
            req.setAttribute("register_error", "Der Benutzername ist bereits vergeben.");
            req.getRequestDispatcher(req.getContextPath().concat("/jsp/register.jsp")).forward(req, res);
            return;
        }

        if(!inputPassword.equals(inputPasswordRepeat)) {
            req.setAttribute("register_error", "Die Passwörter stimmen nicht überein.");
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