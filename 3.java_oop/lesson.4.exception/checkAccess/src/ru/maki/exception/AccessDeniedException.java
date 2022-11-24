package ru.maki.exception;

public class AccessDeniedException extends RuntimeException {
    public AccessDeniedException() {
        super("Вы еще слишком юнны мой друг");
    }
}
