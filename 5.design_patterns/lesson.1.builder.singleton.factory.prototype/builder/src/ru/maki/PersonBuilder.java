package ru.maki;

import java.util.OptionalInt;

public class PersonBuilder {

    protected String name = "";
    protected String surname = "";
    protected OptionalInt age = OptionalInt.empty();
    protected String address;

    public PersonBuilder() {

    }

    public PersonBuilder(String surname, int childAge, String address) {
        this.surname = surname;
        this.age = OptionalInt.of(childAge);
        this.address = address;
    }

    public Person build() {
        if (this.name.isEmpty()) {
            throw new IllegalStateException("Не задан обязательный параметр Имя [name]!");
        }
        if (this.surname.isEmpty()) {
            throw new IllegalStateException("Не задан обязательный параметр Фамилия [surname]!");
        }
        if (this.age.isPresent()) {
            return new Person(this.name, this.surname, this.age.getAsInt(), this.address);
        } else {
            return new Person(this.name, this.surname, this.address);
        }
    }

    public PersonBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public PersonBuilder setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public PersonBuilder setAge(int age) {
        if (age < Person.NEWBORN_AGE) {
            throw new IllegalArgumentException("Не корректно значение Возраста [age]! " +
                    "Возраст не может быть меньше 0 [" + age + "].");
        }
        if (age > Person.MAX_AGE) {
            throw new IllegalArgumentException("Есть сомнения, что возраст указан корректно [" + age + "]. " +
                    "Если возраст действительно больше [" + Person.MAX_AGE + " лет] - просьба связаться с поддержкой.");
        }
        this.age = OptionalInt.of(age);
        return this;
    }

    public PersonBuilder setAddress(String address) {
        this.address = address;
        return this;
    }
}
