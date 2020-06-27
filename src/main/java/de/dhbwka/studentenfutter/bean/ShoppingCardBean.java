package de.dhbwka.studentenfutter.bean;

import java.io.Serializable;
import java.util.List;

public class ShoppingCardBean implements Serializable {
    private List<IngredientBean> shoppingCard;

    public List<IngredientBean> getShoppingCard() {
        return shoppingCard;
    }
}
