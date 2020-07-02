package de.dhbwka.studentenfutter.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/files/images/recipe")
public class RecipeImageFileServlet extends AbstractServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        var id = req.getParameter("id");
        var fileAccess = getFileAccess();

        res.setContentType("image/jpeg");
        res.getOutputStream().write(fileAccess.readFile(fileAccess.getRecipeImageRoot().resolve("default/recipe_default.jpg")));

    }
}
