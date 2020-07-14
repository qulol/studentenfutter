package de.dhbwka.studentenfutter.servlets;

import de.dhbwka.studentenfutter.bean.data.DescriptionBean;
import de.dhbwka.studentenfutter.bean.data.IngredientBean;
import de.dhbwka.studentenfutter.bean.data.UserBean;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@WebServlet(urlPatterns = "/add")
@MultipartConfig
public class RecipeAddServlet extends AbstractServlet {
    private static final int maxIngredientCount =   15;
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
        var category = req.getParameter("category");
        var shortDescription = req.getParameter("shortDescription");

        var ingredients = IntStream
                .rangeClosed(1, ingredientCount)
                .mapToObj(index -> {
                    var ingredientName = req.getParameter("ingredient" + index);
                    var ingredientUnit   = req.getParameter("unit" + index);
                    var ingredientAmount = Float.parseFloat(req.getParameter("amount" + index));
                    return new IngredientBean(ingredientName, ingredientUnit, ingredientAmount); })
                .collect(Collectors.toList());

        var descriptions = IntStream
                .rangeClosed(1, descriptionCount)
                .mapToObj(index -> new DescriptionBean(index, req.getParameter("description" + index)))
                .collect(Collectors.toList());

        var db = getDataAccess();
        var id = db.cachedQuery("sql/insert/insertRecipe.sql")
                .withParam(user.getUsername())
                .withParam(name)
                .withParam(category)
                .withParam(shortDescription)
                .collectGeneratedKey()
                .orElseThrow(SQLException::new);

        if (img.getContentType().equals("image/jpeg")
                || img.getContentType().equals("image/png")) {
            //only if image is valid 'more or less'
            db.cachedQuery("sql/insert/insertRecipeImage.sql")
                    .withParam(id)
                    .withParam(img.getContentType())
                    .withParam(img.getInputStream().readAllBytes())
                    .run();
        }

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
                .runBatch(ingredients.size());

        res.sendRedirect(req.getContextPath().concat("/recipedetail?id=" + id + "#ingredientsTab"));
    }
}