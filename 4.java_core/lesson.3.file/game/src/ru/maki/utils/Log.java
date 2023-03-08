package ru.maki.utils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

public class Log {
    private static final String INFO = "INFO";
    private static final String ERROR = "ERROR";
    private static final String WARNING = "WARNING";
    private static final String PATH = "/Games/temp";
    private static final String FILE = "temp.txt";
    public static final StringBuilder log = new StringBuilder();

    public static void info(String message) {
        write(INFO, message);
    }

    public static void warning(String message) {
        write(WARNING, message);
    }

    public static void error(String message) {
        write(ERROR, message);
    }

    public static void write(String type, String message) {
        log.append("[")
                .append(LocalDateTime.now())
                .append("] : ")
                .append(type)
                .append(" - ")
                .append(message)
                .append("\n");

    }

    public static void writeLogToFile() {
        File logFile = new File(Service.getRootPath() + PATH, FILE);
        try (FileWriter fileWriter = new FileWriter(logFile)) {
            fileWriter.write(log.toString());
            fileWriter.flush();
        } catch (IOException e) {
            Log.error("Ошибка в момент записи лога в файл [" + Service.getRootPath() + "/" + PATH + "] [" + FILE + "]" +
                    ".");
            throw new RuntimeException("Ошибка в момент записи лога в файл [" + Service.getRootPath() + "/" + PATH +
                    "] [" + FILE + "]. " + e.getMessage());
        }
    }

}
