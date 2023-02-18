package ru.maki.errors;

public class IllegalArgumentException extends RuntimeException {
    public IllegalArgumentException(int message) {
        super("Недопустимый аргумент [" + message + "]");
    }
}
