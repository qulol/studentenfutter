package de.dhbwka.studentenfutter.servlets;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/recipes")
public class RecipeListServlet extends AbstractServlet {

    @Override
    protected void handleDoGet(HttpServletRequest req, HttpServletResponse res) throws Exception {
        var search = req.getParameter("search").stripLeading().stripTrailing();

        //if category match

        //search recipe names & id's

        req.getRequestDispatcher("/jsp/recipes_list.jsp").forward(req, res);
    }
}
