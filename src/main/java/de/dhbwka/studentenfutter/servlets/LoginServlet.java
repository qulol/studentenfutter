package de.dhbwka.studentenfutter.servlets;

import de.dhbwka.studentenfutter.bean.UserBean;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/login")
public class LoginServlet extends AbstractServlet {

    @Override
    protected void handleDoGet(HttpServletRequest req, HttpServletResponse res) throws Exception {
        req.getRequestDispatcher(req.getContextPath().concat("/jsp/login.jsp")).forward(req, res);
    }

    @Override
    protected void handleDoPost(HttpServletRequest req, HttpServletResponse res) throws Exception {
        String inputUsername = req.getParameter("username");
        String inputPassword = req.getParameter("password");

        var optionalUserBean = getDataAccess()
                .query("select id_user, name, password from user where name=?")
                .withParam(inputUsername)
                .collectAs(UserBean.class)
                .get();

        if(optionalUserBean.isEmpty() || !optionalUserBean.get().getPassword().equals(inputPassword)) {
            req.setAttribute("login_error", true);
            req.getRequestDispatcher(req.getContextPath().concat("/jsp/login.jsp")).forward(req, res);
            return;
        }

        req.getSession().setAttribute("user", optionalUserBean.get());
        res.sendRedirect(req.getContextPath().concat("/index"));
    }
}