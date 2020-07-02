package de.dhbwka.studentenfutter.storage.database.query;

import de.dhbwka.studentenfutter.storage.database.query.encoder.IQueryResultEncoder;
import de.dhbwka.studentenfutter.util.CheckedFunction;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class QueryExecutor<T> {
    private final Query query;
    private final IQueryResultEncoder<T> encoder;
    private final CheckedFunction<PreparedStatement, ResultSet, SQLException> extractor;

    public QueryExecutor(Query query, CheckedFunction<PreparedStatement, ResultSet, SQLException> extractor,
                         IQueryResultEncoder<T> encoder) {
        this.query = query;
        this.extractor = extractor;
        this.encoder = encoder;
    }

    public List<T> getList() throws SQLException {
        return run(result -> {
            List<T> list = new ArrayList<>();
            while (result.next()) {
                list.add(encode(result));
            }
            return list;
        });
    }

    public Optional<T> get() throws SQLException {
        return run(result -> {
            if (result.next()) {
                return Optional.of(encode(result));
            }
            return Optional.empty();
        });
    }

    private <R> R run(CheckedFunction<ResultSet, R, SQLException> encodingFunction) throws SQLException {
        return query.execute(extractor, encodingFunction);
    }

    private T encode(ResultSet result) throws SQLException {
        return encoder.encode(result);
    }
}
