package ru.maki;

import java.util.Objects;

public class Person {

    private final String name;
    private final String surname;
    private int age;
    String city;

    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public Person(String name, String surname, int age, String city) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getAge() {
        return age;
    }

    public String getCity() {
        return city;
    }

    public void setAddress(String address) {
        this.city = address;
    }

    /**
     * метод увеличивает возраст на год (если возраст изначально был известен)
     *
     */
    public void happyBirthday() {
        if(this.age != PersonBuilder.NOT_AGE){
            this.age++;
            System.out.printf("Позвольте вас чествовать с очередным кольцом времени на вашем срезе.. %d%n", this.age);
        }
    }

    /**
     * метод возвращает признак - известен ли возраст человека
     *
     * @return
     */
    public boolean hasAge() {
        return this.age >= 0;
    }

    /**
     * метод возвращает признак - известен ли адрес (город проживания) человека
     *
     * @return
     */
    public boolean hasAddress() {
        return this.city!=null && !this.city.isEmpty();
    }

    /**
     * метод создания дитяти
     *
     * @return
     */
    public PersonBuilder newChildBuilder(){
        System.out.println("Поздравляем с прибавлением в семействе..");
        return new PersonBuilder().setSurname(this.surname).setAddress(this.city).setAge(0);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + this.getAge() +
                ", city='" + city + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age && Objects.equals(name, person.name) && Objects.equals(surname, person.surname) && Objects.equals(city, person.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, age, city);
    }
}
