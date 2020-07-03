package de.dhbwka.studentenfutter.servlets;

import de.dhbwka.studentenfutter.bean.RecipeImageBean;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.nio.file.Files;
import java.nio.file.Path;

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
                .orElse(new RecipeImageBean("image/jpg", Files.readAllBytes(Path.of("C:\\Users\\alex\\DHBW\\studentenfutter\\src\\main\\resources\\recipe_default.jpg"))));

        res.setContentType(image.getContentType());
        res.getOutputStream().write(image.getContent());
    }
}
