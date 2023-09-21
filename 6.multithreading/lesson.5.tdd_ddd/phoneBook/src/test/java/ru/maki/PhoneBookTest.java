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
        actual = phoneBook.add("Junior", "13423");
        phoneBook.add("Alex", "23235");
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
        String expected = "Junior";
        phoneBook.add("Alex", "23553");
        phoneBook.add("Felix", "23423");
        phoneBook.add("Junior", "23553");
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
}
