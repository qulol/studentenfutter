package de.dhbwka.studentenfutter.database.query;

import de.dhbwka.studentenfutter.database.IConnectionSupplier;
import de.dhbwka.studentenfutter.database.query.encoder.QueryResultEncoder;
import de.dhbwka.studentenfutter.util.CheckedFunction;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

public class QueryBuilder {
    List<Object> params = new ArrayList<>();
    IConnectionSupplier connectionSupplier;
    String sql;

    public QueryBuilder(IConnectionSupplier connection, String sql) {
        this.connectionSupplier = connection;
        this.sql = sql;
    }

    public QueryBuilder withParam(Object param) {
        this.params.add(param);
        return this;
    }

    public QueryBuilder withParams(Collection<?> params) {
        this.params.addAll(params);
        return this;
    }

    public <T> QueryExecutor<T> collectAs(Class<T> clazz) {
        return new QueryExecutor<>(createQuery(Statement::getResultSet), new QueryResultEncoder<>(clazz));
    }

    public Optional<Integer> collectGeneratedKey() throws SQLException {
        return new QueryExecutor<>(createQuery(Statement::getGeneratedKeys), new QueryResultEncoder<>(Integer.class)).get();
    }

    public void run() throws SQLException {
        createQuery(statement -> null).execute(result -> null);
    }

    private Query createQuery(CheckedFunction<PreparedStatement, ResultSet, SQLException> extractor) {
        return new Query(connectionSupplier, sql, params, extractor);
    }
}
