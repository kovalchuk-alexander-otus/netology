package ru.maki.errors;

public class IllegalArgumentException extends java.lang.IllegalArgumentException {
    public IllegalArgumentException(int message) {
        super("Недопустимый аргумент [" + message + "]");
    }
}
