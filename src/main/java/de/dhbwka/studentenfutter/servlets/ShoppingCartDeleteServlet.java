package de.dhbwka.studentenfutter.servlets;

import de.dhbwka.studentenfutter.bean.UserBean;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/deleteshoppingcart")
public class ShoppingCartDeleteServlet extends AbstractServlet {

    @Override
    protected void handleDoGet(HttpServletRequest req, HttpServletResponse res) throws Exception {
        var shoppingCart = ((UserBean)req.getSession().getAttribute("user"));
        shoppingCart.getShoppingCard().clear();
        res.sendRedirect("/shoppingcart");
    }
}
