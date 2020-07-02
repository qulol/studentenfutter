package de.dhbwka.studentenfutter.bean;

import de.dhbwka.studentenfutter.storage.database.query.QueryResult;

public class RecipeCardBean {
    @QueryResult(column = "id_recipe")
    private int id;
    @QueryResult(column = "name")
    private String name;
    @QueryResult(column = "author")
    private String author;
    @QueryResult(column = "short_description")
    private String shortDescription;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public String getAuthor() {
        return author;
    }
}
