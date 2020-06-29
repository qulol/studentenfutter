package de.dhbwka.studentenfutter.servlets;

import de.dhbwka.studentenfutter.bean.DescriptionBean;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet(urlPatterns = "/add")
@MultipartConfig
public class RecipeAddServlet extends AbstractServlet {
    private static final int maxIngredientCount =   10;
    private static final int maxInstructionCount =  10;

    @Override
    protected void handleDoGet(HttpServletRequest req, HttpServletResponse res) throws Exception {
        req.getRequestDispatcher(req.getContextPath().concat("/jsp/recipe_add.jsp")).forward(req, res);
    }

    @Override
    protected void handleDoPost(HttpServletRequest req, HttpServletResponse res) throws Exception {
        var name = req.getParameter("name");
        var img = req.getPart("img");
        var category = req.getParameter("category");

        List<Float> amounts = new ArrayList<>();
        List<String> units = new ArrayList<>();
        List<String> ingredients = new ArrayList<>();
        for (int i = 0; i < maxIngredientCount; i++) {
            var amount = req.getParameter("amount" + i);
            var unit   = req.getParameter("unit" + i);
            var ingredient = req.getParameter("ingredient" + i);

            amounts.add(Float.parseFloat(amount));
            units.add(unit);
            ingredients.add(ingredient);
        }

        var seasons = Arrays.stream(req.getParameter("seasons")
                .split(","))
                .map(String::stripLeading)
                .map(String::stripTrailing)
                .collect(Collectors.toList());

        List<DescriptionBean> descriptions = new ArrayList<>();
        for (int i = 0; i < maxInstructionCount; i++) {
            descriptions.add( new DescriptionBean(i, req.getParameter("instructionStep" + i)));
        }

        //checks

        var db = getDataAccess();
        var id = db.cachedQuery("sql/insert/insertRecipe.sql")
                .withParam(null) //user
                .withParam(name)
                .withParam(category)
                .collectGeneratedKey().get();

        db.cachedQuery("sql/insert/insertRecipeDescription.sql")
                .withParam(id)
                .withBatchSupplier(index -> descriptions.get(index).getId())
                .withBatchSupplier(index -> descriptions.get(index).getDescription())
                .runBatch(descriptions.size());

        db.cachedQuery("sql/insert/insertRecipeSeason.sql")
                .withParam(id)
                .withBatchSupplier(seasons::get)
                .runBatch(seasons.size());

        db.cachedQuery("sql/insert/insertRecipeIngredient.sql")
                .withParam(id)
                .withBatchSupplier(amounts::get)
                .withBatchSupplier(units::get)
                .withBatchSupplier(ingredients::get)
                .runBatch(ingredients.size()); //check actual count all 3 param != null !

        res.sendRedirect(req.getContextPath().concat("/recipedetail?id=" + id + "#ingredientsTab"));
    }
}