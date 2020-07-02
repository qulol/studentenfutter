package de.dhbwka.studentenfutter.system;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Optional;

public class FileUtil {

    public static Optional<File[]> listFiles(File folder) {
        var files = folder.listFiles();
        if (files == null) {
            return Optional.empty();
        }
        return Optional.of(files);
    }

    public static Optional<File> getFirstInFolder(File folder, String name) {
        return listFiles(folder)
                .flatMap(files -> Arrays.stream(files)
                        .filter(file -> file.getName().equals(name))
                        .findFirst());
    }

    public static File get(String path) throws IOException{
        return Optional.of(new File(path)).orElseThrow(IOException::new);
    }
}
