package de.dhbwka.studentenfutter.database.query;

import de.dhbwka.studentenfutter.util.CheckedSupplier;

import java.sql.Connection;
import java.sql.SQLException;


public interface IConnectionSupplier extends CheckedSupplier<Connection, SQLException> {

}
