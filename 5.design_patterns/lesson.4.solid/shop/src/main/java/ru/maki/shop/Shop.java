package ru.maki.shop;

import com.google.gson.Gson;
import org.apache.commons.io.FileUtils;
import ru.maki.Env;
import ru.maki.shop.Product;
import ru.maki.utils.Formatter;
import ru.maki.utils.Logger;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.List;


// Это финальная задача! В этом задании попрактикуемся с правилами чистого кода и принципами SOLID.
//
//Нужно написать программу-магазин, в которой пользователи заказывают товары. Вам предоставляется свобода в продумывании функциональности вашей программы, как и в проектировании её структуры. В процессе реализации вы должны применить принцип избегания магических чисел, DRY и как минимум 4 из 5 принципов SOLID, причём явно комментариями в коде или при отправке решения указать по одному примеру применения каждого принципа в вашем решении со ссылками на конкретные места кода на гитхабе.
//
//Примеры возможностей программы:
//
//TODO: Вывод доступных для покупки товаров
//TODO: Фильтрация товаров по ключевым словам, ценам, производителям
//TODO: Составление продуктовой корзины пользователя
//TODO: Трекинг заказа в системе доставки
//TODO: Возврат заказа, повтороение заказа
//TODO: Система рейтинга для товаров
//TODO: Простая рекомендательная система для покупок

//
// Склад -> наличие товаров
// Товар
// Заказ
//
public class Shop implements ProductsLoader {
    Logger logger = Logger.getInstance();
    List<Product> productList;

    public Shop() {
    }

    @Override
    public void load() {
        String data;
        File file = new File(Env.SOURCE);
        try {
            logger.log("начинаем читать файл [" + Env.SOURCE + "]");
            data = FileUtils.readFileToString(file, Env.CHARSET_UTF8);
        } catch (IOException e) {
            logger.log("ошибка чтения из файла");
            throw new RuntimeException(e);
        }
        logger.log(data);

        Gson gson = new Gson();
        Formatter formatter = new Formatter<Product>(Product.class);
        List<Product> products = formatter.jsonToList(data);
        System.out.println(products);
    }

    @Override
    public void delivery() {

    }

    @Override
    public void refresh() {

    }

}
