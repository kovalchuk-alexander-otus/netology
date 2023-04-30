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

    public Country getCountry() {
        return country;
    }

    public City getCity() {
        return city;
    }

    public String getStreet() {
        return street;
    }

    public int getBuilding() {
        return building;
    }

    public int getApartment() {
        return apartment;
    }

    @Override
    public String toString() {
        return "Address{" +
                "country=" + country +
                ", city=" + city +
                ", street='" + street + '\'' +
                ", building=" + building +
                ", apartment=" + apartment +
                '}';
    }
}
