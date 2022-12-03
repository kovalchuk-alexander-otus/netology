package ru.maki;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class TicTacToe {
    private static final int SIZE = 3;
    private final char EMPTY = '-';
    private final char CROSS = 'X';
    private final char ZERO = 'O';
    private boolean needShowMove = false;
    private final String COMPUTER = "computer";
    private final String MEN = "men";
    private final String MONKEY = "monkey";
    private final String GENIUS = "genius";

    private Scanner scanner = new Scanner(System.in);

    private char[][] field; // игровое поле
    int[] listOfMoves; // список ходов

    public TicTacToe(int size, boolean needShowMove) {
        this.field = new char[size][size];
        this.needShowMove = needShowMove;
    }

    public TicTacToe(boolean needShowMove) {
        this(TicTacToe.SIZE, needShowMove);
    }

    private void emptyField() {
        for (int i = 0; i < this.field.length; i++) {
            for (int j = 0; j < this.field[i].length; j++) {
                this.field[i][j] = EMPTY;
            }
        }
    }

    // запуск игры
    public void game() throws InterruptedException {

        // int size = setIntParams("Выберите размерность поля 3/4/5 и т.п.: \n > ");
        String mode = setStringParams("Выберите режим игры computer/men: \n > ", new String[]{COMPUTER, MEN});

        if (mode.equals(COMPUTER)) {
            String level = setStringParams("Выберите сложность игры monkey/genius: \n > ", new String[]{MONKEY, GENIUS});
            int countOfParties = setIntParams("Введите число партий от 1 до 5: \n > ");
            gameComputer(level, countOfParties);
        } else
            gameMen();

    }

    // шаблонный метод для диалога с вводом целых чисел
    private int setIntParams(String prompt) {
        String input = "";
        while (true) {
            System.out.print(prompt);
            input = scanner.nextLine();
            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Вы ввели некорректное число, попробуйте еще раз");
                continue;
            }
        }
    }

    // шаблонный метод для диалога с вводом текстовых значений
    private String setStringParams(String prompt, String[] options) {
        String input = "";
        while (true) {
            System.out.println(prompt);
            input = scanner.nextLine();
            if (!Arrays.stream(options).anyMatch(input::equals)) {
                System.out.println("Вы ввели некорректное значение, попробуйте еще раз");
                continue;
            }
            return input;
        }
    }

    // перегрузка для demo
    public void gameComputer(int countOfParties) throws InterruptedException {
        gameComputer(MONKEY, countOfParties);
    }

    // режим игры Искусственный интеллект
    private void gameComputer(String level, int countOfParties) throws InterruptedException {
        if (level.equals(GENIUS))
            System.out.printf("Режим %s находится в процессе разработки - пока доступен только режим %s\n\n",
                    GENIUS, MONKEY);
        for (int i = 0; i < countOfParties; i++) {
            boolean weHaveAWin = false;
            listOfMoves = getListOfMoves(); // сформируем массив ходов
            boolean isCrossTurn = true;
            emptyField();
            // запустим счетчик ходов
            while (listOfMoves.length > 0) {
                if (needShowMove){
                    printField();
                    Thread.sleep(500);
                }
                int nextMove = getNextMove(); // выбора очередного хода и уменьшение списка ходов
                int coordinate[] = getCoordinate(nextMove); // перевод значения хода в координату
                int r = coordinate[0];
                int c = coordinate[1];

                field[r][c] = isCrossTurn ? CROSS : ZERO;
                if (isWin(isCrossTurn ? CROSS : ZERO)) {
                    printField();
                    System.out.println("Победили " + (isCrossTurn ? "крестики" : "нолики"));
                    System.out.println();
                    weHaveAWin = true;
                    break;
                } else {
                    isCrossTurn = !isCrossTurn;
                }
            }
            if (!weHaveAWin) {
                printField();
                System.out.println("Ничья");
                System.out.println();
            }
        }
    }

    // выбор очередного хода и уменьшение списка ходов
    private int getNextMove() {
        Random random = new Random();
        int next = listOfMoves.length > 1 ? random.nextInt(listOfMoves.length - 1) : 0;
        int nextMove = listOfMoves[next];
        int j = 0;
        int[] newListOfMoves = new int[listOfMoves.length - 1];
        for (int i = 0; i < listOfMoves.length; i++) {
            if (i == next) continue;
            newListOfMoves[j++] = listOfMoves[i];
        }
        listOfMoves = newListOfMoves;
        return nextMove;
    }

    // перевод значения хода в координату
    private int[] getCoordinate(int nextMove) {
        int row = (int) (nextMove / field.length);
        int column = nextMove % field.length;
        return new int[]{row, column};
    }

    // TODO: метод перевода координаты в число

    // инициализация списка координат
    private int[] getListOfMoves() {
        int[] listOfMoves = new int[(int) Math.pow(this.field.length, 2)];
        for (int j = 0; j < listOfMoves.length; j++) {
            listOfMoves[j] = j;
        }
        // System.out.println(Arrays.toString(listOfMoves));
        return listOfMoves;
    }

    // режим игры Человек
    private void gameMen() {

        boolean isCrossTurn = true;
        emptyField();
        while (true) {
            printField();
            System.out.println("Ходят " + (isCrossTurn ? "крестики" : "нолики") + "!");
            String input = scanner.nextLine(); // "2 3"
            String[] parts = input.split(" "); // ["2" , "3"]
            int r = Integer.parseInt(parts[0]) - 1; // 2-1 = 1
            int c = Integer.parseInt(parts[1]) - 1; // 3-1 = 2

            if (field[r][c] != EMPTY) {
                System.out.println("Сюда ходить нельзя");
                continue;
            }

            field[r][c] = isCrossTurn ? CROSS : ZERO;
            if (isWin(isCrossTurn ? CROSS : ZERO)) {
                printField();
                System.out.println("Победили " + (isCrossTurn ? "крестики" : "нолики"));
                break;
            } else {
                isCrossTurn = !isCrossTurn;
            }
        }
    }

    // вывод игрового поля на экран
    public void printField() {
        for (char[] row : this.field) {
            for (char cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
    }

    // проверка наличия Победителя
    public boolean isWin(char player) {

        boolean isMainDiagonal = true;
        boolean isDiagonal = true;

        for (int i = 0; i < field.length; i++) {
            boolean isHorizontal = true;
            boolean isVertical = true;
            for (int j = 0; j < field[i].length; j++) {
                if (isHorizontal && field[i][j] != player) {
                    isHorizontal = false;
                }
                if (isVertical && field[j][i] != player) {
                    isVertical = false;
                }
            }

            if (isHorizontal || isVertical) {
                return true;
            }

            if (isMainDiagonal && field[i][i] != player) {
                isMainDiagonal = false;
            }

            if (isDiagonal && field[field.length - 1 - i][i] != player) {
                isDiagonal = false;
            }
        }

        if (isMainDiagonal || isDiagonal) {
            return true;
        }

        return false;
    }
}