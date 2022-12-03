package ru.maki;

import java.util.ArrayList;
import java.util.List;

public class ActionList {

    final List<String> actionList;

    public ActionList() {
        this.actionList = new ArrayList<>();
    }

    // добавление в список мероприятия
    // (в конец списка)
    public void addAction(String action) {
        this.actionList.add(action);
    }

    // добавление в список мероприятия
    // (после указанного номера существующего в списке мероприятия)
    public void addAction(String action, int previousActionNum) {
        if (checkActionNum(previousActionNum)) {
            this.actionList.add(previousActionNum, action);
        }
    }

    // удаление из списка мероприятия по его номеру в списке
    public void removeAction(int actionNum) {
        if (checkActionNum(actionNum)) {
            this.actionList.remove(actionNum);
        }
    }

    // проверка индекса элемента из списка
    private boolean checkActionNum(int actionNum) {
        if (actionNum >= this.actionList.size()) {
            System.out.printf("В списке не обнаружили задачи с таким номером [%d]. " +
                                      "Попробуйте еще раз.\n\n",
                              actionNum);
            return false;
        }
        return true;
    }

    // вывод на экран списка мероприятий
    public void showActionList() {
        System.out.println("\n\n=====================================");
        System.out.println("Ваш список задач");
        System.out.println("-------------------------------------");
        for (int i = 0; i < this.actionList.size(); i++) {
            System.out.printf("%d : %s%n", i + 1, this.actionList.get(i));
        }
        System.out.println("-------------------------------------");
    }

}
