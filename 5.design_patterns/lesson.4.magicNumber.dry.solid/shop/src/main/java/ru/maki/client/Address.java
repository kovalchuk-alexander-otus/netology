package ru.maki.client;

public class Address {
    Country country; // страна
    City city; // город
    String street; // улица
    int building; // дом
    int apartment;  // квартира

    public Address(Country country, City city, String street, int building, int apartment) {
        this.country = country;
        this.city = city;
        this.street = street;
        this.building = building;
        this.apartment = apartment;
    }
}
