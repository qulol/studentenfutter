package de.dhbwka.studentenfutter.servlets;

import de.dhbwka.studentenfutter.bean.DescriptionBean;
import de.dhbwka.studentenfutter.bean.IngredientBean;
import de.dhbwka.studentenfutter.bean.UserBean;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet(urlPatterns = "/add")
@MultipartConfig
public class RecipeAddServlet extends AbstractServlet {
    private static final int maxIngredientCount =   10;
    private static final int maxDescriptionCount =  10;

    @Override
    protected void handleDoGet(HttpServletRequest req, HttpServletResponse res) throws Exception {
        req.setAttribute("maxIngredientCount", maxIngredientCount);
        req.setAttribute("maxDescriptionCount", maxDescriptionCount);
        req.getRequestDispatcher(req.getContextPath().concat("/jsp/recipe_add.jsp")).forward(req, res);
    }

    @Override
    protected void handleDoPost(HttpServletRequest req, HttpServletResponse res) throws Exception {
        var ingredientCount = Integer.parseInt(req.getParameter("ingredientCount"));
        var descriptionCount = Integer.parseInt(req.getParameter("descriptionCount"));
        var user = (UserBean)req.getSession().getAttribute("user");

        var name = req.getParameter("name");
        var img = req.getPart("img");
        //todo save img under recipe id
        var category = req.getParameter("category");

        List<IngredientBean> ingredients = new ArrayList<>();
        for (int i = 1; i <= ingredientCount; i++) {
            var ingredientAmount = req.getParameter("amount" + i);
            var ingredientUnit   = req.getParameter("unit" + i);
            var ingredientName = req.getParameter("ingredient" + i);

            //set max count for malicious data
            //check for invalid data (empty string, high numbers)
            ingredients.add(new IngredientBean(ingredientName, ingredientUnit, Float.parseFloat(ingredientAmount)));
        }

        List<DescriptionBean> descriptions = new ArrayList<>();
        for (int i = 1; i <= descriptionCount; i++) {
            descriptions.add( new DescriptionBean(i, req.getParameter("description" + i)));
        }

        var db = getDataAccess();
        var id = db.cachedQuery("sql/insert/insertRecipe.sql")
                .withParam(user.getUsername())
                .withParam(name)
                .withParam(category)
                .collectGeneratedKey()
                .orElseThrow(SQLException::new);

        //todo description into separate table..

        db.cachedQuery("sql/insert/insertRecipeDescription.sql")
                .withParam(id)
                .withBatchSupplier(index -> descriptions.get(index).getId())
                .withBatchSupplier(index -> descriptions.get(index).getDescription())
                .runBatch(descriptions.size());

        db.cachedQuery("sql/insert/insertRecipeIngredient.sql")
                .withParam(id)
                .withBatchSupplier(index -> ingredients.get(index).getAmount())
                .withBatchSupplier(index -> ingredients.get(index).getUnit())
                .withBatchSupplier(index -> ingredients.get(index).getName())
                .runBatch(ingredients.size()); //check actual count all 3 param != null !

        res.sendRedirect(req.getContextPath().concat("/recipedetail?id=" + id + "#ingredientsTab"));
    }
}