import ru.maki.ActionList;
import ru.maki.Dialog;

public class Main {

    public static void main(String[] args) {

        ActionList actionList = new ActionList();
        int        actionType;
        int        actionNum;
        String     action;

        while (true) {

            try {
                actionType =
                        Dialog.getAnswer("Выберите действие:\n" +
                                                 "        1. Добавить задачу\n" +
                                                 "        2. Вывести список задач\n" +
                                                 "        3. Удалить задачу\n" +
                                                 "        4. Добавить задачу перед " +
                                                 "существующей в списке" +
                                                 " \n" +
                                                 "        0. Выход\n" +
                                                 " > ",
                                         "Вы ввели не тип операции. Попробуйте еще раз.");
            } catch (Exception e) {
                continue;
            }

            switch (actionType) {
                case 0: // Выход
                    return;
                case 1: // Добавить задачу (в конец списка)
                    action = Dialog.getAnswer("Введите задачу для планирования:");
                    actionList.addAction(action);
                    break;
                case 2: // Вывести список задач на экран
                    actionList.showActionList();
                    break;
                case 3: // Удалить задачу
                    try {
                        actionNum =
                                Dialog.getAnswer("Введите номер задачи для удаления:",
                                                 "Вы ввели не номер задачи. " +
                                                 "Попробуйте еще раз.");
                    } catch (Exception e) {
                        continue;
                    }
                    actionList.removeAction(actionNum-1);
                    break;
                case 4: // Добавить задачу (перед указанной в списке)
                    try {
                        actionNum =
                                Dialog.getAnswer("Введите номер задачи из списка:",
                                                 "Вы ввели не номер задачи. " +
                                                         "Попробуйте еще раз.");
                    } catch (Exception e) {
                        continue;
                    }
                    action = Dialog.getAnswer("Введите задачу для планирования:");
                    actionList.addAction(action, actionNum-1);
                    break;
                default:
                    System.out.println("Вы выбрали тип операции, отсутствующий среди " +
                                               "предложенных. Попробуйте еще раз.");
            }
            System.out.println();
        }
    }

}