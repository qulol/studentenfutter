package de.dhbwka.studentenfutter.servlets;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(urlPatterns = "/index")
public class IndexServlet extends AbstractServlet {

    @Override
    protected void actualDoGet(HttpServletRequest req, HttpServletResponse res) throws Exception {
        System.out.println("hello");

        req.getRequestDispatcher("/jsp/index.jsp").forward(req, res);
    }
}
