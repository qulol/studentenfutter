package de.dhbwka.studentenfutter.model.afe;

import de.dhbwka.studentenfutter.database.query.QueryResult;

public class UserPasswordBean {
    @QueryResult(index = 1)
    private int userId;
    @QueryResult(index = 2)
    private String password;

    public int getUserId() {
        return userId;
    }

    public String getPassword() {
        return password;
    }
}
