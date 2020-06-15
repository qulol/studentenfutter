package de.dhbwka.studentenfutter.database.query;

public abstract class Query implements IQuery {
    private final String name;
    private final String query;

    protected Query(String name, String query) {
        this.name = name;
        this.query = query;
    }

    @Override
    public String getFullName() {
        return name;
    }

    @Override
    public String getQuery() {
        return query;
    }
}
