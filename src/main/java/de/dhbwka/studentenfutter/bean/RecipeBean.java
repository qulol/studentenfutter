package de.dhbwka.studentenfutter.bean;

import de.dhbwka.studentenfutter.storage.database.query.QueryResult;

import java.io.Serializable;
import java.util.List;

public class RecipeBean implements Serializable {
    @QueryResult(column = "id_recipe")
    private int id;
    @QueryResult(column = "author")
    private String author;
    @QueryResult(column = "name")
    private String name;
    @QueryResult(column = "category")
    private String category;

    private List<IngredientBean> ingredients;
    private List<DescriptionBean> descriptions;


    public int getId() {
        return id;
    }

    public String getAuthor() {
        return author;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public List<IngredientBean> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<IngredientBean> ingredients) {
        this.ingredients = ingredients;
    }

    public List<DescriptionBean> getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(List<DescriptionBean> descriptions) {
        this.descriptions = descriptions;
    }
}
