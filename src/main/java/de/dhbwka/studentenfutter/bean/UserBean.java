package de.dhbwka.studentenfutter.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class UserBean implements Serializable {
    private boolean loggedIn;
    private String username;
    private List<IngredientBean> shoppingCard;

    public UserBean() {
    }

    public UserBean(String username) {
        this(true, username);
    }

    private UserBean(boolean loggedIn, String username) {
        this.loggedIn = loggedIn;
        this.username = username;
    }

    public List<IngredientBean> getShoppingCard() {
        if (shoppingCard == null) {
            shoppingCard = new ArrayList<>();
        }
        return shoppingCard;
    }

    public void setShoppingCard(List<IngredientBean> shoppingCard) {
        this.shoppingCard = shoppingCard;
    }

    public void setLoggedIn(boolean loggedIn) {
        this.loggedIn = loggedIn;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public boolean isLoggedIn() {
        return loggedIn;
    }

    public String getUsername() {
        return username == null ? "anonym" : username;
    }
}
