package ru.maki;

import java.util.Map;

import static ru.maki.Source.getSource;

// В папке Games создайте несколько директорий: src, res, savegames, temp.
//В каталоге src создайте две директории: main, test.
//В подкаталоге main создайте два файла: Main.java, Utils.java.
//В каталог res создайте три директории: drawables, vectors, icons.
//В директории temp создайте файл temp.txt.

public class Install {

    private final String rootPath;
    private final Map<String, String[]> allSource;

    // инициализация процесса установки
    public Install() {
        Log.info("Нвчало установки игры.");
        Log.info("Операционная система : " + Service.getOS());
        this.rootPath = Service.getRootPath();
        Log.info("Корневой путь установки : " + this.rootPath);
        this.allSource = getSource();
    }

    public String getRootPath() {
        return rootPath;
    }

    public Map<String, String[]> getAllSource() {
        return allSource;
    }

    // обертка процесса установки
    public void run() {
        Log.info("Запуск процесса установки (создание ресурсов - директорий/файлов)");
        create(this.rootPath, Source.ROOT);

        Log.info("Запись лога в temp.txt");
        Log.writeLogToFile();
    }

    // создание ресурсов (рекурсия)
    private void create(String path, String source) {
        if (this.allSource.get(source) == null) return;
        Log.info("Обработка дочерних структур для [" + path + "] [" + source + "].");
        for (String s : this.allSource.get(source)) {
            Log.info("Создание " + path + "/" + s + " - " + (Service.isFile(s) ? "файл" : "директория"));
            System.out.printf("%s/%s - %s%n", path, s, Service.isFile(s) ? "файл" : "директория");
            if (Service.isFile(s)) {
                Service.mkFile(path, s);
            } else {
                Service.mkDir(path, s);
            }
            create(path + "/" + s, s);
        }
    }
}
