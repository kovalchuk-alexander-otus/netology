package ru.maki.utils;

import ru.maki.game.GameProgress;
import ru.maki.utils.Log;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class Service {
    static String os;

    public static String getOS() {
        if (os == null || os.isEmpty()) {
            os = System.getProperty("os.name")
                    .toLowerCase();
        }
        return os;
    }

    // ОС Windows
    private static boolean isWindows() {
        return getOS().contains("win");
    }

    // ОС Unix-подобные
    private static boolean isUnix() {
        return getOS().contains("nux") || getOS().contains("nix");
    }

    // ОС MacOS
    private static boolean isMac() {
        return getOS().contains("mac");
    }

    // определение корневого каталога установки
    public static String getRootPath() {
        String rootPath;
        if (isWindows()) {
            rootPath = "C://Program Files";
        } else if (isUnix()) {
            rootPath = "/home/maki";
        } else if (isMac()) {
            rootPath = "/Users/admin";
        } else {
            Log.error("Не поддерживаемая версия ОС [" + os + "].");
            throw new RuntimeException("Не поддерживаемая ОС [" + os + "].");
        }
        return rootPath;
    }

    // устанавливаем с файлом или директорией имеем дело - по наличию расширения
    //   (чисто частный случай)
    public static boolean isFile(String name) {
        return name.contains(".");
    }

    // создание директории
    public static void mkDir(String path, String name) {
        File dir = new File(path);
        if (!dir.exists()) {
            Log.error("Не найдена родительская директория [" + path + "].");
            throw new RuntimeException("Не найдена родительская директория [" + path + "].");
        }
        dir = new File(path + "/" + name);
        if (dir.exists()) {
            Log.warning("Директория уже существует [" + path + "/" + name + "]");
        } else if (!dir.mkdir()) {
            Log.error("Не удалось создать папку [" + path + "] [" + name + "]");
            throw new RuntimeException("Не удалось создать папку [" + path + "] [" + name + "]");
        }
    }

    // создание файла
    public static void mkFile(String path, String name) {
        File dir = new File(path);
        if (!dir.exists()) {
            Log.error("Не найдена родительская директория [" + path + "].");
            throw new RuntimeException("Не найдена родительская директория [" + path + "].");
        }
        File file = new File(dir, name);
        if (file.exists()) {
            Log.warning("Файл уже существует [" + path + "/" + name + "]");
        } else {
            try {
                if (!file.createNewFile()) {
                    Log.error("Не удалось создать файл [" + path + "] [" + name + "]");
                    throw new RuntimeException("Не удалось создать файл [" + path + "] [" + name + "]");
                }
            } catch (IOException e) {
                Log.error("Ошибка в момент создания файла [" + path + "] [" + name + "]. " + e.getMessage());
                throw new RuntimeException(e);
            }
        }
    }

    // сохранение уровня в файл
    public void saveGame(String file, GameProgress gameProgress){

    }

    // архивирование уровня
    public void zipFiles(String zipFile, List<String> files){

    }
}
