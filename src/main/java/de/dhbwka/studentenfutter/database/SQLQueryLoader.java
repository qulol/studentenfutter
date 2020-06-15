package de.dhbwka.studentenfutter.database;

import de.dhbwka.studentenfutter.database.query.CreateTableQuery;
import de.dhbwka.studentenfutter.database.query.IQuery;

import java.io.*;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class SQLQueryLoader {
    private static final String path = "de\\dhbwka\\studentenfutter\\sql\\";
    private static final String create = "create\\";

    public static List<IQuery> loadCreateTableQueries() throws URISyntaxException, IOException {
        var fullPath = path + create;
        var queries = new File(Objects.requireNonNull(
                SQLQueryLoader.class.getClassLoader().getResource(fullPath)).toURI()).listFiles();
        if (queries == null || queries.length == 0) {
            return new ArrayList<>();
        }
        var list = new ArrayList<IQuery>();
        for (File file : queries) {
            var name = file.getName();
            var query = new String(Files.readAllBytes(file.toPath()));
            list.add(new CreateTableQuery(name, query));
        }
        return list;
    }
}
