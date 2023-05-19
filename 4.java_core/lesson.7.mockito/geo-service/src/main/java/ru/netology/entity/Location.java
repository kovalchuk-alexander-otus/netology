package ru.netology.entity;

public class Location {

    private final String city;

    private final Country country;

    private final String street;

    private final int builing;

    public Location(String city, Country country, String street, int builing) {
        this.city = city;
        this.country = country;
        this.street = street;
        this.builing = builing;
    }

    public String getCity() {
        return city;
    }

    public Country getCountry() {
        return country;
    }

    public String getStreet() {
        return street;
    }

    public int getBuiling() {
        return builing;
    }

    @Override
    public boolean equals(Object obj) {
        Location l = (Location) obj;
        return ( this.city == null && l.city == null || this.city.equals(l.city) )
            && ( this.country == null && l.country == null || this.country.equals(l.country) )
            && ( this.street == null && l.street == null || this.street.equals(l.street) )
            && this.builing == l.builing;
    }
}
