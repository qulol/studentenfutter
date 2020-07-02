package de.dhbwka.studentenfutter.storage.database.query.param;

public class QueryParam implements IQueryParam {
    private final Object param;

    public QueryParam(Object param) {
        this.param = param;
    }

    @Override
    public Object get() {
        return param;
    }
}
