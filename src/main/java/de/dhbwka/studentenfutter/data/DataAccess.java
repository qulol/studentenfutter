package de.dhbwka.studentenfutter.data;

import de.dhbwka.studentenfutter.data.file.FileAccess;
import de.dhbwka.studentenfutter.database.DatabaseAccess;

public class DataAccess {
    public static final String ATTRIBUTE_ACCESS_KEY = DatabaseAccess.class.getName();

    private final FileAccess fileAccess;
    private final DatabaseAccess databaseAccess;

    public DataAccess(FileAccess fileAccess, DatabaseAccess databaseAccess) {
        this.fileAccess = fileAccess;
        this.databaseAccess = databaseAccess;
    }

    public FileAccess getFileAccess() {
        return fileAccess;
    }

    public DatabaseAccess getDatabaseAccess() {
        return databaseAccess;
    }
}
