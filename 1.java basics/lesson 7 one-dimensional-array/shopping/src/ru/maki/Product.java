package ru.maki;

public class Product {
    private String name;
    private double price;

    public Product(String name, double price) {
        this.name = Character.toUpperCase(name.charAt(0)) + name.substring(1);
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}
