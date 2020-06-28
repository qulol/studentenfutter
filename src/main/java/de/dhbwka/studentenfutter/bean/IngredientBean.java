package de.dhbwka.studentenfutter.bean;

import de.dhbwka.studentenfutter.database.query.QueryResult;
import de.dhbwka.studentenfutter.util.TypeMissMatchException;

import java.io.Serializable;
import java.util.Objects;

public class IngredientBean implements Serializable {
    @QueryResult(column = "ingredient")
    private String name;
    @QueryResult(column = "unit")
    private String unit;
    @QueryResult(column = "amount")
    private float amount;

    public IngredientBean() {
    }

    public IngredientBean(String name, String unit, float amount) {
        this.name = name;
        this.unit = unit;
        this.amount = amount;
    }

    public IngredientBean multiply(float factor) {
        return new IngredientBean(name, unit, amount * factor);
    }

    public IngredientBean add(IngredientBean other) throws TypeMissMatchException {
        if(!this.equals(other)) {
            throw new TypeMissMatchException();
        }
        return new IngredientBean(name, unit, amount +  other.amount);
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IngredientBean that = (IngredientBean) o;
        return name.equals(that.name) &&
                unit.equals(that.unit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, unit);
    }
}
