package de.dhbwka.studentenfutter.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class UserBean implements Serializable {
    private String username;
    private List<IngredientBean> shoppingCard;

    public UserBean() {
    }

    public void login(String username) {
        shoppingCard = new ArrayList<>();
        this.username = username;
    }

    public void logout() {
        this.username = null;
    }

    public boolean isLoggedIn() {
        return username != null;
    }

    public String getUsername() {
        return username == null ? "anonym" : username;
    }

    public List<IngredientBean> getShoppingCard() {
        return shoppingCard;
    }

    public void setShoppingCard(List<IngredientBean> shoppingCard) {
        this.shoppingCard = shoppingCard;
    }
}
