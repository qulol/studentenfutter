package de.dhbwka.studentenfutter.servlets;

import de.dhbwka.studentenfutter.AppInitializer;
import de.dhbwka.studentenfutter.database.DatabaseAccess;
import de.dhbwka.studentenfutter.util.ServletMethodNotImplementedException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public abstract class AbstractServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        try {
            handleDoGet(req, res);
        } catch (Exception e) {
            getServletContext().log("ServletError", e);
            if(res.isCommitted()) {
                return;
            }
            res.sendRedirect("/jsp/error.jsp");
        }
    }

    protected void handleDoGet(HttpServletRequest req, HttpServletResponse res) throws Exception {
        throw new ServletMethodNotImplementedException(req);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
        try {
            handleDoPost(req, res);
        } catch (Exception e) {
            getServletContext().log("ServletError", e);
            if(res.isCommitted()) {
               return;
            }
            res.sendRedirect("/jsp/error.jsp");
        }
    }

    protected void handleDoPost(HttpServletRequest req, HttpServletResponse res) throws Exception {
        throw new ServletMethodNotImplementedException(req);
    }

    protected DatabaseAccess getDataAccess() {
        return (DatabaseAccess) getServletContext().getAttribute(AppInitializer.DATABASE_ACCESS_ACCESS_KEY);
    }
}