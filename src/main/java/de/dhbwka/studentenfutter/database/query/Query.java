package de.dhbwka.studentenfutter.database.query;

import de.dhbwka.studentenfutter.database.IConnectionSupplier;
import de.dhbwka.studentenfutter.database.query.param.IQueryParam;
import de.dhbwka.studentenfutter.util.CheckedFunction;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class Query {
    private final IConnectionSupplier connectionSupplier;
    private final List<IQueryParam> params;
    private final String sql;

    public Query(IConnectionSupplier connectionSupplier, String sql, List<IQueryParam> params) {
        this.connectionSupplier = connectionSupplier;
        this.sql = sql;
        this.params = params;
    }

    public <T> T execute(CheckedFunction<PreparedStatement, ResultSet, SQLException> extractor,
                         CheckedFunction<ResultSet, T, SQLException> encoder) throws SQLException {
        try (var connection = connectionSupplier.get();
             var statement = connection.prepareStatement(sql)) {
            prepareQuery(statement);
            statement.execute();
            return encoder.apply(extractor.apply(statement));
        }
    }

    private void prepareQuery(PreparedStatement statement) throws SQLException {
        for (int i = 0; i < params.size(); i++) {
            statement.setObject(i + 1, params.get(i).get());
        }
    }

    public int[] executeBatch(BatchCounter counter, int batchCount) throws SQLException {
        try (var connection = connectionSupplier.get();
             var statement = connection.prepareStatement(sql)) {
            for (counter.get() ; counter.get() < batchCount; counter.incr()) {
                prepareQuery(statement);
                statement.addBatch();
            }
            return statement.executeBatch();
        }
    }
}
