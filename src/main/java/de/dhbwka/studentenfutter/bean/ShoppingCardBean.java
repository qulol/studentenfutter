package de.dhbwka.studentenfutter.bean;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCardBean {
    private List<IngredientBean> ingredients = new ArrayList<>();
    private List<String> seasons = new ArrayList<>();

    public List<IngredientBean> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<IngredientBean> ingredients) {
        this.ingredients = ingredients;
    }

    public List<String> getSeasons() {
        return seasons;
    }

    public void setSeasons(List<String> seasons) {
        this.seasons = seasons;
    }

    public void clear() {
        ingredients.clear();
        seasons.clear();
    }
}
