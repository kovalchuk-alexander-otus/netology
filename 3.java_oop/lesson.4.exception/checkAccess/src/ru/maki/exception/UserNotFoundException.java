package ru.maki.exception;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException() {
        super("Вы ввели неверно логин/пароль. Попробуйте еще раз..");
    }
}
