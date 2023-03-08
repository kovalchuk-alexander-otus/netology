package ru.maki.utils;

import ru.maki.game.GameProgress;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

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
    public static void saveGame(String file, GameProgress gameProgress) {
        Log.info("Сохраняем уровень в файл : " + file);
        try (FileOutputStream fileOutputStream = new FileOutputStream(file);
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
            objectOutputStream.writeObject(gameProgress);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // поднятие уровня из файла
    public static GameProgress openProgress(String file) {
        Log.info("Читаем уровень из файла : " + file);
        try (FileInputStream fileInputStream = new FileInputStream(file);
             ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
            return (GameProgress) objectInputStream.readObject();
        } catch (ClassNotFoundException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    // содержимое папки savegames - список сохраненных уровней
    public static List<String> getSaveFiles() {
        List<String> saveFiles = new ArrayList<>();
        File log = new File(Source.SAVE);
        if (log.isDirectory()) {
            for (File file : log.listFiles()) {
                saveFiles.add(file.getAbsolutePath());
            }
        }
        return saveFiles;
    }

    // архивирование уровня (пакетное архивирование)
    public static void zipFiles(String zipFile, List<String> files) {
        Log.info("Начинаем формировать архив сохраненных уровней : " + zipFile);
        try (ZipOutputStream zipOutputStream = new ZipOutputStream(new FileOutputStream(zipFile))) {
            for (String file : files) {
                zipFile(zipOutputStream, file);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Log.info("Удаляем файлы, помещенные в архив : " + files);
        for (String file : files) {
            File saveFile = new File(file);
            if (saveFile.delete()) {
                Log.info(file + " : удален.");
            } else {
                Log.warning(file + " : не удалось удалить.");
            }
        }
    }

    // архивирование одного файла
    private static void zipFile(ZipOutputStream zipOutputStream, String file) {
        Log.info("Помещаем в архив : " + file);
        try (FileInputStream fileInputStream = new FileInputStream(file)) {
            ZipEntry zipEntry = new ZipEntry(file.replace(Source.SAVE, ""));
            zipOutputStream.putNextEntry(zipEntry);
            byte[] buffer = new byte[fileInputStream.available()];
            fileInputStream.read(buffer);
            zipOutputStream.write(buffer);
            zipOutputStream.closeEntry();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // разархивирование (всего пакета)
    public static void openZip(String zipFile, String dir) {
        Log.info("Начинаем извлекать файлы из архива : " + zipFile + " и размещаем их в : " + dir);
        try (ZipInputStream zipInputStream = new ZipInputStream(new FileInputStream(zipFile))) {
            ZipEntry zipEntry;
            String name;
            while ((zipEntry = zipInputStream.getNextEntry()) != null) {
                name = zipEntry.getName();
                openZipFile(zipInputStream, dir + name);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // разархивирование одного файла
    public static void openZipFile(ZipInputStream zipInputStream, String file) {
        Log.info("Извлекаем из архива : " + file);
        try (FileOutputStream fileOutputStream = new FileOutputStream(file)) {
            for (int c = zipInputStream.read(); c != -1; c = zipInputStream.read()) {
                fileOutputStream.write(c);
            }
            fileOutputStream.flush();
            zipInputStream.closeEntry();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
