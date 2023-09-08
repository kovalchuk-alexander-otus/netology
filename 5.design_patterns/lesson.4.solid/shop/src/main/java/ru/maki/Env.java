package ru.maki;

/**
 * все Magic живут тут
 *    возможно часть из них вообще стоит вынести в переменные окружения
 */
public class Env {
    public static final String SOURCE = "src/main/resources/products.json"; // источних данных по имеющимся в магазине продуктам
    public static final String CHARSET_UTF8 = "UTF-8"; // формат данных в источнике
    public static final String FORMAT_DATE_WITH_TIME = "yyyy-MM-dd HH:mm:ss"; // формат даты для Logger'а
}
