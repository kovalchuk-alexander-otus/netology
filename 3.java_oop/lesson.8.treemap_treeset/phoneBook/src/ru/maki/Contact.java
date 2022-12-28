package ru.maki;

import java.util.Objects;

public class Contact {
    final String name;
    final String phoneNumber;

    // создание контакта
    public Contact(String name, String phoneNumber) {
        this.name            = name;
        this.phoneNumber = phoneNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contact contact = (Contact) o;
        return this.name.equals(contact.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.name);
    }

    @Override
    public String toString() {
        return "Contact{" +
                "name='" + name + '\'' +
                ", telephoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
