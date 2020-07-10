package de.dhbwka.studentenfutter.servlets;

import de.dhbwka.studentenfutter.bean.data.IngredientBean;
import de.dhbwka.studentenfutter.bean.data.UserBean;
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

        if (!user.isLoggedIn()) {
            throw new Exception("permission denied");
        }

        var id = req.getParameter("id");

        var count = Float.parseFloat(req.getParameter("numberOfPersons"));
        var dataAccess = getDataAccess();

        //select ingredients from db and multiply by 'numberOfPersons'
        var multipliedIngredients = dataAccess
                .cachedQuery("sql/select/selectRecipeIngredient.sql")
                .withParam(id)
                .collectAs(IngredientBean.class)
                .getList()
                .stream()
                .map(ingredient -> ingredient.multiply(count))
                .collect(Collectors.toList());

        //select current shopping cart
        var shoppingCart = getDataAccess()
                .query("select ingredient, unit, amount from shoppingcart where id_user=?")
                .withParam(user.getId())
                .collectAs(IngredientBean.class)
                .getList();

        //update shopping cart
        var updatedShoppingCart =
                new ArrayList<>(Stream
                .concat(shoppingCart.stream(), multipliedIngredients.stream())
                .collect(Collectors.toMap(
                        ing -> new Pair<>(ing.getName(), ing.getUnit()),
                        Function.identity(),
                        IngredientBean::add)).values());

        //clear
        getDataAccess()
                .query("delete from shoppingcart where id_user=?")
                .withParam(user.getId())
                .run();

        //insert
        getDataAccess()
                .cachedQuery("sql/insert/insertShoppingcart.sql")
                .withParam(user.getId())
                .withBatchSupplier(index -> updatedShoppingCart.get(index).getName())
                .withBatchSupplier(index -> updatedShoppingCart.get(index).getUnit())
                .withBatchSupplier(index -> updatedShoppingCart.get(index).getAmount())
                .runBatch(updatedShoppingCart.size());

        req.setAttribute("shoppingcart", updatedShoppingCart);
        req.getRequestDispatcher("/jsp/shoppingcart.jsp").forward(req, res);
    }
}
