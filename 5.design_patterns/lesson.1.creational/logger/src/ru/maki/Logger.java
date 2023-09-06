package ru.maki;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Logger {

    public final DateTimeFormatter FORMAT_DATE = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");

    int row;
    private static Logger instance;

    private Logger() {
    }

    public static Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    /**
     * метод логирования сообщений в терминал
     *
     * @param message
     */
    public void log(String message) {
        System.out.printf("[%s %d] %s%n", LocalDateTime.now().format(FORMAT_DATE), ++this.row, message);
    }
}
