package de.dhbwka.studentenfutter.database.query;

import de.dhbwka.studentenfutter.database.query.encoder.IQueryResultEncoder;
import de.dhbwka.studentenfutter.util.CheckedFunction;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class QueryExecutor<T> {
    private final Query query;
    private final IQueryResultEncoder<T> encoder;

    public QueryExecutor(Query query, IQueryResultEncoder<T> encoder) {
        this.query = query;
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
            if(result.next()) {
                return Optional.of(encode(result));
            }
            return Optional.empty();
        });
    }

    private <R> R run(CheckedFunction<ResultSet, R, SQLException> function) throws SQLException {
        return query.execute(function);
    }

    private T encode(ResultSet result) throws SQLException {
        return encoder.encode(result);
    }
}
