package de.dhbwka.studentenfutter.servlets;


import de.dhbwka.studentenfutter.bean.IngredientsListBean;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/shoppingcart")
public class ShoppingCartServlet extends AbstractServlet {

    @Override
    protected void handleDoGet(HttpServletRequest req, HttpServletResponse res) throws Exception {
        IngredientsListBean ingredients = (IngredientsListBean) req.getSession().getAttribute("ingredientsList");

        req.getRequestDispatcher("/jsp/shoppingcart.jsp").forward(req, res);
    }
}