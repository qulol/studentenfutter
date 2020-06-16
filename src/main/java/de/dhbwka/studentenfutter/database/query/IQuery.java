package de.dhbwka.studentenfutter.database.query;

import java.sql.Connection;
import java.sql.SQLException;

public interface IQuery<T> {
    String getSQLAddress();
    boolean useCache();
    T execute(Connection connection, String sql) throws SQLException;
}
