package de.dhbwka.studentenfutter.database.query.executor;

import de.dhbwka.studentenfutter.database.query.Query;
import de.dhbwka.studentenfutter.util.CheckedFunction;

import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class QueryExecutor {
    private final Query query;

    protected QueryExecutor(Query query) {
        this.query = query;
    }

    public <R> R run(CheckedFunction<ResultSet, R, SQLException> function) throws SQLException {
        return query.execute(function);
    }
}
