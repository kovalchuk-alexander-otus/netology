package ru.maki.utils;

import ru.maki.Env;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * как один из вариантов DRY :
 *   чтобы не писать везде стандартную конструкцию по выводу логирования в терминал - реализуем один раз метод log
 */
public class Logger {
    private static Logger instance;
    DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(Env.FORMAT_DATE_WITH_TIME);

    private Logger() {

    }

    public static Logger getInstance() {
        if (Logger.instance == null) Logger.instance = new Logger();
        return instance;
    }

    public void log(String message) {
        System.out.printf("[%s] : %s%n", LocalDateTime.now().format(dateTimeFormatter), message);
    }
}
