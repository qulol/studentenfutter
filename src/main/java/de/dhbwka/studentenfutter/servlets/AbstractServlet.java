package de.dhbwka.studentenfutter.servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public abstract class AbstractServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            actualDoGet(req, resp);
        } catch (Exception e) {
            e.printStackTrace(); //log
            if(resp.isCommitted()) {
                return;
            }
            resp.sendRedirect("/jsp/error.jsp");
        }
    }

    protected void actualDoGet(HttpServletRequest req, HttpServletResponse res) throws Exception {
        //log no implementation of get method
        req.getRequestDispatcher("/jsp/error.jsp").forward(req, res);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            actualDoPost(req, resp);
        } catch (Exception e) {
            e.printStackTrace(); //log
            if(resp.isCommitted()) {
               return;
            }
            resp.sendRedirect("/jsp/error.jsp");
        }
    }

    protected void actualDoPost(HttpServletRequest req, HttpServletResponse res) throws Exception {
        //log no implementation of get method
        req.getRequestDispatcher("/jsp/error.jsp").forward(req, res);
    }
}
