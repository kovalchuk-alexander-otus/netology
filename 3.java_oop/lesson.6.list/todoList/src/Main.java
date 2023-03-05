import ru.maki.TodoList;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        TodoList todoList = new TodoList();
        Scanner scanner = new Scanner(System.in);
        String input;
        int index;

        while (true) {
            System.out.print("\nВыберите операцию:\n" +
                    "0. Выход из программы\n" +
                    "1. Добавить дело\n" +
                    "2. Показать дела\n" +
                    "3. Удалить дело по номеру\n" +
                    "4. Удалить дело по названию\n" +
                    "5. Удалить дело по ключевому слову\n" +
                    "Ваш выбор: ");
            input = scanner.nextLine();

            try {
                index = Integer.parseInt(input);
            } catch (Exception e) {
                System.out.printf("%nВы ввели некорректное значение индекса операции [%s] - ожидается число. " +
                        "Попробуйте еще раз.%n", input);
                continue;
            }

            if (index == 0) {
                break;
            }
            switch (index) {
                case 1:
                    System.out.print("\nВведите название задачи: ");
                    input = scanner.nextLine();
                    todoList.addCase(input);
                    todoList.showTodoList();
                    break;
                case 2:
                    todoList.showTodoList();
                    break;
                case 3:
                    System.out.print("\nВведите индекс задачи для удаления: ");
                    int caseIndex;
                    input = scanner.nextLine();
                    try {
                        caseIndex = Integer.parseInt(input);
                    } catch (Exception e) {
                        System.out.printf("%nВы ввели некорректное значение номера задачи [%s] - ожидается число. " +
                                "Попробуйте еще раз.%n", input);
                        continue;
                    }
                    todoList.deleteCase(caseIndex - 1);
                    todoList.showTodoList();
                    break;
                case 4:
                    System.out.print("\nВведите название задачи для удаления: ");
                    input = scanner.nextLine();
                    todoList.deleteCase(input);
                    todoList.showTodoList();
                    break;
                case 5:
                    System.out.print("\nВведите ключевое слово или фразу для удаления: ");
                    input = scanner.nextLine();
                    todoList.deleteByKeyWord(input);
                    todoList.showTodoList();
                    break;
            }
        }
    }
}