package de.dhbwka.studentenfutter.bean;

import de.dhbwka.studentenfutter.database.query.QueryResult;

import java.io.Serializable;

public class DescriptionBean implements Serializable {
    @QueryResult(column = "id")
    private int id;
    @QueryResult(column = "description")
    private String description;

    public DescriptionBean(int id, String description) {
        this.id = id;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }
}
