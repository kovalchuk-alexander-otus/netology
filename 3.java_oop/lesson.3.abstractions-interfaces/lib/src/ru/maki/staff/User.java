package ru.maki.staff;

import ru.maki.File;
import ru.maki.role.*;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Random;

public abstract class User {

    protected static int       sequence = 0;
    protected final  int       idx;
    protected final  String    surname;
    protected final  String    name;
    protected final  String    patronymic;
    protected final  LocalDate dateOfBirth;
    protected File[]    files;
    protected final Role   role;
    protected final Random random = new Random();

    public User(String surname, String name, String patronymic, LocalDate dateOfBirth,
                Role role) {
        this.surname     = surname;
        this.name        = name;
        this.patronymic  = patronymic;
        this.dateOfBirth = dateOfBirth;
        this.role        = (role == null) ? Role.READER : role;
        this.files       = new File[0];
        User.sequence++;
        this.idx = User.sequence; // какой-то id пользака заведем ... на случай поиска
    }
    public User(String surname, String name, String patronymic, LocalDate dateOfBirth) {
        this(surname, name, patronymic, dateOfBirth, Role.READER);
    }

    // ИО - имя отчество пользователя
    public String getIO() {
        return this.name + " " + this.patronymic;
    }

    @Override
    public String toString() {
        return "User{" +
                "idx=" + idx +
                ", Surname='" + surname + '\'' +
                ", Name='" + name + '\'' +
                ", Patronymic='" + patronymic + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", files=" + Arrays.toString(files) +
                ", role=" + role +
                ", random=" + random +
                '}';
    }
}
