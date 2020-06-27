package de.dhbwka.studentenfutter.bean;

import de.dhbwka.studentenfutter.database.query.QueryResult;

public class DescriptionBean {
    @QueryResult(column = "id")
    private int id;
    @QueryResult(column = "description")
    private String description;

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }
}
