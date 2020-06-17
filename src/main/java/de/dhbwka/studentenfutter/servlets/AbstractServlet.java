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
            handleDoGet(req, resp);
        } catch (Exception e) {
            e.printStackTrace(); //log
            if(resp.isCommitted()) {
                return;
            }
            resp.sendRedirect("/error.html");
        }
    }

    protected void handleDoGet(HttpServletRequest req, HttpServletResponse res) throws Exception {
        //log no implementation of get method
        req.getRequestDispatcher("/error.html").forward(req, res);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            handleDoPost(req, resp);
        } catch (Exception e) {
            e.printStackTrace(); //log
            if(resp.isCommitted()) {
               return;
            }
            resp.sendRedirect("/error.html");
        }
    }

    protected void handleDoPost(HttpServletRequest req, HttpServletResponse res) throws Exception {
        //log no implementation of get method
        req.getRequestDispatcher("/error.html").forward(req, res);
    }
}
