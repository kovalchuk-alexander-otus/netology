package ru.maki.role;

import ru.maki.File;
import ru.maki.staff.ReaderImpl;

// Администратор
@SuppressWarnings("unused")
public interface Administrator {

    // находит книги
    void searchBook(String name, File[] files);

    // выдает книги
    void giveBook(ReaderImpl reader, String name, File[] files);

    // уведомляет о просрочках времени возврата
    void lateNotice(ReaderImpl reader, File[] files);
}
