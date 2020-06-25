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

    // Public constructor is required by servlet spec
    public AppInitializer() {

    }

    // -------------------------------------------------------
    // ServletContextListener implementation
    // -------------------------------------------------------
    public void contextInitialized(ServletContextEvent sce) {
      /* This method is called when the servlet context is
         initialized(when the Web application is deployed). 
         You can initialize servlet context related data here.
      */

        var url = "jdbc:sqlite:studentenfutter.db"; //read from config
        var connection = new DatabaseAccess(new DatabaseConnectionDescriptor(url));

        try {
            connection.onLoad();
        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }
        sce.getServletContext().setAttribute(DatabaseAccess.ATTRIBUTE_KEY, connection);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        //write temps in db and stuff
    }
}
