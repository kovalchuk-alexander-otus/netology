package ru.maki;

import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Телефонная книга
 */

@NoArgsConstructor
public class PhoneBook {

    private Map<String, String> nameBook = new HashMap<>();
    private Map<String, List<String>> phoneBook = new HashMap<>();

    /**
     * Добавление в Телефонную книгу имени с номером
     * (гарантируется, что не будут добавляться повторяющиеся имена)
     *
     * @return количество контактов после добавления
     */
    public int add(String name, String phone) {

        // добавление в список имен
        this.nameBook.put(name, phone);

        // добавление в список номеров
        String link = null;
        String key = null;
        List<String> value = null;
        for (Map.Entry<String, List<String>> entry : this.phoneBook.entrySet()) {
            for (String person : entry.getValue()) {
                if (person.equals(name)) {
                    link = person; // ссылка непосредственно на имя в списке
                    key = entry.getKey(); // телефон
                    value = entry.getValue(); // список пользователей с таким номером
                    break;
                }
            }
            if (key != null) break;
        }

        if (key != null) { // контакт с данным именем ранее уже был в Телефонной книге (имя следует удалить)
            if (value.size() == 1) {
                this.phoneBook.remove(key);
            } else {
                this.phoneBook.get(key).remove(link);
            }
        }

        if (!this.phoneBook.containsKey(phone)) {
            this.phoneBook.put(phone, new ArrayList<>());
        }
        this.phoneBook.get(phone).add(name);

        return this.nameBook.size();
    }

    /**
     * Имя по номеру телефона
     */
    public String findByNumber(String phone) {
        return null;
    }
}
