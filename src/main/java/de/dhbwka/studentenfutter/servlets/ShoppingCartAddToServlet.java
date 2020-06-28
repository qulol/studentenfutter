package de.dhbwka.studentenfutter.servlets;

import de.dhbwka.studentenfutter.bean.IngredientBean;
import de.dhbwka.studentenfutter.bean.IngredientsListBean;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@WebServlet(urlPatterns = "/addtoshoppingcard")
public class ShoppingCartAddToServlet extends AbstractServlet {

    @Override
    protected void handleDoPost(HttpServletRequest req, HttpServletResponse res) throws Exception {
        res.sendRedirect("/recipedetail?id=".concat(req.getParameter("id").concat("#ingredientsTab")));

        var recipeId = req.getParameter("id");

        var db = getDataAccess();

        List<IngredientBean> ingredients = db
                .cachedQuery("sql/selectRecipeIngredient")
                .withParam(recipeId)
                .collectAs(IngredientBean.class)
                .getList();

        IngredientsListBean ingredientsListBean = new IngredientsListBean(ingredients);

        req.getSession().setAttribute("ingredientsList", ingredientsListBean);
    }
}