package de.dhbwka.studentenfutter.servlets;

import de.dhbwka.studentenfutter.bean.IngredientBean;
import de.dhbwka.studentenfutter.bean.UserBean;
import de.dhbwka.studentenfutter.util.Pair;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.function.Function;
import java.util.stream.Collectors;

@WebServlet(urlPatterns = "/addtoshoppingcard")
public class ShoppingCartAddToServlet extends AbstractServlet {

    @Override
    protected void handleDoPost(HttpServletRequest req, HttpServletResponse res) throws Exception {
        var id = req.getParameter("id");
        var count = Float.parseFloat(req.getParameter("numberOfPersons"));
        var user = (UserBean) req.getSession().getAttribute("user");
        var shoppingCart = user.getShoppingCard();

        var multipliedIngredients = getDataAccess()
                .cachedQuery("sql/select/selectRecipeIngredient.sql")
                .withParam(id)
                .collectAs(IngredientBean.class)
                .getList()
                .stream()
                .map(ingredient -> ingredient.multiply(count))
                .collect(Collectors.toList());

        shoppingCart.addAll(multipliedIngredients);
        shoppingCart = new ArrayList<>(shoppingCart
                .stream()
                .collect(Collectors.toMap(
                        ing -> new Pair<>(ing.getName(), ing.getUnit()),
                        Function.identity(),
                        IngredientBean::add)).values());

        user.setShoppingCard(shoppingCart);
        res.sendRedirect("/recipedetail?id=".concat(id).concat("#ingredientsTab"));
    }
}
