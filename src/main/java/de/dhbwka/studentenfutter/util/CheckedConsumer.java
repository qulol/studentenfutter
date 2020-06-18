package de.dhbwka.studentenfutter.util;

@FunctionalInterface
public interface CheckedConsumer<T, E extends Throwable> {
    void accept(T consumer) throws E;
}
