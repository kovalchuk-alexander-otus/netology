package ru.maki.client;

import java.util.HashMap;
import java.util.Map;

// Клиент
public class Client {
    String name;
    String secondName;
    Map<ContactsType,Contact> contacts;
    Address address;

    public Client(String name, String secondName, Map<ContactsType, Contact> contacts, Address address) {
        this.name = name;
        this.secondName = secondName;
        this.contacts = contacts;
        this.address = address;
    }

    public Map<ContactsType, Contact> getContacts() {
        return contacts;
    }

    public Address getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return "Client{" +
                "name='" + name + '\'' +
                ", secondName='" + secondName + '\'' +
                ", contacts=" + contacts +
                ", address=" + address +
                '}';
    }
}
