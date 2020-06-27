package de.dhbwka.studentenfutter.model.query;

import de.dhbwka.studentenfutter.database.query.QueryResult;

public class UserQueryModel {

    @QueryResult(column = "name")
    private String username;
    @QueryResult(column = "password")
    private String password;

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
