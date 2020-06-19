package de.dhbwka.studentenfutter.database.query;

import de.dhbwka.studentenfutter.database.IConnectionSupplier;
import de.dhbwka.studentenfutter.database.query.encoder.QueryResultEncoder;

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

    public <T> QueryExecutor<T> runAs(Class<T> clazz) {
        return new QueryExecutor<>(createQuery(), new QueryResultEncoder<>(clazz));
    }

    public void run() throws SQLException {
        createQuery().execute(result -> null);
    }

    private Query createQuery() {
        return new Query(connectionSupplier, sql, params);
    }
}
