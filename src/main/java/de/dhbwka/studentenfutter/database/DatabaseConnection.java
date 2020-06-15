package de.dhbwka.studentenfutter.database;

import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DatabaseConnection {
    private final String url;
    private final List<IDatabaseTableAccessor> tables = new ArrayList<>();

    public DatabaseConnection(DatabaseConnectionDescriptor descriptor) {
        this.url = descriptor.getUrl();
    }

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url);
    }

    /**
     * Gets called when tomcat finish context loading
     * Create tables if absence
     */
    public void onLoad() throws IOException, URISyntaxException, SQLException {
        try (var connection = getConnection()) {
            for (var query : SQLQueryLoader.loadCreateTableQueries()) {
                connection.prepareStatement(query.getQuery()).execute();
            }
        }
    }

    /**
     * Add a table accessor
     */
    protected void addDatabaseTableAccessor(IDatabaseTableAccessor accessor) {
        tables.add(accessor);
    }

    /**
     * Gets called when tomcat shuts down.
     */
    public void onShutdown() {

    }

    /**
     * Returns a table accessor if exists to manipulate a single table of the database.
     * @param table the name on the table
     * @return a table accessor if exists to manipulate a single table of the database.
     */
    public IDatabaseTableAccessor getDatabaseTableAccessor(String table) {
        return tables.stream().filter(accessor -> accessor.isApplicable(table)).findFirst().orElseThrow();
    }

    public String getUrl() {
        return url;
    }
}
