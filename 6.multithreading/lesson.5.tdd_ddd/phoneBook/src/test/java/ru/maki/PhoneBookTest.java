package ru.maki;

import org.junit.Test;

import static org.junit.Assert.*;


public class PhoneBookTest {
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
}
