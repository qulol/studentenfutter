package de.dhbwka.studentenfutter.database;

public class DatabaseConnectionDescriptor {
    private final String url;

    public DatabaseConnectionDescriptor(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }
}
