package ru.maki.shop;

import java.util.ArrayList;
import java.util.List;

public class Shopping {
    static final List<Order> orders = new ArrayList<>();

    public static void show(){
        System.out.println("\n\nВывод списка заказов:");
        for (Order order : orders) {
            System.out.println(order);
        }
    }
}
