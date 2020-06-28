package de.dhbwka.studentenfutter.bean;

import java.util.List;

public class IngredientsListBean {
    private List<IngredientBean> ingredients;

    public IngredientsListBean(List<IngredientBean> ingredients) {
        this.ingredients = ingredients;
    }

    public List<IngredientBean> getIngredients() {
        return ingredients;
    }
}