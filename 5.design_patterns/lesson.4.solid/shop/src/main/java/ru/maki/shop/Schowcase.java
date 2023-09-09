package ru.maki.shop;

public interface Schowcase {
    /**
     * демонстрация витрины магазина
     */
    void show();

    void show(ProductType productType);
    void show(ProductType productType, int rate);
    void show(ProductType productType, int price, int rate);
}
