package de.dhbwka.studentenfutter.storage;

import de.dhbwka.studentenfutter.storage.file.FileAccess;
import de.dhbwka.studentenfutter.storage.database.DatabaseAccess;

public class StorageAccess {
    public static final String ATTRIBUTE_ACCESS_KEY = StorageAccess.class.getName();

    private final FileAccess fileAccess;
    private final DatabaseAccess databaseAccess;

    public StorageAccess(FileAccess fileAccess, DatabaseAccess databaseAccess) {
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
