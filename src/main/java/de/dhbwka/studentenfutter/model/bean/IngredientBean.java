package de.dhbwka.studentenfutter.model.bean;

public class IngredientBean {
    private final float amount;
    private final String unit;
    private final String name;

    public IngredientBean(float amount, String unit, String name) {
        this.amount = amount;
        this.unit = unit;
        this.name = name;
    }

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
