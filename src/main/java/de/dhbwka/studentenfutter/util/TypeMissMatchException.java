package de.dhbwka.studentenfutter.util;

public class TypeMissMatchException extends RuntimeException {
    public TypeMissMatchException() {
        this("The given types are not equals!");
    }

    public TypeMissMatchException(String message) {
        super(message);
    }
}
