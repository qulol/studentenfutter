package de.dhbwka.studentenfutter.database.query;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class Query<T> implements IQuery<T> {

    @Override
    public T execute(Connection connection, String sql) throws SQLException {
        try(var statement = connection.prepareStatement(sql)) {
            prepareStatement(statement);
            if (statement.execute()) {
                return map(statement.getResultSet());
            }
            return null;
        }
    }

    protected abstract void prepareStatement(PreparedStatement statement) throws SQLException;

    protected abstract T map(ResultSet result) throws SQLException;
}
