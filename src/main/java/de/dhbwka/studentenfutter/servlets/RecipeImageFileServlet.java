package de.dhbwka.studentenfutter.servlets;

import de.dhbwka.studentenfutter.util.PathUtility;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/files/images/recipe")
public class RecipeImageFileServlet extends AbstractServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        var id = req.getParameter("id");
        var fileAccess = getFileAccess();

        res.setContentType("image/jpeg");
        res.getOutputStream()
                .write(fileAccess
                        .readFile(PathUtility
                                .findFirstStartsWith(fileAccess.getRecipeImageRoot(), "recipe_1").get()));
    }
}
