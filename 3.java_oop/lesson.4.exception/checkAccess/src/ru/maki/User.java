package ru.maki;

import ru.maki.exception.AccessDeniedException;

public class User {
    final String login;
    final String password;
    final int    age;
    final String email;

    public User(String login, String password, int age, String email) {
        this.login    = login;
        this.password = password;
        this.age      = age;
        this.email    = email;
    }

    // проверка корректности учетных данных
    public boolean checkUser(String login, String password) {
        // System.out.println("..проверка вшивости");
        return (this.login.equals(login) && this.password.equals(password));
    }

    // проверка совершеннолетия
    public boolean checkAge() {
        // System.out.println("..проверка летности");
        if (this.age < 18) throw new AccessDeniedException();
        return true;
    }
}
