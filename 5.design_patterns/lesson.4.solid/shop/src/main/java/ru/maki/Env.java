package ru.maki;

import java.time.format.DateTimeFormatter;

/**
 * TODO(complete) : Magic
 * все Magic живут тут
 *    возможно часть из них вообще стоит вынести в переменные окружения
 */
public class Env {
    public static final String SOURCE = "src/main/resources/json/goods.json"; // источних данных по имеющимся в магазине продуктам
    public static final String DELIVERY = "src/main/resources/json/delivery-%s.json"; // шаблон имени файла с данными о поставке товаров на склад
    public static final String CHARSET_UTF8 = "UTF-8"; // формат данных в источнике
    public static final String FORMAT_DATE_WITH_TIME = "yyyy-MM-dd HH:mm:ss"; // формат даты для Logger'а
    public static final String FORMAT_DATE_WITHOUT_TIME = "yyyy-MM-dd"; // формат даты для Logger'а
    public static final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(Env.FORMAT_DATE_WITH_TIME);
    public static final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern(Env.FORMAT_DATE_WITHOUT_TIME);
}
