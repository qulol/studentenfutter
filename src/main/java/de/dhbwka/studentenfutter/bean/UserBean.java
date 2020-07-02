package de.dhbwka.studentenfutter.bean;

import de.dhbwka.studentenfutter.storage.database.query.QueryResult;

import java.io.Serializable;

public class UserBean implements Serializable {
    @QueryResult(column = "id_user")
    private int id;
    @QueryResult(column = "name")
    private String username;
    @QueryResult(column = "password")
    private String password;

    public UserBean() { }

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
}
