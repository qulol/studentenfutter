package de.dhbwka.studentenfutter.database.query;

public class BatchCounter {
    private int counter;

    public void incr() {
        counter++;
    }

    public int get() {
        return counter;
    }
}
