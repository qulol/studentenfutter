package de.dhbwka.studentenfutter.servlets;

import de.dhbwka.studentenfutter.bean.IngredientBean;
import de.dhbwka.studentenfutter.bean.UserBean;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/shoppingcart")
public class ShoppingCartServlet extends AbstractServlet {

    @Override
    protected void handleDoGet(HttpServletRequest req, HttpServletResponse res) throws Exception {
        var user = (UserBean) req.getSession().getAttribute("user");
        var shoppingcart = getDataBaseAccess()
                .query("select ingredient, unit, amount from shoppingcart where id_user=?")
                .withParam(user.getId())
                .collectAs(IngredientBean.class)
                .getList();

        req.setAttribute("shoppingcart", shoppingcart);
        req.getRequestDispatcher("/jsp/shoppingcart.jsp").forward(req, res);
    }
}
