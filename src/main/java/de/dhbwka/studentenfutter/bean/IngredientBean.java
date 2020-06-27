package de.dhbwka.studentenfutter.bean;

import de.dhbwka.studentenfutter.database.query.QueryResult;

public class IngredientBean {
    @QueryResult(column = "amount")
    private float amount;
    @QueryResult(column = "unit")
    private String unit;
    @QueryResult(column = "ingredient")
    private String name;


    public float getAmount() {
        return amount;
    }

    public String getUnit() {
        return unit;
    }

    public String getName() {
        return name;
    }
}
