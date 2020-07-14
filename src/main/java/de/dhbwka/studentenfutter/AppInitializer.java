package de.dhbwka.studentenfutter;

import de.dhbwka.studentenfutter.bean.verification.RecipeAddVerificationBean;
import de.dhbwka.studentenfutter.bean.verification.RecipeSearchVerificationBean;
import de.dhbwka.studentenfutter.bean.verification.RegisterVerificationBean;
import de.dhbwka.studentenfutter.database.DatabaseAccess;
import de.dhbwka.studentenfutter.database.DatabaseAccessDescriptor;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.SQLException;

/**
 * Listener to initialize server from @{@link javax.servlet.ServletContext}.
 */
@WebListener()
public class AppInitializer implements ServletContextListener {
    public static final String DATABASE_ACCESS_ACCESS_KEY = "database";
    public static final String REGISTER_VERIFICATION_ACCESS_KEY = "registerVerification";
    public static final String RECIPE_ADD_VERIFICATION_ACCESS_KEY = "recipeAddVerification";
    public static final String RECIPE_SEARCH_VERIFICATION_ACCESS_KEY = "recipeSearchVerification";

    public AppInitializer() { }

    public void contextInitialized(ServletContextEvent sce) {
        var fileRoot = Path.of(System.getProperty("user.home"),"trail-mix", "storage");
        var url = "jdbc:sqlite:" + fileRoot.resolve("studentenfutter.db").toAbsolutePath();
        var dataAccess = new DatabaseAccess(new DatabaseAccessDescriptor(url));

        try {
            Files.createDirectories(fileRoot);
            sce.getServletContext().log("Using '" + fileRoot.getParent() + "' as external data storage.");
            dataAccess.onLoad();
        } catch (IOException | SQLException e) {
            e.printStackTrace();
            //should quit
        }

        var context = sce.getServletContext();
        context.setAttribute(DATABASE_ACCESS_ACCESS_KEY, dataAccess);
        context.setAttribute(REGISTER_VERIFICATION_ACCESS_KEY,
                new RegisterVerificationBean());
        context.setAttribute(RECIPE_ADD_VERIFICATION_ACCESS_KEY,
                new RecipeAddVerificationBean());
        context.setAttribute(RECIPE_SEARCH_VERIFICATION_ACCESS_KEY,
                new RecipeSearchVerificationBean());
    }
}
