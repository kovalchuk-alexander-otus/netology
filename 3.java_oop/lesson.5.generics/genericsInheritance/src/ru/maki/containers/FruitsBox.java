package ru.maki.containers;

import ru.maki.Fruits;

public class FruitsBox<K, T extends Fruits> {
    K description;
    T obj;

    public void putIntoBox(K description, T fruits) {
        System.out.println(fruits);
        // System.out.println(fruits.getClass().getName());
    }
}
