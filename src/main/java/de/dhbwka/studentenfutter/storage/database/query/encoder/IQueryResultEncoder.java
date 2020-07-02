package de.dhbwka.studentenfutter.storage.database.query.encoder;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface IQueryResultEncoder<T> {
    T encode(ResultSet result) throws SQLException;
}
