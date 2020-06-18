package de.dhbwka.studentenfutter.servlets;

import de.dhbwka.studentenfutter.bean.TestBean;
import de.dhbwka.studentenfutter.database.DatabaseAccess;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(urlPatterns = "/index")
public class IndexServlet extends AbstractServlet {

    @Override
    protected void handleDoGet(HttpServletRequest req, HttpServletResponse res) throws Exception {
        System.out.println(
        ((DatabaseAccess) req.getServletContext().getAttribute("database"))
                .run("select password, id_password from password where id_user=?")
                .withParam("1").encodeAs(TestBean.class).get());

        req.getRequestDispatcher("/jsp/index.jsp").forward(req, res);
    }
}
