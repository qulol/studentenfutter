package de.dhbwka.studentenfutter.database.query.encoder;

import java.sql.ResultSet;
import java.sql.SQLException;

@FunctionalInterface
public interface IQueryResultEncoder<T> {
    T encode(ResultSet set) throws SQLException;
}
