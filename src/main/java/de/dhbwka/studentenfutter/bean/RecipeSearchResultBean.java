package de.dhbwka.studentenfutter.bean;

import java.util.List;

public class RecipeSearchResultBean {
    private final String prettyColumnName;
    private final List<RecipeCardBean> recipeCards;

    public RecipeSearchResultBean(String prettyColumnName, List<RecipeCardBean> recipeCards) {
        this.prettyColumnName = prettyColumnName;
        this.recipeCards = recipeCards;
    }

    public String getPrettyColumnName() {
        return prettyColumnName;
    }

    public List<RecipeCardBean> getRecipeCards() {
        return recipeCards;
    }
}
