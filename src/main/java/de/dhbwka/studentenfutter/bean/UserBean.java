package de.dhbwka.studentenfutter.bean;

import de.dhbwka.studentenfutter.database.query.QueryResult;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class UserBean implements Serializable {
    @QueryResult(column = "id_user")
    private int id;
    @QueryResult(column = "name")
    private String username;
    @QueryResult(column = "password")
    private String password;

    private List<IngredientBean> shoppingCard;

    public UserBean() {
        shoppingCard = new ArrayList<>();
    }

    public boolean isLoggedIn() {
        return id != 0;
    }

    public String getUsername() {
        return username == null ? "anonym" : username;
    }

    public int getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public List<IngredientBean> getShoppingCard() {
        return shoppingCard;
    }

    public void setShoppingCard(List<IngredientBean> shoppingCard) {
        this.shoppingCard = shoppingCard;
    }
}
