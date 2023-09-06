package ru.maki;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Filter {

    public static final String SPACEBAR = " ";
    private List<Integer> integerList = new ArrayList<>();
    private Logger logger;
    private Random random = new Random();

    public Filter(int elementCount, int maxValue) {
        logger = Logger.getInstance();
        logger.log("Создаём и наполняем список");
        for (int i = 0; i < elementCount; i++) {
            this.integerList.add(random.nextInt(maxValue));
        }
        messageWithList("Вот случайный список:", integerList);
    }

    /**
     * метод фильтрует список и оставляет в нем значения больше порогового, которое подается на вход
     *
     * @param filter
     * @return
     */
    public List<Integer> filterOut(int filter) {
        List<Integer> list = new ArrayList<>();
        int count = 0;
        logger.log("Запускаем фильтрацию");

        for (Integer i : integerList) {
            if (i > filter) {
                list.add(i);
                count++;
                logger.log("Элемент " + i + " проходит");
            } else {
                logger.log("Элемент " + i + " не проходит");
            }
        }
        logger.log("Прошло фильтр " + count + " элемента из " + (integerList.size() - count));
        return list;
    }

    /**
     * вывод в терминал значений списка с пользовательским сообщением
     *
     */
    public static void messageWithList(String message, List<Integer> list) {
        StringBuilder log = new StringBuilder(message);
        for (Integer i : list) {
            log.append(SPACEBAR);
            log.append(i);
        }

        System.out.println(log.toString());
    }


    // Программа здоровается с пользователем, просит ввести два числа: размер списка N и верхнюю границу значений элементов в списке M.
    //Программа создаёт список ArrayList из N элементов и заполняет их случайными числами от 0 до M.
    //Программа просит пользователя ввести число f для фильтрации списка.
    //Программа создаёт объект filter вашего класса Filter, передав в конструктор значение f
    //Программа вызывает у filter метод List<Integer> filterOut(List<Integer> list), передавая созданный случайный список в качестве параметра и принимая в качестве ответа список, который идентичен исходному, если пропустить элементы меньше f
    //Программа выводит итоговый список на экран и завершает свою работу

    //    [31.12.2019 15:38:22 2] Просим пользователя ввести входные данные для списка
//    Введите размер списка: 7
//    Введите верхнюю границу для значений: 10
//    [31.12.2019 15:38:23 3] Создаём и наполняем список
//    Вот случайный список: 3 5 5 1 0 3 6
//    [31.12.2019 15:38:23 4] Просим пользователя ввести входные данные для фильтрации
//    Введите порог для фильтра: 4
//    [31.12.2019 15:38:23 5] Запускаем фильтрацию
//    [31.12.2019 15:38:23 6] Элемент "3" не проходит
//    [31.12.2019 15:38:23 7] Элемент "5" проходит
//    [31.12.2019 15:38:23 8] Элемент "5" проходит
//    [31.12.2019 15:38:23 9] Элемент "1" не проходит
//    [31.12.2019 15:38:23 10] Элемент "0" не проходит
//    [31.12.2019 15:38:24 11] Элемент "3" не проходит
//    [31.12.2019 15:38:24 12] Элемент "6" проходит
//    [31.12.2019 15:38:24 13] Прошло фильтр 3 элемента из 7
//    [31.12.2019 15:38:24 14] Выводим результат на экран
//    Отфильтрованный список: 5 5 6
//    [31.12.2019 15:38:24 15] Завершаем программу
}
