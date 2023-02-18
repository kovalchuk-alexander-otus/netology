package ru.maki;

import java.time.LocalDateTime;

public class SmartLogger implements Logger {
    protected int numRows;
    final static String MSG_INFO = "INFO";
    final static String MSG_ERROR = "ERROR";

    @Override
    public void log(String msg) {
        System.out.printf("%s#%d [%s] %s%n",
                msg.toUpperCase().contains("ERROR") ? MSG_ERROR : MSG_INFO, ++numRows, LocalDateTime.now(), msg);
    }
}
