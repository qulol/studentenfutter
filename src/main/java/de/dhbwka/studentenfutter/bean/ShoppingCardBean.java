package de.dhbwka.studentenfutter.bean;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCardBean {
    private List<IngredientBean> ingredients = new ArrayList<>();

    public List<IngredientBean> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<IngredientBean> ingredients) {
        this.ingredients = ingredients;
    }

    public void clear() {
        ingredients.clear();
    }
}
