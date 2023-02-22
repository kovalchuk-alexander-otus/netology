package ru.maki.errors;

public class IllegalStateException extends java.lang.IllegalStateException {
    public IllegalStateException() {
        super("Не настроены политики безопасности.");
    }
}
