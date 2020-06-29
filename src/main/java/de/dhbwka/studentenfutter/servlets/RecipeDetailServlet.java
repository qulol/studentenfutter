package de.dhbwka.studentenfutter.servlets;

import de.dhbwka.studentenfutter.bean.DescriptionBean;
import de.dhbwka.studentenfutter.bean.IngredientBean;
import de.dhbwka.studentenfutter.bean.RecipeBean;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Comparator;

@WebServlet(urlPatterns = "/recipedetail")
public class RecipeDetailServlet extends AbstractServlet {

    @Override
    protected void handleDoGet(HttpServletRequest req, HttpServletResponse res) throws Exception {
        var id = req.getParameter("id");

        var db = getDataAccess();
        var optionalRecipeBean = db
                .cachedQuery("sql/select/selectRecipe.sql")
                .withParam(id)
                .collectAs(RecipeBean.class)
                .get();

        if (optionalRecipeBean.isEmpty()) {
           throw new Exception("No recipe with id=" + id);
        }

        var ingredientBean = db
                .cachedQuery("sql/select/selectRecipeIngredient.sql")
                .withParam(id)
                .collectAs(IngredientBean.class)
                .getList();
        var descriptionBean = db
                .cachedQuery("sql/select/selectRecipeDescription.sql")
                .withParam(id)
                .collectAs(DescriptionBean.class)
                .getList();

        descriptionBean.sort(Comparator.comparing(DescriptionBean::getId));

        var recipeBean = optionalRecipeBean.get();
        recipeBean.setIngredients(ingredientBean);
        recipeBean.setDescriptions(descriptionBean);

        req.setAttribute("recipe", recipeBean);
        req.getRequestDispatcher(req.getContextPath().concat("/jsp/recipe_detail.jsp")).forward(req, res);
    }
}
