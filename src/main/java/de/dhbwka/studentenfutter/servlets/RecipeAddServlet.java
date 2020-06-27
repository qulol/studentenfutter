package de.dhbwka.studentenfutter.servlets;

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

            //check

            amounts.add(10f);
            units.add(unit);
            ingredients.add(ingredient);
        }

        var seasons = Arrays.stream(req.getParameter("seasons")
                .split(","))
                .map(String::stripLeading)
                .map(String::stripTrailing)
                .collect(Collectors.toList());

        List<String> instructions = new ArrayList<>();
        for (int i = 0; i < maxInstructionCount; i++) {
            instructions.add(req.getParameter("instructionStep" + i));
        }

        //checks

        var db = getDataAccess();
        var id = db.cachedQuery("sql/insertRecipe.sql")
                .withParam(null) //user
                .withParam(name)
                .withParam(category)
                .withParams(instructions)
                .collectGeneratedKey().get();

        db.query("insert into recipe_ingredient_entity (id_recipe, amount, unit, ingredient) VALUES (?, ?, ?, ?)")
                .withParam(id)
                .withBatchSupplier(amounts::get)
                .withBatchSupplier(units::get)
                .withBatchSupplier(ingredients::get)
                .runBatch(ingredients.size()); //check actual count all 3 param != null !

        res.sendRedirect(req.getContextPath().concat("/jsp/recipe_detail.jsp"));
    }
}
