package ru.maki.role;

import ru.maki.File;
import ru.maki.staff.User;

// Администратор
public interface Administrator {

    // находит книги
    void searchBook(String name, File[] files);

    // выдает книги
    void giveBook(User user, String name, File[] files);

    // уведомляет о просрочках времени возврата
    void lateNotice(User user, File[] files);
}
