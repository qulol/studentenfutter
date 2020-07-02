package de.dhbwka.studentenfutter.util;

import java.io.IOException;
import java.nio.file.Files;

public class SQLLoader {
    public static String load(String path) throws IOException {
        return new String(Files.readAllBytes(ResourceLoader.load(path).toPath()));
    }
}
