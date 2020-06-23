package de.dhbwka.studentenfutter.servlets;

import de.dhbwka.studentenfutter.bean.UserPasswordBean;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns = "/login")
public class LoginServlet extends AbstractServlet {

    @Override
    protected void handleDoGet(HttpServletRequest req, HttpServletResponse res) throws Exception {
        res.sendRedirect("jsp/login.jsp");
    }

    @Override
    protected void handleDoPost(HttpServletRequest req, HttpServletResponse res) throws Exception {
        String inputUsername = req.getParameter("username");
        String inputPassword = req.getParameter("password");

        res.setContentType("text/html");

        var result = getDataAccess()
                .query("select id_user, password from password where id_user in (select id_user from user where name=?)")
                .withParam(inputUsername)
                .collectAs(UserPasswordBean.class)
                .get();

        if(result.isEmpty() || !result.get().getPassword().equals(inputPassword)) {
            onNoSuccess();
            req.getSession().setAttribute("username_error", "user ist nicht vorhanden"); //todo beans und so
            res.sendRedirect("jsp/login.jsp");
            return;
        }

        HttpSession session = req.getSession();
        session.setAttribute("userId", result.get().getUserId());
        session.setMaxInactiveInterval(60 * 60); // Session expires after 60 minutes
        res.sendRedirect("jsp/index.jsp");
    }

    public void onNoSuccess() {

    }
}