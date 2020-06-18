package de.dhbwka.studentenfutter.servlets;

import de.dhbwka.studentenfutter.bean.Recipe;
import de.dhbwka.studentenfutter.database.DatabaseAccess;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(urlPatterns = "/index")
public class IndexServlet extends AbstractServlet {

    @Override
    protected void handleDoGet(HttpServletRequest req, HttpServletResponse res) throws Exception {
        var userId = "1"; //req.getParameter("userId");

        System.out.println(
        getDataAccess().query("select name from user where id_user=?")
                .withParam(userId).encodeAs(Recipe.class).get().get());

        req.getRequestDispatcher("/jsp/index.jsp").forward(req, res);
    }
}
