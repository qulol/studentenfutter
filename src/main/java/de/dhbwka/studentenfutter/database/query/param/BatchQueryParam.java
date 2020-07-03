package de.dhbwka.studentenfutter.database.query.param;

import de.dhbwka.studentenfutter.database.query.BatchCounter;

import java.util.function.Function;

public class BatchQueryParam implements IQueryParam {
    private final BatchCounter counter;
    private final Function<Integer, ?> params;

    public BatchQueryParam(BatchCounter counter, Function<Integer, ?> params) {
        this.counter = counter;
        this.params = params;
    }

    @Override
    public Object get() {
        return params.apply(counter.get());
    }
}
