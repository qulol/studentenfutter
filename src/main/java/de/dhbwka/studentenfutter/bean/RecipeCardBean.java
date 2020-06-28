package de.dhbwka.studentenfutter.bean;

import de.dhbwka.studentenfutter.database.query.QueryResult;

public class RecipeCardBean {
    @QueryResult(column = "id_recipe")
    private int id;
    @QueryResult(column = "name")
    private String name;
    @QueryResult(column = "author")
    private String author;

    @SuppressWarnings({"FieldMayBeFinal", "FieldCanBeLocal"})
    private String previewText = "Hier könnte eine leckere Kurzbeschreibung stehen :)";


    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPreviewText() {
        return previewText;
    }

    public String getAuthor() {
        return author;
    }
}
