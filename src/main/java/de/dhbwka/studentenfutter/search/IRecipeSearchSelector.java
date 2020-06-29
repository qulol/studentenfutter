package de.dhbwka.studentenfutter.search;

import de.dhbwka.studentenfutter.bean.RecipeBean;

import java.util.List;

public interface IRecipeSearchSelector {
    public List<RecipeBean> search(String search);
}
