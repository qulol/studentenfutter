package de.dhbwka.studentenfutter.database.query.executor;

import de.dhbwka.studentenfutter.database.query.Query;
import de.dhbwka.studentenfutter.database.query.encoder.QueryResultEncoder;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ResultQueryExecutor<T> extends QueryExecutor {
    private final QueryResultEncoder<T> encoder;

    public ResultQueryExecutor(Query query, QueryResultEncoder<T> encoder) {
        super(query);
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

    private T encode(ResultSet result) throws SQLException {
        return encoder.encode(result);
    }
}
