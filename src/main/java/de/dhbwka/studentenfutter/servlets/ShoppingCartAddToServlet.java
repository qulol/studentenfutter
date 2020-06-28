package de.dhbwka.studentenfutter.servlets;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/addtoshoppingcard")
public class ShoppingCartAddToServlet extends AbstractServlet {

    @Override
    protected void handleDoPost(HttpServletRequest req, HttpServletResponse res) throws Exception {
        res.sendRedirect("/recipedetail?id=".concat(req.getParameter("id").concat("#ingredientsTab")));
    }
}
