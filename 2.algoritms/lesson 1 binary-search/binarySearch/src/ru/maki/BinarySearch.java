package ru.maki;

import java.util.Arrays;
import java.util.Random;

public class BinarySearch {
    private boolean debug = false;
    private boolean showOnlyError = false;
    private Random random = new Random();

    public void setShowOnlyError(boolean showOnlyError) {
        this.showOnlyError = showOnlyError;
    }

    // находим индекс первой большой книги
    // используем алгоритм - Бинарный поиск
    // алгоритмическая сложность: время - O(log2n), память - O(1)
    private int binarySearch(int[] arr, int value) {
        int left = 0;
        int right = arr.length - 1;
        int big = right; // изначально считаем, что самая большая книга скраю полки
        int medium = 0;

        if (arr[right] <= value)
            return -1; // проверка крайнего случая, когда "новая книга по объему больше тех, что стоят на полке"
        while (left < right) {
            medium = (int) ((right + left) / 2);
            // print(new int[]{arr[medium], value, left, right, medium, big});
            if (arr[medium] > value) {
                // попадаем сюда в случае, если центр поиска больше .. т.е. можно отбросить все, что правее
                right = medium == 0 ? 0 : medium - 1;
                big = medium; // а заодно запомним индекс новой "большой" книги
            } else if (arr[medium] <= value) {
                // попадаем сюда, если центр поиска меньше, либо равен .. т.е. можно отбросить все, что левее
                // в этом случае, правда, появляется риск, что новая координата [left] может оказаться искомой и в проверку внутри цикла не попадет
                // именно поэтому производим проверку этого крайнего случая в return
                left = medium + 1;
            }
        }
        // print(new int[]{left, right});
        return arr[right] > value ? right : big;
    }

    // находим индекс первой большой книги
    // используем алгоритм - Линейный поиск
    // алгоритмическая сложность: время - O(n), память - O(1)
    private int linearSearch(int[] arr, int value) {
        int result = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > value) {
                result = i;
                break;
            }
        }
        return result;
    }

    // демонстрация
    public void demo(int bookCounts) {
        this.debug = false;
        int[] bookShelve = makeBookShelve(bookCounts);
        int newBookSheet = takeABook(bookShelve);
        int bigBook = binarySearch(bookShelve, newBookSheet);
        check(bookShelve, newBookSheet, bigBook); // проверим наш оптимизированный поиск
    }

    // отладчик
    public void debug(int[] bookShelve, int newBookSheet) {
        this.debug = true;
        int bigBook = binarySearch(bookShelve, newBookSheet);
        // System.out.printf("Индекс первой большой книги: %s\n", bigBook);
        check(bookShelve, newBookSheet, bigBook); // проверим наш оптимизированный поиск
    }

    // логирование информации (зависит от включения флага DEBUG)
    private void print(int[] log) {
        if (this.debug) System.out.printf("%s\n", Arrays.toString(log));
    }

    // отладка - метод рандомного указания количества страниц в книге
    private int takeABook(int[] bookShelve) {
        return this.random.nextInt(bookShelve[bookShelve.length - 1] + 50);
    }

    // отладка - метод рандомного формирования книжной полки
    private int[] makeBookShelve(int bookCounts) {
        int[] result = new int[bookCounts];
        int sheetCount = 10;

        for (int i = 0; i < result.length; i++) {
            sheetCount += this.random.nextInt(25);
            result[i] = sheetCount;
        }

        return result;
    }

    // метод используем для проверки
    // сравниваем результаты работы алгоритмов Линейного поиска (эталон) и Бинарного поиска (разрабатываемый)
    private void check(int[] books, int book, int bigBookCounts) {
        int bigBook = linearSearch(books, book);

        System.out.printf("%-30s %-20s %-80s %20s \n",
                "Число толстых книг: " + (bigBook == -1 ? 0 : books.length - bigBook),
                "Книга: " + book,
                "Полка: " + Arrays.toString(books),
                "Индекс большой: " + bigBook);
        if (!this.showOnlyError || bigBook != bigBookCounts) {
            System.out.printf("Книжная полка: %s\n", Arrays.toString(books));
            System.out.printf("Размер новой книги: %d\n", book);
            System.out.printf("Индекс первой большой книги: %d\n", bigBookCounts);
            System.out.printf((bigBook != bigBookCounts ? "\n!!!Ошибка\nВерный индекс первой большой книги: %d\n\n" : "%d\n\n"), bigBook);
        }
    }
}
