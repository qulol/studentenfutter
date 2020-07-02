package de.dhbwka.studentenfutter.storage.database.query;

public class BatchCounter {
    private int counter;

    public void incr() {
        counter++;
    }

    public int get() {
        return counter;
    }
}
