package ru.maki.containers;

import ru.maki.products.Vegetables;

public class VegetableBox<K, T extends Vegetables> {
    K description;
    T obj;

    public void putIntoBox(K description, T vegetables) {
        System.out.println(vegetables);
        // System.out.println(vegetables.getClass().getName());
    }
}
