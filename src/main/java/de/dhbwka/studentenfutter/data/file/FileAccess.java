package de.dhbwka.studentenfutter.data.file;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileAccess {
    private final FileAccessDescriptor descriptor;

    public FileAccess(FileAccessDescriptor descriptor) {
        this.descriptor = descriptor;
    }

    public FileAccessDescriptor getDescriptor() {
        return descriptor;
    }

    public void onLoad() {
        descriptor.getRoot();
    }

    public byte[] readFile(Path path) throws IOException {
        return Files.readAllBytes(path);
    }

    public Path getDatabaseRoot() {
        return descriptor.getRoot().resolve("data");
    }

    public Path getRecipeImageRoot() {
        return descriptor.getRoot().resolve("files/images/recipe");
    }
}
