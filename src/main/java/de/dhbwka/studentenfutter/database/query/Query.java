package de.dhbwka.studentenfutter.database.query;

import de.dhbwka.studentenfutter.database.IConnectionSupplier;
import de.dhbwka.studentenfutter.util.CheckedFunction;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class Query {
    private final IConnectionSupplier connectionSupplier;
    private final String sql;
    private final List<Object> params;

    public Query(IConnectionSupplier connectionSupplier, String sql, List<Object> params) {
        this.connectionSupplier = connectionSupplier;
        this.sql = sql;
        this.params = params;
    }

    public <T> T execute(CheckedFunction<ResultSet, T, SQLException> function) throws SQLException {
        try (var connection = connectionSupplier.get();
             var statement = connection.prepareStatement(sql)) {
            prepareQuery(statement);
            statement.execute();
            return function.apply(statement.getResultSet());
        }
    }

    private void prepareQuery(PreparedStatement statement) throws SQLException {
        for (int i = 0; i < params.size(); i++) {
            statement.setObject(i + 1, params.get(i));
        }
    }
}
