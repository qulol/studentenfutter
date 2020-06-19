package de.dhbwka.studentenfutter.servlets;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(urlPatterns = "/index")
public class IndexServlet extends AbstractServlet {

    @Override
    protected void handleDoGet(HttpServletRequest req, HttpServletResponse res) throws Exception {
        var userId = "1"; //req.getParameter("userId");

       var name =
        getDataAccess().query("select name from user where id_user=?")
                .withParam(userId).runAs(String.class).get().get();
       req.getSession().setAttribute("username", name);

       req.getRequestDispatcher("/jsp/index.jsp").forward(req, res);
    }
}
