package ru.maki;

import org.junit.Test;

import static org.junit.Assert.*;


public class PhoneBookTest {
    /**
     * Простой тест - добавление 3х разных контактов в Телефонную книгу
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
        // assertTrue(String.format("Число контактов [%s] не соответствует заведенному [%s]", expected, actual), actual == expected);
    }

    /**
     * Сложный тест - добавление в Телефонную книгу одного имени два раза
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
        // assertTrue(String.format("Число контактов [%s] не соответствует заведенному [%s]", expected, actual), actual == expected);
    }

    /**
     * Сложный тест - добавление в Телефонную книгу одинаковых номеров по разным именам
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
        assertEquals(String.format("Число контактов [%s] не соответствует заведенному [%s]", expected, actual), expected, actual);
        // assertTrue(String.format("Число контактов [%s] не соответствует заведенному [%s]", expected, actual), actual == expected);
    }
}
