package de.dhbwka.studentenfutter.database.query;

import de.dhbwka.studentenfutter.database.IConnectionSupplier;

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

    public <T> QueryExecutor<T> encodeAs(Class<T> clazz) {
        var query = new Query(connectionSupplier, sql, params);
        return new QueryExecutor<>(query, clazz);
    }

    //add default void executor
//    public void run() throws SQLException {
//        runQuery();
//    }
}
