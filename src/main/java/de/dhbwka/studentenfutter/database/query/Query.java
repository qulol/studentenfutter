package de.dhbwka.studentenfutter.database.query;

import de.dhbwka.studentenfutter.database.IConnectionSupplier;
import de.dhbwka.studentenfutter.util.CheckedFunction;
import de.dhbwka.studentenfutter.util.CheckedSupplier;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Map;

public class Query {
    private final IConnectionSupplier connectionSupplier;
    private final String sql;
    private final List<Object> params;
    private final CheckedFunction<PreparedStatement, ResultSet, SQLException> extractor;

    public Query(IConnectionSupplier connectionSupplier, String sql, List<Object> params) {
        this(connectionSupplier, sql, params, Statement::getResultSet);
    }

    public Query(IConnectionSupplier connectionSupplier, String sql, List<Object> params,
                 CheckedFunction<PreparedStatement, ResultSet, SQLException> extractor) {
        this.connectionSupplier = connectionSupplier;
        this.sql = sql;
        this.params = params;
        this.extractor = extractor;
    }

    public <T> T execute(CheckedFunction<ResultSet, T, SQLException> function) throws SQLException {
        try (var connection = connectionSupplier.get();
             var statement = connection.prepareStatement(sql)) {
            prepareQuery(statement);
            statement.execute();
            return function.apply(extractor.apply(statement));
        }
    }

    private void prepareQuery(PreparedStatement statement) throws SQLException {
        for (int i = 0; i < params.size(); i++) {
            statement.setObject(i + 1, params.get(i));
        }
    }
}
