package de.dhbwka.studentenfutter.database;

import de.dhbwka.studentenfutter.database.query.QueryBuilder;
import de.dhbwka.studentenfutter.loader.SQLLoader;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseAccess {
    private final String url;

//    caching?

    public DatabaseAccess(DatabaseConnectionDescriptor descriptor) {
        this.url = descriptor.getUrl();
    }

    private IConnectionSupplier getConnectionSupplier() {
        return this::getConnection;
    }

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(getUrl());
    }

    /**
     * Gets called when tomcat finish context loading
     */
    public void onLoad() throws IOException, SQLException {
        run(SQLLoader.load("sql/create/create_table_ingredient.sql"));
        run(SQLLoader.load("sql/create/create_table_password.sql"));
        run(SQLLoader.load("sql/create/create_table_recipe.sql"));
        run(SQLLoader.load("sql/create/create_table_recipe_entity.sql"));
        run(SQLLoader.load("sql/create/create_table_user.sql"));
    }

    /**
     * Gets called when tomcat shuts down.
     */
    public void onShutdown() {
        //copy database or sth
    }

    public QueryBuilder run(String sql) {
        return new QueryBuilder(getConnectionSupplier(), sql);
    }

    public String getUrl() {
        return url;
    }
}
