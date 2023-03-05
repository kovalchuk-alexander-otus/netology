package ru.maki;

import java.util.ArrayList;
import java.util.List;

public class TodoList {
    public final List<String> todoList;

    public TodoList() {
        this.todoList = new ArrayList<>();
    }

    public TodoList(List<String> todoList) {
        this.todoList = todoList;
    }

    // добавление нового дела
    public void addCase(String newCase) {
        this.todoList.add(newCase);
        System.out.println("\nДобавлено!");
    }

    // удаления дела по его номеру
    //   если нет дела с таким номером, об этом нужно написать пользователю
    public void deleteCase(int caseIndex) {
        try {
            this.todoList.remove(caseIndex);
            System.out.println("\nУдалено!");
        } catch (IndexOutOfBoundsException e) {
            System.out.printf("Мероприятие с индексом [%d] отсутствует в списке дел.%n", caseIndex);
        }
    }

    // удаления дела по его точному тексту
    //   если нет дела текст которого совпадает с искомым текстом, об этом нужно написать пользователю
    public void deleteCase(String caseName) {
        List<String> deleteList = new ArrayList<>();
        for (String name : todoList) {
            if (name.contains(caseName)) {
                deleteList.add(caseName);
            }
        }

        if (deleteList.isEmpty()) {
            System.out.printf("%nМероприятие [%s] отсутствует в списке дел.%n", caseName);
        } else {
            this.todoList.removeAll(deleteList);
        }
    }

    // удаления по ключевому слову
    //   при такой операции пользователь вводит слово, а из списка удаляются все задачи, которые это слово содержат
    public void deleteByKeyWord(String keyWord) {
        List<String> deleteList = new ArrayList<>();
        for (String caseName : todoList) {
            if (caseName.contains(keyWord)) {
                deleteList.add(caseName);
            }
        }

        if (deleteList.isEmpty()) {
            System.out.printf("%nМероприятие(я), по ключевому слову/фразе [%s] отсутствует(ют) в списке дел.%n", keyWord);
        } else {
            this.todoList.removeAll(deleteList);
        }
    }

    // вывод всех дел с нумерацией
    public void showTodoList() {
        System.out.println("\nВаш список дел :");
        for (int i = 0; i < this.todoList.size(); i++) {
            System.out.printf(" %d. %s%n", i + 1, this.todoList.get(i));
        }
    }

    @Override
    public String toString() {
        return "TodoList{" +
                "todoList=" + todoList +
                '}';
    }
}
