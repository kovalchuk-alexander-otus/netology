package ru.maki.role;

import ru.maki.File;

// Администратор
public interface Administrator {

    // находит книги
    void searchBook(String name, File[] files);

    // выдает книги
    void giveBook(File file, File[] files);

    // уведомляет о просрочках времени возврата
    void lateNotice(File[] files);
}
