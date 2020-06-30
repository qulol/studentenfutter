package de.dhbwka.studentenfutter.bean;

import java.io.Serializable;

public class UserBean implements Serializable {
    private String username;
    private ShoppingCardBean shoppingCard;

    public UserBean() {
    }

    public ShoppingCardBean getShoppingCard() {
        if (shoppingCard == null) {
            shoppingCard = new ShoppingCardBean();
        }
        return shoppingCard;
    }

    public void login(String username) {
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
}
