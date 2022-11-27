package ru.maki;

public abstract class Vegetables {
    public String getName() {
        return "super class Vegetables";
    }

    @Override
    public String toString() {
        return "Vegetables{name = " + this.getName() +
                "}";
    }
}
