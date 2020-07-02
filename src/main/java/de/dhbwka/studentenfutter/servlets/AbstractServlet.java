package de.dhbwka.studentenfutter.servlets;

import de.dhbwka.studentenfutter.storage.DataAccess;
import de.dhbwka.studentenfutter.storage.file.FileAccess;
import de.dhbwka.studentenfutter.storage.database.DatabaseAccess;
import de.dhbwka.studentenfutter.util.ServletMethodNotImplementedException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public abstract class AbstractServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        try {
            handleDoGet(req, res);
        } catch (Exception e) {
            e.printStackTrace(); //log
            if(res.isCommitted()) {
                return;
            }
            res.sendRedirect("/jsp/error.jsp");
        }
    }

    protected void handleDoGet(HttpServletRequest req, HttpServletResponse res) throws Exception {
        //logging
        throw new ServletMethodNotImplementedException(req);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        try {
            handleDoPost(req, res);
        } catch (Exception e) {
            e.printStackTrace(); //log
            if(res.isCommitted()) {
               return;
            }
            res.sendRedirect("/jsp/error.jsp");
        }
    }

    protected void handleDoPost(HttpServletRequest req, HttpServletResponse res) throws Exception {
        //logging
        throw new ServletMethodNotImplementedException(req);
    }

    protected DatabaseAccess getDataBaseAccess() {
        return getDataAccess().getDatabaseAccess();
    }

    protected FileAccess getFileAccess() {
        return getDataAccess().getFileAccess();
    }

    protected DataAccess getDataAccess() {
        return (DataAccess) getServletContext().getAttribute(DataAccess.ATTRIBUTE_ACCESS_KEY);
    }
}