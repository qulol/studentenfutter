package de.dhbwka.studentenfutter;

import de.dhbwka.studentenfutter.database.DatabaseAccess;
import de.dhbwka.studentenfutter.database.DatabaseAccessDescriptor;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.io.IOException;
import java.nio.file.Path;
import java.sql.SQLException;

/**
 * Listener to initialize server from @{@link javax.servlet.ServletContext}.
 */
@WebListener()
public class AppInitializer implements ServletContextListener {

    public AppInitializer() { }

    public void contextInitialized(ServletContextEvent sce) {
        var fileRoot = Path.of("C:/Users/alex/DHBW/studentenfutter/storage");
        //var fileRoot = Path.of(System.getProperty("user.home"), "storage");

        var url = "jdbc:sqlite:" + fileRoot.resolve("studentenfutter.db").toAbsolutePath();
        var dataAccess = new DatabaseAccess(new DatabaseAccessDescriptor(url));

        try {
            dataAccess.onLoad();
        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }

        sce.getServletContext().setAttribute(DatabaseAccess.ATTRIBUTE_ACCESS_KEY, dataAccess);
    }
}
