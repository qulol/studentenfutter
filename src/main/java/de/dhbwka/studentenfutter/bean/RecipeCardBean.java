package de.dhbwka.studentenfutter.bean;

import de.dhbwka.studentenfutter.database.query.QueryResult;

public class RecipeCardBean {
    @QueryResult(column = "name")
    private String name;
    @QueryResult(column = "id_recipe")
    private int imgId;
    @QueryResult(column = "author")
    private String author;

    @SuppressWarnings({"FieldMayBeFinal", "FieldCanBeLocal"})
    private String previewText = "Hier könnte eine leckere Kurzbeschreibung stehen :)";


    public String getName() {
        return name;
    }

    public int getImgId() {
        return imgId;
    }

    public String getPreviewText() {
        return previewText;
    }

    public String getAuthor() {
        return author;
    }
}
