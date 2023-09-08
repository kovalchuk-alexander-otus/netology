package ru.maki.shop;

public interface ProductsLoader {
    /**
     * загрузка продуктов из source (file/db/...)
     */
    void load();

    /**
     * пополнение товаров на складе - подгрузка из source (file/db/...)
     */
    void delivery();

    /**
     * обновление данных в source (актуализация информации по итогам продаж)
     */
    void refresh();
}
