package ru.maki;

import ru.maki.enums.Country;
import ru.maki.enums.Gender;
import ru.maki.enums.Genre;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Author {

    public static final Calendar defaultDate = new GregorianCalendar(4444, Calendar.JANUARY, 1);
    public static final DateFormat df = new SimpleDateFormat("dd MMM yyy GG");

    private String surName; // фамилия
    private String firstName; // имя
    private String patronymic; // отчество

    private Gender gender; // пол (ENUM)
    private Calendar dateOfBirth; // дата рождения
    private Calendar dateOfDeath; // дата смерти
    private String biography; // биография
    private Country country; // страна (ENUM)

    private Genre prevailingGenre; // превалирующий жанр (ENUM)

    // TODO: описать конструктор

    public Author(String surName, String firstName, String patronymic, Gender gender, Genre prevailingGenre) {
        this(surName, firstName, patronymic, gender,
                Author.defaultDate, Author.defaultDate, "", Country.NO_INFO,
                prevailingGenre);
    }

    public Author(String surName, String firstName, String patronymic, Gender gender, Calendar dateOfBirth,
                  Calendar dateOfDeath, String biography, Country country, Genre prevailingGenre) {
        this.surName = surName;
        this.firstName = firstName;
        this.patronymic = patronymic;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.dateOfDeath = dateOfDeath;
        this.biography = biography;
        this.country = country;
        this.prevailingGenre = prevailingGenre;
        System.out.println(this.surName + " complete");
    }

    // внесение правок в биографию
    public void setBiography(String biography) {
        this.biography = biography;
        System.out.println("complete");
    }

    // расчет возраста на основе дат рождения, смерти и текущей даты
    public int getAge() {
        final DateFormat df_ = new SimpleDateFormat("MMdd");
        int age = 0;

        if (this.dateOfBirth != defaultDate) {
            Calendar secondDate = dateOfDeath != defaultDate ? this.dateOfDeath : new GregorianCalendar();
            age = secondDate.get(Calendar.YEAR) - this.dateOfBirth.get(Calendar.YEAR);
            if (Integer.parseInt(df_.format(secondDate.getTime())) <
                    Integer.parseInt(df_.format(dateOfBirth.getTime())))
                age--;
        } else age = -1;

        return age;
    }

    @Override
    public String toString() {
        return "Author{" +
                "surName='" + surName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", gender=" + gender +
                (dateOfBirth == defaultDate ? ", dateOfBirth='no info'" :
                        ", dateOfBirth='" + df.format(dateOfBirth.getTime()) + '\'') +
                (dateOfDeath == defaultDate ? ", dateOfBirth='no info'" :
                        ", dateOfDeath='" + df.format(dateOfDeath.getTime()) + '\'') +
                (getAge() != -1 ? ", age='" + getAge() + '\'' : "") +
                ", biography='" + biography + '\'' +
                ", country=" + country +
                ", prevailingGenre=" + prevailingGenre +
                '}';
    }
}
