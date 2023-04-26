package ru.maki.client;

import java.util.HashMap;

// Клиент
public class Client {
    String name;
    String secondName;
    HashMap<ContactsType,Contact> contacts;
    Address address;

    public Client(String name, String secondName, HashMap<ContactsType, Contact> contacts, Address address) {
        this.name = name;
        this.secondName = secondName;
        this.contacts = contacts;
        this.address = address;
    }
}
