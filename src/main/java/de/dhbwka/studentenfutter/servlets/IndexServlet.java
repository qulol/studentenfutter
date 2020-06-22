package de.dhbwka.studentenfutter.servlets;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(urlPatterns = {"/", "/index"})
@MultipartConfig //need for retrieving multipart/form-data
public class IndexServlet extends AbstractServlet {

    @Override
    protected void handleDoPost(HttpServletRequest req, HttpServletResponse res) throws Exception {
        System.out.println(req.getPart("img").getContentType()); //getHeader("content-disposition")); //get filename in javax 3.0
        res.reset();
    }

    @Override
    protected void handleDoGet(HttpServletRequest req, HttpServletResponse res) throws Exception {
        var userId = "1"; //req.getParameter("userId");


        var name =
                getDataAccess().query("select name from user where id_user=?")
                        .withParam(userId).collectAs(String.class).get().get();
        req.getSession().setAttribute("username", name);

        req.getRequestDispatcher("/jsp/index.jsp").forward(req, res);
    }
}
