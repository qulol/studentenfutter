package de.dhbwka.studentenfutter.bean;

import java.io.Serializable;

public class UserBean implements Serializable {
    private boolean loggedIn;
    private String username;
    private ShoppingCardBean shoppingCard;

    public UserBean() {
    }

    public UserBean(String username) {
        this(true, username);
    }

    private UserBean(boolean loggedIn, String username) {
        this.loggedIn = loggedIn;
        this.username = username;
    }

    public ShoppingCardBean getShoppingCard() {
        if (shoppingCard == null) {
            shoppingCard = new ShoppingCardBean();
        }
        return shoppingCard;
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
