package ru.maki;

import java.util.Objects;
import java.util.OptionalInt;

public class Person {
    protected final String name;
    protected final String surname;
    protected int age;
    protected String address;
    public static final int NO_AGE_DATA = -1; // значение Возраста, в случае, когда нет информации
    public static final int NEWBORN_AGE = 0; // значение Возраста по-умоланию, при создании Ребенка
    public static final int MAX_AGE = 130; // максимально допустимое в системе значение Возраста

    public Person(String name, String surname) {
        this(name, surname, Person.NO_AGE_DATA, null);
    }

    public Person(String name, String surname, int age, String address) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public OptionalInt getAge() {
        return OptionalInt.of(age);
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    /*раз в году, поздравляем персонажа с днюрой .. не чаще, т.к. мотает счетчик лет*/
    public void happyBirthday() {
        System.out.println("С днем варения, категорически!");
        this.age += 1;
    }

    /*статус информации о возрасте*/
    public boolean hasAge() {
        return this.age != NO_AGE_DATA;
    }

    /*статус информации о адресе*/
    public boolean hasAddress() {
        return this.address != null;
    }

    /*предзаполним билдер для Ребенка*/
    public PersonBuilder newChildBuilder() {
        return new PersonBuilder(this.surname, Person.NEWBORN_AGE, this.address);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        if (age != person.age) return false;
        if (!name.equals(person.name)) return false;
        if (!surname.equals(person.surname)) return false;
        return Objects.equals(address, person.address);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + surname.hashCode();
        result = 31 * result + age;
        result = 31 * result + (address != null ? address.hashCode() : 0);
        return result;
    }
}
