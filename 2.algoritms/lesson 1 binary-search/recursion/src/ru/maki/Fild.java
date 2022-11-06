package ru.maki;

import java.util.Arrays;
import java.util.Random;

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
    private int[][] ways; // думал хранить все решения для последующего разбора
    private boolean isDone = false;
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

    public char[][] getFild() {
        return fild;
    }

    // печать поля
    private void printFild() {
        for (char[] chars : fild) {
            for (char aChar : chars) {
                System.out.print(Character.toString(aChar) + " ");
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
        this.fild[coordinate[ROW]][coordinate[COLUMN]] = CELL_MEN;
        this.coordinates = adjustListOfCoordinates(this.coordinates, cInt);
    }

    public void init(int cactusCount) {
        setDog(); // размещение пёселя
        // setCactus(cactusCount); // размещение кактусов
        setCactusR(cactusCount); // размещение кактусов (рекурсия)
        setMen(); // размещение человека
        printFild(); // печать поля

        if (findAWay(new int[]{0, 0}, new int[]{0})) printFild();
    }

    // преобразование числа в координату ячейки в массиве
    private int[] convertIntToCoordinate(int cInt) {
        int row = (int) (cInt / this.fild.length);
        int column = cInt % this.fild.length;
        // System.out.println(row + ":" + column);
        return new int[]{row, column};
    }

    // преобразование координаты в число
    private int convertCoordinateToInt(int[] coordinate){
        return coordinate[ROW]*this.size+coordinate[COLUMN];
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

    // TODO: протопчем тропинку от пёселя к Человеку
    //
    public boolean findAWay(int[] coordinate, int[] way) {
        // System.out.println(coordinate[ROW] + ":" + coordinate[COLUMN]);
        /*switch(this.fild[coordinate[ROW]][ coordinate[COLUMN]]){
            case CELL_WAY :
            case CELL_CACTUS:
            case CELL_DOG: return true;
            case CELL_MEN: return false;
        }*/

        // в идеале требуется делать смещение на все четыре стороны ... иначе можно проглядеть вариант
        if (this.fild[coordinate[ROW]][coordinate[COLUMN]] == CELL_CACTUS) return false;
        if (this.fild[coordinate[ROW]][coordinate[COLUMN]] == CELL_MEN) {
            System.out.println("Решение" + Arrays.toString(way));
            if (!this.isDone){
                this.isDone = true; // установим флаг, что маршрут найден
                // зафиксируем первый маршрут на карте
                for (int w : way) {
                    int[] step = convertIntToCoordinate(w);
                    if (this.fild[step[ROW]][step[COLUMN]] == CELL_FREE) this.fild[step[ROW]][step[COLUMN]] = CELL_WAY;
                }
            }
            return true;
        }

        if (this.fild[coordinate[ROW]][coordinate[COLUMN]] == CELL_FREE) {
            // this.fild[coordinate[ROW]][coordinate[COLUMN]] = CELL_WAY;
        }

        int[] newWay = new int[way.length+1];
        for (int i = 0; i < way.length; i++) {
            newWay[i] = way[i];
        }

        if (coordinate[ROW] < this.size - 1) {
            newWay[way.length] = convertCoordinateToInt(new int[]{coordinate[ROW] + 1, coordinate[COLUMN]});
            findAWay(new int[]{coordinate[ROW] + 1, coordinate[COLUMN]}, newWay);
        }
        if (coordinate[COLUMN] < this.size - 1){
            newWay[way.length] = convertCoordinateToInt(new int[]{coordinate[ROW], coordinate[COLUMN]+1});
            findAWay(new int[]{coordinate[ROW], coordinate[COLUMN] + 1}, newWay);
        }

        return true;
    }

}
