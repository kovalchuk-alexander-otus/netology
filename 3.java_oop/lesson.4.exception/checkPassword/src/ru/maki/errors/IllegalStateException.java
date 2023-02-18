package ru.maki.errors;

public class IllegalStateException extends RuntimeException {
    public IllegalStateException() {
        super("Не настроены политики безопасности.");
    }
}
