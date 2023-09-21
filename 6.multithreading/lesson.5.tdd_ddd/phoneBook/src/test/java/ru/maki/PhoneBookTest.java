package ru.maki;

import org.junit.Test;

import static org.junit.Assert.*;


public class PhoneBookTest {
    /**
     * Простой тест
     * добавление 3х разных контактов в Телефонную книгу
     */
    @Test
    public void testAdd() {
        PhoneBook phoneBook = new PhoneBook();
        int expected = 3;
        int actual;
        phoneBook.add("Alex", "23553");
        phoneBook.add("Felix", "13442");
        actual = phoneBook.add("Junior", "13423");
        assertEquals(String.format("Число контактов [%s] не соответствует заведенному [%s]", expected, actual), expected, actual);
    }

    /**
     * Сложный тест
     * добавление в Телефонную книгу одного имени два раза
     */
    @Test
    public void testAddWhitRepeatName() {
        PhoneBook phoneBook = new PhoneBook();
        int expected = 3;
        int actual;
        phoneBook.add("Alex", "23553");
        phoneBook.add("Felix", "13442");
        phoneBook.add("Junior", "13423");
        actual = phoneBook.add("Alex", "23235");
        assertEquals(String.format("Число контактов [%s] не соответствует заведенному [%s]", expected, actual), expected, actual);
    }

    /**
     * Сложный тест
     * добавление в Телефонную книгу одинаковых номеров по разным именам
     */
    @Test
    public void testAddWhitRepeatPhone() {
        PhoneBook phoneBook = new PhoneBook();
        int expected = 4;
        int actual;
        phoneBook.add("Alex", "23553");
        phoneBook.add("Felix", "23553");
        phoneBook.add("Junior", "23553");
        actual = phoneBook.add("Angie", "52354");
        assertEquals(String.format("Число контактов [%s] не соответствует заведенному [%s].", expected, actual), expected, actual);
    }

    /**
     * Простой тест
     * добавление 3х разных контактов в Телефонную книгу и поиск одного из них
     */
    @Test
    public void testFindByNumber() {
        PhoneBook phoneBook = new PhoneBook();
        String expected = "Alex";
        phoneBook.add("Alex", "23553");
        phoneBook.add("Felix", "23123");
        phoneBook.add("Junior", "34634");
        String actual = phoneBook.findByNumber("23553");
        assertEquals(String.format("Вместо искомого контакта [%s] найден [%s].", expected, actual), expected, actual);
    }

    /**
     * Сложный тест
     * добавление 3х контактов в Телефонную книгу, первый и последний из которых схожи и поиск одного из них
     */
    @Test
    public void testFindByNumberDouble() {
        PhoneBook phoneBook = new PhoneBook();
        String expected = "Alex";
        phoneBook.add("Alex", "23553");
        phoneBook.add("Felix", "23423");
        phoneBook.add("Alex", "23442");
        String actual = phoneBook.findByNumber("23442");
        assertEquals(String.format("Вместо искомого контакта [%s] найден [%s].", expected, actual), expected, actual);
    }

    @Test
    public void testFindByNumberDoubleNull() {
        PhoneBook phoneBook = new PhoneBook();
        String expected = null;
        phoneBook.add("Alex", "23553");
        phoneBook.add("Felix", "23423");
        phoneBook.add("Alex", "23442");
        String actual = phoneBook.findByNumber("23553");
        assertEquals(String.format("Вместо искомого контакта [%s] найден [%s].", expected, actual), expected, actual);
    }

    /**
     * Простой тест
     * добавление 3х разных контактов в Телефонную книгу и поиск отсутствующего
     */
    @Test
    public void testFindByNumberNull() {
        PhoneBook phoneBook = new PhoneBook();
        String expected = null;
        phoneBook.add("Alex", "23553");
        phoneBook.add("Felix", "23123");
        phoneBook.add("Junior", "34634");
        String actual = phoneBook.findByNumber("14312");
        assertEquals(String.format("Вместо искомого контакта [%s] найден [%s].", expected, actual), expected, actual);
    }

    /**
     * Простой тест
     * поиск по пустой Телефонной книге
     */
    @Test
    public void testFindByNumberEmpty() {
        PhoneBook phoneBook = new PhoneBook();
        String expected = null;
        String actual = phoneBook.findByNumber("14312");
        assertEquals(String.format("Вместо искомого контакта [%s] найден [%s].", expected, actual), expected, actual);
    }

    /**
     * Сложный тест
     * поиск по Телефонной книге, содержащей одинаковые номера у нескольких контактов
     */
    @Test
    public void testFindByNumberMany() {
        PhoneBook phoneBook = new PhoneBook();
        String expected = "Alex, Felix, Junior";
        phoneBook.add("Alex", "23553");
        phoneBook.add("Felix", "23553");
        phoneBook.add("Junior", "23553");
        String actual = phoneBook.findByNumber("23553");
        assertEquals(String.format("Вместо искомого контакта [%s] найден [%s].", expected, actual), expected, actual);
    }

    /**
     * Простой тест
     * поиск по Телефонной книге номера телефона по имени
     */
    @Test
    public void testFindByName(){
        PhoneBook phoneBook = new PhoneBook();
        String expected = "12312";
        phoneBook.add("Alex", "23553");
        phoneBook.add("Felix", "12312");
        phoneBook.add("Junior", "34244");
        String actual = phoneBook.findByName("Felix");
        assertEquals(String.format("Вместо искомого номера телефона [%s] найден [%s].", expected, actual), expected, actual);
    }
    /**
     * Простой тест
     * поиск по Телефонной книге номера телефона по отсутствующему там имени
     */
    @Test
    public void testFindByNameNull(){
        PhoneBook phoneBook = new PhoneBook();
        String expected = null;
        phoneBook.add("Alex", "23553");
        phoneBook.add("Felix", "12312");
        phoneBook.add("Junior", "34244");
        String actual = phoneBook.findByName("Edvard");
        assertEquals(String.format("Вместо искомого номера телефона [%s] найден [%s].", expected, actual), expected, actual);
    }
    /**
     * Простой тест
     * поиск по пустой Телефонной книге
     */
    @Test
    public void testFindByNameEmpty(){
        PhoneBook phoneBook = new PhoneBook();
        String expected = null;
        String actual = phoneBook.findByName("Edvard");
        assertEquals(String.format("Вместо искомого номера телефона [%s] найден [%s].", expected, actual), expected, actual);
    }
    /**
     * Сложный тест
     * поиск по Телефонной книге контакта добавленного два раза
     */
    @Test
    public void testFindByNameDouble() {
        PhoneBook phoneBook = new PhoneBook();
        String expected = "23235";
        phoneBook.add("Alex", "23553");
        phoneBook.add("Felix", "13442");
        phoneBook.add("Junior", "13423");
        phoneBook.add("Alex", "23235");
        String actual = phoneBook.findByName("Alex");
        assertEquals(String.format("Вместо искомого номера телефона [%s] найден [%s].", expected, actual), expected, actual);
    }


}


