package de.dhbwka.studentenfutter.servlets;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/categories")
public class RecipeCategoryServlet extends AbstractServlet {
    @Override
    protected void handleDoGet(HttpServletRequest req, HttpServletResponse res) throws Exception {
        req.getRequestDispatcher(req.getContextPath().concat("/jsp/categories.jsp")).forward(req, res);
    }
}
