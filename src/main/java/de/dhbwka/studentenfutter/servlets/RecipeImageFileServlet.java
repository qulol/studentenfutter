package de.dhbwka.studentenfutter.servlets;

import de.dhbwka.studentenfutter.bean.data.RecipeImageBean;
import de.dhbwka.studentenfutter.util.FilesUtility;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/files/images/recipe")
public class RecipeImageFileServlet extends AbstractServlet {

    @Override
    protected void handleDoGet(HttpServletRequest req, HttpServletResponse res) throws Exception {
        var id = req.getParameter("id");
        var dataAccess = getDataAccess();

        var image = dataAccess.cachedQuery("sql/select/selectRecipeImage.sql")
                .withParam(id)
                .collectAs(RecipeImageBean.class)
                .get()
                .or(() -> {
                    var context = getServletContext();
                    var imgLocation = context.getRealPath("/images/recipe_default.jpg");
                    return FilesUtility
                            .readFile(imgLocation)
                            .map(content -> new RecipeImageBean(context.getMimeType(imgLocation), content));
                }).orElseThrow(IOException::new);

        res.setContentType(image.getContentType());
        res.getOutputStream().write(image.getContent());
    }
}
