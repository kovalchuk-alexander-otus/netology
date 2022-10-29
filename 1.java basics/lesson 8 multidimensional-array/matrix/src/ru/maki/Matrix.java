package ru.maki;

import java.util.Random;

public class Matrix {
    private static final int SCALE = 8;
    int[][] matrix;

    // перегрузка метода заполнения матрицы значениями - вызов без параметров
    public Matrix() {
        this(SCALE);
    }

    // создание матрицы заданного размера
    // и заполнение матрицы произвольными значениями
    public Matrix(int scale) {
        Random random = new Random();
        this.matrix = new int[scale][scale];
        for (int i = 0; i < scale; i++) {
            for (int j = 0; j < scale; j++) {
                // this.matrix[i][j] = random.nextInt(256);
                this.matrix[i][j] = (int) Math.round(256 * Math.random());
            }
        }
    }

    // перегрузка печати матрицы на экране для родной матрицы
    public void print() {
        print(this.matrix, "Исходная матрица");
    }

    // печать матрицы на экране
    public void print(int[][] matrix, String prompt) {
        System.out.println(prompt);
        for (int[] ints : matrix) {
            for (int anInt : ints) {
                System.out.printf("%4d", anInt);
            }
            System.out.println();
        }
        System.out.println();
    }

    // создадим новую матрицу путем вращения нашей матрицы на 90° по часовой стрелке
    public int[][] rotation(int degree) {
        int scale = this.matrix.length;
        int[][] newMatrix = new int[scale][scale];

        for (int i = 0; i < scale; i++) {
            int ii = scale - i - 1;
            for (int j = 0; j < scale; j++) {
                switch (degree){
                    case 90 : newMatrix[j][ii] = this.matrix[i][j]; // поворот на 90° по часовой стрелке
                        break;
                    case 180 : newMatrix[i][j] = this.matrix[ii][scale-j-1]; // поворот на 180° по часовой стрелке
                        break;
                    case 270 : newMatrix[i][j] = this.matrix[j][ii]; // поворот на 90° против часовой стрелке
                }
            }
        }

        return newMatrix;
    }
}
