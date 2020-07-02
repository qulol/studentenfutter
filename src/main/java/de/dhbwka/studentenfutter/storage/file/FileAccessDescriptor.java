package de.dhbwka.studentenfutter.storage.file;

import java.nio.file.Path;

public class FileAccessDescriptor {
    private final Path root;

    public FileAccessDescriptor(Path root) {
        this.root = root;
    }

    public Path getRoot() {
        return root;
    }
}
