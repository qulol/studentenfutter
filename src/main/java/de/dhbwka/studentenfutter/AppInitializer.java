package de.dhbwka.studentenfutter;

import de.dhbwka.studentenfutter.data.DataAccess;
import de.dhbwka.studentenfutter.data.file.FileAccess;
import de.dhbwka.studentenfutter.data.file.FileAccessDescriptor;
import de.dhbwka.studentenfutter.database.DatabaseAccess;
import de.dhbwka.studentenfutter.database.DatabaseAccessDescriptor;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.sql.SQLException;
import java.text.MessageFormat;

/**
 * Listener to initialize server from @{@link javax.servlet.ServletContext}.
 */
@WebListener()
public class AppInitializer implements ServletContextListener {

    public AppInitializer() { }

    public void contextInitialized(ServletContextEvent sce) {
        var fileRoot = Path.of("C:/Users/alex/DHBW/studentenfutter/storage");
        //var fileRoot = Path.of(System.getProperty("user.home"), "storage");

        var fileAccess = new FileAccess(new FileAccessDescriptor(fileRoot));

        var url = "jdbc:sqlite:" + fileAccess.getDatabaseRoot().resolve("studentenfutter.db").toAbsolutePath();

        var databaseAccess = new DatabaseAccess(new DatabaseAccessDescriptor(url));

        try {
            fileAccess.onLoad();
            databaseAccess.onLoad();
        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }

        var dataAccess = new DataAccess(fileAccess, databaseAccess);
        sce.getServletContext().setAttribute(DataAccess.ATTRIBUTE_ACCESS_KEY, dataAccess);
    }
}
