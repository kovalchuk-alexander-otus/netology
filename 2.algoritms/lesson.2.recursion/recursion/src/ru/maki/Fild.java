package ru.maki;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.Collectors;

public class Fild {
    private final char CELL_FREE = '-';
    private final char CELL_DOG = 'Щ';
    private final char CELL_MEN = 'Ч';
    private final char CELL_CACTUS = '*';
    private final char CELL_WAY = 'x';
    private final int ROW = 0;
    private final int COLUMN = 1;
    private int countCactus = 0;
    private char[][] fild;
    private int size = 0;
    private int[] coordinates;
    private boolean[][] ways; // думал хранить все решения для последующего разбора
    private boolean isDone = false;
    private int[] bestSolution = new int[1];
    private Random random = new Random();

    public Fild(int size) {
        this.size = size;
        this.fild = new char[size][size];
        for (int i = 0; i < fild.length; i++) {
            for (int j = 0; j < fild[i].length; j++) {
                this.fild[i][j] = CELL_FREE;
            }
        }

        this.countCactus = size;

        // соберем список всех клеток - на старте, они все свободные и доступны для хода
        this.coordinates = new int[(int) Math.pow(this.fild.length, 2)];
        for (int i = 0; i < this.coordinates.length; i++) {
            this.coordinates[i] = i;
        }
    }

    public Fild(char[][] fild) {
        this.fild = fild;
        this.size = fild.length;
    }

    public char[][] getFild() {
        return fild;
    }

    // печать поля
    public void printFild() {
        for (char[] chars : fild) {
            for (char aChar : chars) {
                System.out.print(aChar + " ");
            }
            System.out.println();
        }
    }

    // размещение пёселя на поле
    private void setDog() {
        this.fild[0][0] = CELL_DOG; // размещение пёселя на поле
        this.coordinates = adjustListOfCoordinates(this.coordinates, 0); // учтем клетку, занимаемую пёселем
    }

    // размещение кактусов на поле (random)
    private void setCactus(int count) {

        // на случай, если захотим озеленить планету
        this.countCactus = count;

        // расставим кактусы на поле согласно штатному расписанию
        int numberOfVariation = this.coordinates.length;
        for (int i = 0; i < this.countCactus; i++) {
            int cInt = random.nextInt(numberOfVariation - i);
            // System.out.println(cInt);
            int[] coordinate = convertIntToCoordinate(this.coordinates[cInt]);
            this.fild[coordinate[ROW]][coordinate[COLUMN]] = CELL_CACTUS;
            this.coordinates = adjustListOfCoordinates(this.coordinates, cInt);
            // System.out.println(Arrays.toString(coordinates));
        }
    }

    // размещение кактусов на поле (random)
    // (рекурсия)
    private void setCactusR(int count) {
        this.countCactus = count;

        int numberOfVariation = this.coordinates.length;
        int cInt = random.nextInt(numberOfVariation - 1);
        // System.out.println(cInt);
        int[] coordinate = convertIntToCoordinate(this.coordinates[cInt]);
        this.fild[coordinate[ROW]][coordinate[COLUMN]] = CELL_CACTUS;
        this.coordinates = adjustListOfCoordinates(this.coordinates, cInt);

        if (count > 1) setCactusR(count - 1);
    }

    private void setCactus() {
        setCactus(countCactus);
    }

    // размещение Человека на поле (random)
    private void setMen() {
        int cInt = random.nextInt(this.coordinates.length - 1);
        int[] coordinate = convertIntToCoordinate(this.coordinates[cInt]);
        setMen(coordinate[ROW], coordinate[COLUMN]);
        this.coordinates = adjustListOfCoordinates(this.coordinates, cInt);
    }

    // размещение Человека на поле (предзаданные координаты)
    public void setMen(int row, int column) {
        this.fild[row][column] = CELL_MEN;
    }

    // основная логика игры - исключает начальную фазу, где рандомазим поле или получаем его в виде предзаданного
    public void game() {
        printFild(); // печать поля (в начале игры)

        // подготовим чек-лист
        this.ways = new boolean[this.size][this.size];
        for (int i = 0; i < this.size; i++) {
            for (int j = 0; j < this.size; j++) {
                this.ways[i][j] = false;
            }
        }

        // выполним поиск маршрута
        findAWay(new int[]{0, 0}, new int[]{0});

        if (!this.isDone) System.out.println("Увы и ах!");
        else {
            // зафиксируем первый маршрут на карте
            System.out.println(Arrays.toString(this.bestSolution));
            for (int w : this.bestSolution) {
                int[] step = convertIntToCoordinate(w);
                if (this.fild[step[ROW]][step[COLUMN]] == CELL_FREE) this.fild[step[ROW]][step[COLUMN]] = CELL_WAY;
            }
            System.out.println("\n\nМаршрут найден");
            // распечатаем карту
            printFild();
        }
    }

