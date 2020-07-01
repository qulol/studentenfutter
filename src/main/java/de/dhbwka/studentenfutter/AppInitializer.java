package de.dhbwka.studentenfutter;

import de.dhbwka.studentenfutter.database.DatabaseAccess;
import de.dhbwka.studentenfutter.database.DatabaseConnectionDescriptor;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Listener to initialize server from @{@link javax.servlet.ServletContext}.
 */
@WebListener()
public class AppInitializer implements ServletContextListener {

    public AppInitializer() { }

    public void contextInitialized(ServletContextEvent sce) {
        var url = "jdbc:sqlite:studentenfutter.db"; //read from config
        var connection = new DatabaseAccess(new DatabaseConnectionDescriptor(url));

        try {
            connection.onLoad();
        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }
        sce.getServletContext().setAttribute(DatabaseAccess.ATTRIBUTE_KEY, connection);
    }
}
