package de.dhbwka.studentenfutter.util;

@FunctionalInterface
public interface CheckedSupplier<T, R extends Throwable> {
    T get() throws R;
}
