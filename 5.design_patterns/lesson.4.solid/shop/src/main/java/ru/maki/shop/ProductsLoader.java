package ru.maki.shop;

import java.util.List;

public interface ProductsLoader <K> {
    /**
     * загрузка продуктов из source (file/db/...)
     */
    List<K> load();

    /**
     * пополнение товаров на складе - подгрузка из source (file/db/...)
     */
    void delivery();

    /**
     * обновление данных в source (актуализация информации по итогам продаж)
     */
    void unload();
}
