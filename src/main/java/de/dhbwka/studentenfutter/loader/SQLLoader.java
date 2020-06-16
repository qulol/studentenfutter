package de.dhbwka.studentenfutter.loader;

import de.dhbwka.studentenfutter.database.query.IQuery;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.util.Objects;

public class SQLLoader {
    private static final String root = "sql/";

    public static String load(IQuery<?> query) throws IOException {
        var path = root + query.getSQLAddress();
        File file;
        try {
            file = new File(Objects.requireNonNull(SQLLoader.class.getClassLoader().getResource(path)).toURI());
        } catch (NullPointerException | URISyntaxException e) {
            throw new IOException("Cannot find sql under path: " + path, e);
        }
        return new String(Files.readAllBytes(file.toPath()));
    }
}
