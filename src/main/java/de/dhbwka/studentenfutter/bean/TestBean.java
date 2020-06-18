package de.dhbwka.studentenfutter.bean;

import de.dhbwka.studentenfutter.database.query.QueryResult;

public class TestBean {

    @QueryResult(index=1)
    private String password;

    @QueryResult(index = 2)
    private int passwordId;
}