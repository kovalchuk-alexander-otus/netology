package ru.maki;

public class Person {
    protected final String name;
    protected final String surname;
    protected int age;
    protected String address;
    public static final int NO_AGE_DATA = -1; // значение Возраста, в случае, когда нет информации
    public static final int CHILD_AGE = 0; // значение Возраста по-умоланию, при создании Ребенка
    public static final int MAX_AGE = 130; // максимально допустимое в системе значение Возраста

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

    public int getAge() {
        return age;
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
        return new PersonBuilder(this.surname, Person.CHILD_AGE, this.address);
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
}
