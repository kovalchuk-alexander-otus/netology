package ru.maki;

import java.util.Objects;

public class Candidate implements Comparable<Candidate> {

    private final String surname; // Фамилия
    private final String name; // Имя
    private final String patronymic; // Отчество
    private final String fullName; // "Фамилия Имя Отчество" (через пробел) — уникальное значение
    private final Sex sex; // Пол
    private final int age; // Возраст

    // Релевантность резюме (соответствие резюме предлагаемой вакансии)
    //  (0-5, где 0 — низкое значение соответствия, а 5 — очень высокое значение соответствия)
    private final int relevance;

    // Оценка на собеседовании
    //  (0-5, где 0 — низкое значение оценки, а 5 — очень высокое значение оценки)
    private final int rating;

    public Candidate(String surname, String name, String patronymic, Sex sex, int age, int relevance, int rating) {
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.fullName = this.surname + " " + this.name + " " + this.patronymic;
        this.sex = sex;
        this.age = age;
        this.relevance = relevance;
        this.rating = rating;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Candidate candidate = (Candidate) o;
        return fullName.equals(candidate.fullName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fullName);
    }

    @Override
    public int compareTo(Candidate o) {
        return this.fullName.compareTo(o.fullName);
    }

    public int getRelevance() {
        return relevance;
    }

    public int getRating() {
        return rating;
    }

    public String getFullName() {
        return fullName;
    }

    @Override
    public String toString() {
        return "Candidate{" +
                "fullName='" + fullName +
                ", relevance=" + relevance +
                ", rating=" + rating +
                "}\n";
    }
}