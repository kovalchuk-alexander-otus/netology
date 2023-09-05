package ru.maki;

public class PersonBuilder {
    private String name;
    private String surname;
    private int age = PersonBuilder.NOT_AGE;
    private String city;

    public static final int NOT_AGE = -1;

    public PersonBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public PersonBuilder setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public PersonBuilder setAge(int age) {
        if (age < 0) throw new IllegalArgumentException("Некорректное значение для возраста [" + age + "]!");
        this.age = age;
        return this;
    }

    public PersonBuilder setAddress(String address) {
        this.city = address;
        return this;
    }

    public Person build() {
        if (this.name == null || this.name.isEmpty()) throw new IllegalStateException("Не задано имя!");
        if (this.surname == null || this.surname.isEmpty()) throw new IllegalStateException("Не задана фамилия!");
        return new Person(this.name, this.surname, this.age, this.city);
    }

}
