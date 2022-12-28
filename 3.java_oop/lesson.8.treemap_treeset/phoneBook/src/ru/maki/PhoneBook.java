package ru.maki;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhoneBook {
    final Map<String, List<Contact>> phones;

    public PhoneBook() {
        this.phones = new HashMap<>();
    }

    // добавление группы
    public void addGroup(String group){
        if (this.phones.containsKey(group)){
            System.out.printf("Такая [%s] группа контактов уже существует.%n", group);
        } else {
            this.phones.put(group, new ArrayList<>());
        }
    }

    // добавление контакта
    // группа + объект
    public void addContact(String group, Contact contact) {
        if (this.phones.containsKey(group)) {
            List<Contact> contacts = this.phones.get(group);
            contacts.add(contact);
        } else {
            List<Contact> contacts = new ArrayList<>();
            contacts.add(contact);
            this.phones.put(group, contacts);
        }
    }

    // добасление контакта
    // перегрузка метода : атрибуты записи - группа, имя, номер
    public void addContact(String group, String name, String phoneNumber){
        Contact contact = this.searchByNumber(phoneNumber);
        addContact(group, contact == null ? new Contact(name, phoneNumber) : contact);
    }

    // поиск контактов по группе
    public Contact searchInGroup(String group, String name) {
        if (this.phones.containsKey(group)) {
            for (Contact contact : this.phones.get(group)) {
                if (contact.name.equals(name)) return contact;
            }
        }
        return null;
    }

    // поиск контакта по номеру
    public Contact searchByNumber(String phoneNumber) {
        for (List<Contact> contacts : phones.values()) {
            for (Contact contact : contacts) {
                if(contact.phoneNumber.equals(phoneNumber)) return contact;
            }
        }
        return null;
    }

    public String searchNameByNumber(String phoneNumber) {
        for (List<Contact> contacts : phones.values()) {
            for (Contact contact : contacts) {
                if(contact.phoneNumber.equals(phoneNumber)) return contact.name;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "PhoneBook{" +
                "phones=" + phones +
                '}';
    }
}
