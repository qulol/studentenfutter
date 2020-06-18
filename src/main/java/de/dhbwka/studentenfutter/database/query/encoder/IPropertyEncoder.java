package de.dhbwka.studentenfutter.database.query.encoder;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface IPropertyEncoder<T> {
    T encode(ResultSet result) throws SQLException;
}