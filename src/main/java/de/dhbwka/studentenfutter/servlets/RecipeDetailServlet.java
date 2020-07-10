package de.dhbwka.studentenfutter.servlets;

import de.dhbwka.studentenfutter.bean.data.DescriptionBean;
import de.dhbwka.studentenfutter.bean.data.IngredientBean;
import de.dhbwka.studentenfutter.bean.data.RecipeBean;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Comparator;
import java.util.stream.Collectors;

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
                .getList()
                .stream()
                .sorted(Comparator.comparing(DescriptionBean::getId))
                .collect(Collectors.toList());

        var recipeBean = optionalRecipeBean.get();
        recipeBean.setIngredients(ingredientBean);
        recipeBean.setDescriptions(descriptionBean);

        req.setAttribute("recipe", recipeBean);
        req.getRequestDispatcher(req.getContextPath().concat("/jsp/recipe_detail.jsp")).forward(req, res);
    }
}
