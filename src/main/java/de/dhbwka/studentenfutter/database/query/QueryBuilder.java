package de.dhbwka.studentenfutter.database.query;

import de.dhbwka.studentenfutter.database.IConnectionSupplier;
import de.dhbwka.studentenfutter.database.query.encoder.QueryResultEncoder;
import de.dhbwka.studentenfutter.database.query.executor.QueryExecutor;
import de.dhbwka.studentenfutter.database.query.executor.ResultQueryExecutor;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class QueryBuilder {
    List<Object> params = new ArrayList<>();
    IConnectionSupplier connectionSupplier;
    String sql;

    public QueryBuilder(IConnectionSupplier connection, String sql) {
        this.connectionSupplier = connection;
        this.sql = sql;
    }

    public QueryBuilder withParam(Object param) {
        params.add(param);
        return this;
    }

    public <T> ResultQueryExecutor<T> encodeAs(Class<T> clazz) {
        return new ResultQueryExecutor<>(createQuery(), new QueryResultEncoder<>(clazz));
    }

    public void run() throws SQLException {
        new QueryExecutor(createQuery()) {}.run(resultSet -> null);
    }

    private Query createQuery() {
        return new Query(connectionSupplier, sql, params);
    }
}
