package ru.maki.products;

public abstract class Fruits {
    public String getName() {
        return "";
    }

    @Override
    public String toString() {
        return "Fruits{name = " + this.getName() +
                "}";
    }
}