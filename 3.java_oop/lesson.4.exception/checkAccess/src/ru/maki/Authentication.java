package ru.maki;

import ru.maki.exception.UserNotFoundException;

import java.util.Arrays;

public class Authentication {
    User[] users;

    public Authentication() {
        this.users = new User[0];
    }

    // метод регистрации Пользователя в системе
    public void regUser(String login, String password, int age, String email) {
        User[] newUsers = Arrays.copyOf(this.users, this.users.length + 1);
        newUsers[newUsers.length - 1] = new User(login, password, age, email);
        users                         = newUsers;
    }

    // проверка наличия пользователя в системе (по паре логин/пароль)
    public boolean checkAccess(String login, String password) {
        for (User user : users) {
            if (user.checkUser(login, password)) return user.checkAge();
        }
        throw new UserNotFoundException();
    }
}
