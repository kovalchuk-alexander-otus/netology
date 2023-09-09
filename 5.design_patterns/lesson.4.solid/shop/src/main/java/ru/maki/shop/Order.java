package ru.maki.shop;

public interface Order {
    void product(String type, String name, int price, int count);
    void delivery(String city, String street, int house, int apartment);
    void pay(String card, int pin);
    void rate(int rate, String review);
}
