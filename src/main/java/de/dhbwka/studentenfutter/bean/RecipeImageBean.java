package de.dhbwka.studentenfutter.bean;

import de.dhbwka.studentenfutter.database.query.QueryResult;

public class RecipeImageBean {
    @QueryResult(column = "content_type")
    private String contentType;
    @QueryResult(column = "content")
    private byte[] content;

    public RecipeImageBean() {
    }

    public RecipeImageBean(String contentType, byte[] content) {
        this.contentType = contentType;
        this.content = content;
    }

    public String getContentType() {
        return contentType;
    }

    public byte[] getContent() {
        return content;
    }
}
