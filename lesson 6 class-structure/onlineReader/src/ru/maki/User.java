package ru.maki;

import ru.maki.enums.Country;
import ru.maki.enums.Gender;

import java.util.Calendar;

public class User {
    private static int userCount = 0;

    private String surName; // фамилия
    private String firstName; // имя
    private String patronymic; // отчество

    private Gender gender; // пол (ENUM)
    private Calendar dateOfBirth; // дата рождения
    private Calendar dateOfDeath; // дата смерти
    private Country country; // страна (ENUM)

    private String email; // e-mail

    public User(String surName, String firstName, String patronymic, Gender gender,
                Calendar dateOfBirth, Calendar dateOfDeath, Country country, String email) {
        this.surName = surName;
        this.firstName = firstName;
        this.patronymic = patronymic;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.dateOfDeath = dateOfDeath;
        this.country = country;
        this.email = email;

        User.userCount++;
        System.out.println(this);
    }

    public User(String surName, String firstName, String patronymic, Gender gender, Calendar dateOfBirth) {
        this(surName,firstName,patronymic,gender,dateOfBirth,Author.defaultDate,Country.NO_INFO, "");
    }

    public static int getUserCount(){
        return User.userCount;
    }

    @Override
    public String toString() {
        return "User{" +
                "surName='" + surName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", gender=" + gender +
                (dateOfBirth == Author.defaultDate ? ", dateOfBirth='no info'" :
                        ", dateOfBirth='" + Author.df.format(dateOfBirth.getTime()) + '\'') +
                (dateOfDeath == Author.defaultDate ? ", dateOfBirth='no info'" :
                        ", dateOfDeath='" + Author.df.format(dateOfDeath.getTime()) + '\'') +
                ", country=" + country +
                ", email=" + email +
                '}';
    }
}
