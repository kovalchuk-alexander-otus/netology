package ru.netology.service;

public class CustomsService {
    static final int RATE_OF_DUTY = 1;
    static final int RATE_OF_DUTY_BY_WEIGHT = 100;

    // вычисляем размер пошлины
    public static int getAmountOfDuty(int price, int weight) {
        return price * RATE_OF_DUTY / 100 + weight * RATE_OF_DUTY_BY_WEIGHT;
    }
}
