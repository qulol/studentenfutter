package de.dhbwka.studentenfutter.system;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Objects;

public class ResourceLoader {
    public static File load(String path) throws IOException {
        try {
            return new File(Objects.requireNonNull(ResourceLoader.class.getClassLoader().getResource(path)).toURI());
        } catch (NullPointerException | URISyntaxException e) {
            throw new IOException("Cannot find sql under path: " + path, e);
        }
    }
}