    // игра - для случая, где рандомайзим поле
    public void game(int cactusCount) {
        makeFild(cactusCount);
        setMen(); // размещение человека
        game();
    }

    public void makeFild(int cactusCount) {
        setDog(); // размещение пёселя
        // setCactus(cactusCount); // размещение кактусов
        setCactusR(cactusCount); // размещение кактусов (рекурсия)
    }

    // преобразование числа в координату ячейки в массиве
    private int[] convertIntToCoordinate(int cInt) {
        int row = (int) (cInt / this.fild.length);
        int column = cInt % this.fild.length;
        // System.out.println(row + ":" + column);
        return new int[]{row, column};
    }

    // преобразование координаты в число
    private int convertCoordinateToInt(int[] coordinate) {
        return coordinate[ROW] * this.size + coordinate[COLUMN];
    }

    // учтем выбор клетки на нашем игровом поле
    // чтобы не было возможности выбрать ее впредь
    private int[] adjustListOfCoordinates(int[] coordinates, int move) {
        int[] newCoordinates = new int[coordinates.length - 1];
        int i = 0;
        for (int j = 0; j < coordinates.length; j++) {
            if (j == move) continue;
            newCoordinates[i++] = coordinates[j];
        }
        return newCoordinates;
    }

    // протопчем тропинку от пёселя к Человеку
    public boolean findAWay(int[] coordinate, int[] way) {
        // System.out.println(coordinate[ROW] + ":" + coordinate[COLUMN]);

        // проверим ... а не уперлись ли мы в кактус или теплые ноги хозяина
        if (this.fild[coordinate[ROW]][coordinate[COLUMN]] == CELL_CACTUS) return false;
        if (this.fild[coordinate[ROW]][coordinate[COLUMN]] == CELL_MEN) {
            //System.out.println("Решение" + Arrays.toString(way)); // ежели хотим посмотреть варианты маршрутов

            if ((this.bestSolution.length > 1 && this.bestSolution.length > way.length) || this.bestSolution.length == 1)
                this.bestSolution = way;
            this.isDone = true; // установим флаг, что маршрут найден
            return true;
        }

        // проверим, а не становились ли мы ранее на это поле - в одну реку дважды ни-ни
        // ...не шибко нравится мне это условие, но ничего лучше не придумал
        int lastElement = way[way.length - 1];
        for (int i = 0; i < way.length - 1; i++) {
            if (lastElement == way[i]) return false;
        }

        // начинаем формировать новую версию маршрута, которая будет учитывать текущий шаг
        int[] newWay = new int[way.length + 1];
        for (int i = 0; i < way.length; i++) {
            newWay[i] = way[i];
        }

        // направо пойдешь - кафтан потеряешь..
        if (coordinate[ROW] < this.size - 1) {
            newWay[way.length] = convertCoordinateToInt(new int[]{coordinate[ROW] + 1, coordinate[COLUMN]});
            findAWay(new int[]{coordinate[ROW] + 1, coordinate[COLUMN]}, newWay);
        }
        if (coordinate[ROW] > 0) {
            newWay[way.length] = convertCoordinateToInt(new int[]{coordinate[ROW] - 1, coordinate[COLUMN]});
            findAWay(new int[]{coordinate[ROW] - 1, coordinate[COLUMN]}, newWay);
        }
        if (coordinate[COLUMN] < this.size - 1) {
            newWay[way.length] = convertCoordinateToInt(new int[]{coordinate[ROW], coordinate[COLUMN] + 1});
            findAWay(new int[]{coordinate[ROW], coordinate[COLUMN] + 1}, newWay);
        }
        if (coordinate[COLUMN] > 0) {
            newWay[way.length] = convertCoordinateToInt(new int[]{coordinate[ROW], coordinate[COLUMN] - 1});
            findAWay(new int[]{coordinate[ROW], coordinate[COLUMN] - 1}, newWay);
        }

        return true;
    }

}
