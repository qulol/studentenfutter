package de.dhbwka.studentenfutter.database;

import de.dhbwka.studentenfutter.database.query.IQuery;
import de.dhbwka.studentenfutter.loader.SQLLoader;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class DatabaseAccess {
    private final String url;
    @SuppressWarnings("rawtypes")
    private final Map<Class<? extends IQuery>, String> sqlCache = new HashMap<>();

    public DatabaseAccess(DatabaseConnectionDescriptor descriptor) {
        this.url = descriptor.getUrl();
    }

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url);
    }

    /**
     * Gets called when tomcat finish context loading
     * Create tables if absence
     */
    public void onLoad() throws IOException, SQLException {
        //create tables
    }

    /**
     * Gets called when tomcat shuts down.
     */
    public void onShutdown() {

    }

    private <T> T useConnection(IQuery<T> query) throws SQLException, IOException {
        try (var connection = getConnection()) {
            return query.execute(connection, loadSQL(query));
        }
    }

    private String loadSQL(IQuery<?> query) throws IOException {
        if (!query.useCache()) {
            return SQLLoader.load(query);
        }
        var cached = sqlCache.get(query.getClass());
        if (cached == null) {
            cached = SQLLoader.load(query);
            sqlCache.put(query.getClass(), cached);
        }
        return cached;
    }

    public <R> R run(IQuery<R> query) throws SQLException, IOException {
        return useConnection(query);
    }

    public String getUrl() {
        return url;
    }
}
