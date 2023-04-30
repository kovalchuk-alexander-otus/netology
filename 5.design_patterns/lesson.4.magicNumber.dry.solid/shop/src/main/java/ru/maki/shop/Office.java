package ru.maki.shop;

import ru.maki.client.Address;

public class Office {
    String name; // название магазина
    Address address; // адрес магазина

    public Office(String name, Address address) {
        this.name = name;
        this.address = address;
    }

    @Override
    public String toString() {
        return "Office{" +
                "name='" + name + '\'' +
                ", address=" + address +
                '}';
    }
}
