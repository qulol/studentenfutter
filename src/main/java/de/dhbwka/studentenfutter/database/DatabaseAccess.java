package de.dhbwka.studentenfutter.database;

import de.dhbwka.studentenfutter.database.query.QueryBuilder;
import de.dhbwka.studentenfutter.database.query.QueryExecutor;
import de.dhbwka.studentenfutter.util.SQLLoader;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Abstract data access for the application.<br>
 * Mainly usage purpose is directly executing sql statements via the {@link #query(String)} method.
 *
 * Example:
 * <pre>
 *     {@code
 *          query("select name from user").runAs(String.class).getList();
 *      }
 * This statement will run the sql query and returns the 'name' Column,
 * where each column entity is encoded as a {@link String} object.
 * When multiple results are expected, call the {@link QueryExecutor#getList()}
 * (like in the example above) to retrieve the result as a {@link java.util.List}.
 * </pre>
 * The {@link DatabaseAccess} runs on jdbc which is specified via the
 * {@link DatabaseAccessDescriptor}.
 */
public class DatabaseAccess {
    public static final String ATTRIBUTE_ACCESS_KEY = DatabaseAccess.class.getName();

    private final ConcurrentHashMap<String, String> queryCache = new ConcurrentHashMap<>();
    private final DatabaseAccessDescriptor descriptor;

    /**
     * Constructor
     * @param descriptor {@link DatabaseAccessDescriptor}
     */
    public DatabaseAccess(DatabaseAccessDescriptor descriptor) {
        this.descriptor = descriptor;
    }

    private IConnectionSupplier getConnectionSupplier() {
        return this::getConnection;
    }

    /**
     * Gets a {@link Connection} of the underlying jdbc driver
     * specified in the {@link #descriptor}.
     * Normally there is no need of calling this method directly,
     * you should use the {@link #query(String)} method instead.
     *
     * @return a new connection
     * @throws SQLException
     */
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(getUrl());
    }

    /**
     * Initialize the underlying database.
     * Gets called when tomcat finish context loading
     */
    public void onLoad() throws IOException, SQLException {
        query(SQLLoader.load("sql/initialize/create_recipe.sql")).run();
        query(SQLLoader.load("sql/initialize/create_recipe_ingredient.sql")).run();
        query(SQLLoader.load("sql/initialize/create_recipe_description.sql")).run();
        query(SQLLoader.load("sql/initialize/create_shoppingcart.sql")).run();
        query(SQLLoader.load("sql/initialize/create_user.sql")).run();
    }

    /**
     * Currently not used.
     * Gets called when tomcat shuts down.
     */
    public void onShutdown() {
        //shutdown sth.
    }

    /**
     * TODO
     * @param sql
     * @return
     */
    public QueryBuilder query(String sql) {
        return new QueryBuilder(getConnectionSupplier(), sql);
    }

    /**
     *
     * @param path
     * @return
     * @throws IOException
     */
    public QueryBuilder cachedQuery(String path) throws IOException {
        if (queryCache.contains(path)) {
            return query(queryCache.get(path));
        }
        var sql = SQLLoader.load(path);
        queryCache.put(path, sql);
        return query(sql);
    }

    /**
     * Gets the url specified in the used {@link #descriptor}
     * @return the specified url
     */
    public String getUrl() {
        return descriptor.getUrl();
    }
}
