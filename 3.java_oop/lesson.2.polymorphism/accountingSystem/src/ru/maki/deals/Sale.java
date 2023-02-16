package ru.maki.deals;

public class Sale extends Deal {
    public Sale(String product, int price) {
        super("Продажа " + product + " на " + price + " руб.", 0, price);
    }
}