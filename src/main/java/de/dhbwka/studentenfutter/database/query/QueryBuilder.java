package de.dhbwka.studentenfutter.database.query;

import de.dhbwka.studentenfutter.database.IConnectionSupplier;
import de.dhbwka.studentenfutter.database.query.encoder.QueryResultEncoder;
import de.dhbwka.studentenfutter.database.query.param.BatchQueryParam;
import de.dhbwka.studentenfutter.database.query.param.IQueryParam;
import de.dhbwka.studentenfutter.database.query.param.QueryParam;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

public class QueryBuilder {
    List<IQueryParam> params = new ArrayList<>();
    BatchCounter counter = new BatchCounter();
    IConnectionSupplier connectionSupplier;
    String sql;

    public QueryBuilder(IConnectionSupplier connection, String sql) {
        this.connectionSupplier = connection;
        this.sql = sql;
    }

    public QueryBuilder withParam(Object param) {
        this.params.add(new QueryParam(param));
        return this;
    }

    public QueryBuilder withParams(Collection<?> params) {
        this.params.addAll(params.stream().map(QueryParam::new).collect(Collectors.toList()));
        return this;
    }

    public QueryBuilder withBatchSupplier(Function<Integer, ?> batchParamSupplier) {
        this.params.add(new BatchQueryParam(counter, batchParamSupplier));
        return this;
    }

    public <T> QueryExecutor<T> collectAs(Class<T> clazz) {
        return new QueryExecutor<>(createQuery(), Statement::getResultSet, new QueryResultEncoder<>(clazz));
    }

    public Optional<Integer> collectGeneratedKey() throws SQLException {
        return new QueryExecutor<>(createQuery(), Statement::getGeneratedKeys, new QueryResultEncoder<>(Integer.class)).get();
    }

    public void run() throws SQLException {
        createQuery().execute(statement -> null, result -> null);
    }

    private Query createQuery() {
        return new Query(connectionSupplier, sql, params);
    }

    public int[] runBatch(int batchCount) throws SQLException {
        if(batchCount == 0) {
            return new int[0];
        }
        return createQuery().executeBatch(counter, batchCount);
    }
}
