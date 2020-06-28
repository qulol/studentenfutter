package de.dhbwka.studentenfutter.servlets;

import de.dhbwka.studentenfutter.bean.RecipeCardBean;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/recipes")
public class RecipeListServlet extends AbstractServlet {

    @Override
    protected void handleDoGet(HttpServletRequest req, HttpServletResponse res) throws Exception {
        var search = req.getParameter("search").stripLeading().stripTrailing();

        //only search for category atm
        var recipes = getDataAccess()
                .cachedQuery("sql/selectRecipeCard.sql")
                .withParam(search)
                .collectAs(RecipeCardBean.class)
                .getList();

        req.setAttribute("recipes", recipes);
        req.getRequestDispatcher("/jsp/recipes_list.jsp").forward(req, res);
    }
}
