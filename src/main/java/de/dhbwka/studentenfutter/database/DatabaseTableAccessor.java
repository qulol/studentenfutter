package de.dhbwka.studentenfutter.database;

public class DatabaseTableAccessor implements IDatabaseTableAccessor {
    private final DatabaseConnection connection;
    private final String table;

    public DatabaseTableAccessor(DatabaseConnection connection, String table) {
        this.connection = connection;
        this.table = table;
    }

    public String getTable() {
        return table;
    }

    @Override
    public boolean isApplicable(String name) {
        return table.equals(name);
    }
}
