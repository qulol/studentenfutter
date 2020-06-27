package de.dhbwka.studentenfutter.bean;

import de.dhbwka.studentenfutter.database.query.QueryResult;

import java.io.Serializable;
import java.util.Comparator;
import java.util.List;

public class RecipeBean implements Serializable {
    @QueryResult(column = "id_user")
    private int idUser;
    @QueryResult(column = "name")
    private String name;
    @QueryResult(column = "category")
    private String category;

    private List<DescriptionBean> descriptions;
    private List<IngredientBean> ingredients;


    public int getIdUser() {
        return idUser;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public List<DescriptionBean> getDescriptions() {
        descriptions.sort(Comparator.comparing(DescriptionBean::getId));
        return descriptions;
    }

    public void setDescriptions(List<DescriptionBean> descriptions) {
        this.descriptions = descriptions;
    }

    public List<IngredientBean> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<IngredientBean> ingredients) {
        this.ingredients = ingredients;
    }
}
