package ru.maki;

import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

/**
 * Телефонная книга
 */

@NoArgsConstructor
public class PhoneBook {

    Map<String, String> phoneBook = new HashMap<>();
    Map<String, String> nameBook = new HashMap<>();

    /**
     * Добавление в Телефонную книгу имени с номером
     * (гарантируется, что не будут добавляться повторяющиеся имена)
     *
     * @return количество контактов после добавления
     */
    public int add(String name, String phone) {
        return 0;
    }
}
