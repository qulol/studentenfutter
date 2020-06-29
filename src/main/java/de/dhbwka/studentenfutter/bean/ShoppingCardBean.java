package de.dhbwka.studentenfutter.bean;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCardBean {
    private List<IngredientBean> ingredients;
    private List<String> seasons;

    public List<IngredientBean> getIngredients() {
        if (ingredients == null) {
            ingredients = new ArrayList<>();
        }
        return ingredients;
    }

    public void setIngredients(List<IngredientBean> ingredients) {
        this.ingredients = ingredients;
    }

    public List<String> getSeasons() {
        if (seasons == null) {
            seasons = new ArrayList<>();
        }
        return seasons;
    }

    public void setSeasons(List<String> seasons) {
        this.seasons = seasons;
    }
}
