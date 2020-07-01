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
import java.util.stream.Stream;

@WebServlet(urlPatterns = "/addtoshoppingcard")
public class ShoppingCartAddServlet extends AbstractServlet {

    @Override
    protected void handleDoPost(HttpServletRequest req, HttpServletResponse res) throws Exception {
        var user = (UserBean) req.getSession().getAttribute("user");
        var id = req.getParameter("id");

        var count = Float.parseFloat(req.getParameter("numberOfPersons"));
        var shoppingCart = user.getShoppingCard();
        var dataAccess = getDataAccess();

        var multipliedIngredients = dataAccess
                .cachedQuery("sql/select/selectRecipeIngredient.sql")
                .withParam(id)
                .collectAs(IngredientBean.class)
                .getList()
                .stream()
                .map(ingredient -> ingredient.multiply(count))
                .collect(Collectors.toList());

        var updatedIngredients =
                new ArrayList<>(Stream
                .concat(shoppingCart.getIngredients().stream(), multipliedIngredients.stream())
                .collect(Collectors.toMap(
                        ing -> new Pair<>(ing.getName(), ing.getUnit()),
                        Function.identity(),
                        IngredientBean::add)).values());

        shoppingCart.setIngredients(updatedIngredients);
        res.sendRedirect("/shoppingcart");
    }
}
