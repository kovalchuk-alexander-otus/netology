package ru.maki;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Logger {

    public static final SimpleDateFormat format = new SimpleDateFormat("dd.MM.YYYY HH:mm:ss");
    public static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.YYYY HH:mm:ss");
    private int counter = 0;
    private Date date = new Date();
    private static Logger logger = null;

    public static Logger get() {
        if (logger == null) {
            logger = new Logger();
        }

        return logger;
    }

    public void log(String msg) {
        this.counter += 1;
        System.out.printf("[%s %d] %s%n", formatter.format(LocalDateTime.now()), this.counter, msg);
    }
}
