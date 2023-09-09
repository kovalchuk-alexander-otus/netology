package ru.maki.shop;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

public class Shopping {
    static List<Order> orders = new ArrayList<>();

    public static void show(){
        System.out.println("\n\nВывод списка заказов:");
        for (Order order : orders) {
            System.out.println(order);
        }
    }
}
