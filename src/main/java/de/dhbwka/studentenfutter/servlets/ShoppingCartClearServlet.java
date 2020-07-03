package de.dhbwka.studentenfutter.servlets;

import de.dhbwka.studentenfutter.bean.IngredientBean;
import de.dhbwka.studentenfutter.bean.UserBean;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

@WebServlet(urlPatterns = "/clearshoppingcart")
public class ShoppingCartClearServlet extends AbstractServlet {

    @Override
    protected void handleDoGet(HttpServletRequest req, HttpServletResponse res) throws Exception {
        var user = (UserBean)req.getSession().getAttribute("user");

        getDataAccess()
                .query("delete from shoppingcart where id_user=?")
                .withParam(user.getId())
                .run();

        req.setAttribute("shoppingcart", new ArrayList<IngredientBean>());
        req.getRequestDispatcher("/jsp/shoppingcart.jsp").forward(req, res);
    }
}
