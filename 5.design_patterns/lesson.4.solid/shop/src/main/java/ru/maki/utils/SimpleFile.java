package ru.maki.utils;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

/**
 * TODO(completed): SOLID.Single Responsibility Principle
 * классы SimpleFile, Logger, Formatter  - содержат функционал определенной специфики ...
 * нет перегрузки неотносящейся функциональности
 *
 */
public class SimpleFile {
    private static Logger logger = Logger.getInstance();

    /**
     * чтение из файла
     *
     * @param source
     * @param charset
     * @return
     */
    public static String read(String source, String charset) {
        File file = new File(source);
        String data;
        try {
            logger.log("начинаем читать файл [" + source + "]");
            data = FileUtils.readFileToString(file, charset);
        } catch (
                IOException e) {
            logger.log("ошибка чтения из файла");
            throw new RuntimeException(e);
        }
        logger.log(data);
        return data;
    }

    /**
     * запись в файл
     *
     * @param text
     * @param source
     * @param charset
     */
    public static void write(String text, String source, String charset){
        File file = new File(source);

        try {
            logger.log("начинаем писать в файл [" + source + "]");
            FileUtils.writeStringToFile(file, text, charset);
            System.out.println("Successfully written data to the file");
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

}
