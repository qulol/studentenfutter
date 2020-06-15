package de.dhbwka.studentenfutter.database.query;

public class CreateTableQuery extends Query {
    private String name;
    private String query;

    public CreateTableQuery(String name, String query) {
        super(name, query);
    }

    @Override
    public String getName() {
        return getFullName().replace("CreateTable", "");
    }
}
