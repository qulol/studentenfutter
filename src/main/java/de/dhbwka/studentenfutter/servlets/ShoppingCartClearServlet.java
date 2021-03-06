package de.dhbwka.studentenfutter.servlets;

import de.dhbwka.studentenfutter.bean.data.IngredientBean;
import de.dhbwka.studentenfutter.bean.data.UserBean;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

@WebServlet(urlPatterns = "/clearshoppingcart")
public class ShoppingCartClearServlet extends AbstractServlet {

    @Override
    protected void handleDoGet(HttpServletRequest req, HttpServletResponse res) throws Exception {
        var user = (UserBean)req.getSession().getAttribute("user");

        if (!user.isLoggedIn()) {
            throw new Exception("permission denied");
        }

        getDataAccess()
                .query("delete from shoppingcart where id_user=?")
                .withParam(user.getId())
                .run();

        res.sendRedirect("/shoppingcart");
    }
}
