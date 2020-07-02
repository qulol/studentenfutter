package de.dhbwka.studentenfutter.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Optional;
import java.util.stream.StreamSupport;

public class PathUtility {

    public static Optional<Path> findFirstStartsWith(Path folder, String name) throws IOException {
        if(!Files.isDirectory(folder)) {
            throw new IOException("Not a folder: " + folder.toString());
        }

        try (var files = Files.newDirectoryStream(folder)) {
            return StreamSupport
                    .stream(files.spliterator(), true)
                    .filter(path -> path.getFileName().toString().contains(name))
                    .findFirst();
        }
    }
}
