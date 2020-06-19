package de.dhbwka.studentenfutter.database;

/**
 * A simple Database descriptor used by a {@link DatabaseAccess} to establish a connection
 * between an underlying jdbc driver and it's matching database.
 */
public class DatabaseConnectionDescriptor {
    private final String url;

    public DatabaseConnectionDescriptor(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }
}
