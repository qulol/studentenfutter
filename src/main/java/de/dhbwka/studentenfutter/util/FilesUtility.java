package de.dhbwka.studentenfutter.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Optional;

public class FilesUtility {

    public static Optional<byte[]> readFile(String path) {
        try {
            return Optional.of(Files.readAllBytes(Path.of(path)));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }
}
