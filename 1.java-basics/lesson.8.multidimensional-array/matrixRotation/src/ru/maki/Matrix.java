package ru.maki;

import java.util.Random;

public class Matrix {
    final static int SCALE_IN_DEGREES = 90; // шкала в градусах
    final static int NUMBER_OF_DIVISIONS = 4; // число делений
    final static int MAX_DIVISIONS = 3; // максимальное деление
    final int[][] matrix;
    final int maxRange; // число цифр в максимальном числе в матрице (используем для красивого вывода на экран)

    public Matrix(int[][] matrix) {
        this.matrix = matrix;
        this.maxRange = Matrix.getRange(matrix);
    }

    public Matrix(int rows, int columns, int bound) {
        this.matrix = new int[rows][columns];
        this.maxRange = Matrix.getRange(bound);
        Random random = new Random();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                this.matrix[i][j] = random.nextInt(bound);
            }
        }
    }

    // подсчет максимального числа знаков до запятой
    //   для корректного вывода результата на экран
    public static int getRange(int maxValue) {
        int result = 1;
        if (maxValue == 0) {
            return 0;
        }
        result = result + getRange(maxValue / 10);
        return result;
    }

    // перегрузка метода подсчета максимального числа знаков до запятой
    //   на случай, когда сначала надо найти самое число в матрице
    public static int getRange(int[][] matrix) {
        int maxValue = 0;

        for (int[] ints : matrix) {
            for (int anInt : ints) {
                maxValue = Math.max(maxValue, anInt);
            }
        }

        return Matrix.getRange(maxValue);
    }

    // вращение матрицы на заданный угол поворота
    //   0° / 90° / 180° / 270° / 360° - и т.д. с шагом в 90°
    public int[][] rotate(int rotationDegree) {

        int howManyTimes = rotationDegree / Matrix.SCALE_IN_DEGREES;
        if (howManyTimes > Matrix.MAX_DIVISIONS) {
            howManyTimes %= Matrix.NUMBER_OF_DIVISIONS;
        }

        int[][] result = this.matrix;
        int row;
        int column;

        while (howManyTimes > 0) {
            howManyTimes--;

            int[][] oldMatrix = result;
            int oldRow = oldMatrix.length;
            int oldColumn = oldMatrix[0].length; // возможно не сильно универсальное решение

            result = new int[oldColumn][oldRow];
            for (int i = 0; i < oldRow; i++) {
                for (int j = 0; j < oldColumn; j++) {
                    row = j;
                    column = oldRow - i - 1;
                    result[row][column] = oldMatrix[i][j];
                }
            }
        }

        return result;
    }

    // вывод матрицы на экран
    //   матрицу берем из входных параметров
    public void showMatrix(int[][] matrix) {
        for (int[] row : matrix
        ) {
            for (int j : row) {
                System.out.printf("%" + (this.maxRange + 1) + "d", j);
            }
            System.out.println();
        }
    }

    // вывод матрицы на экран
    //   перегрузка метода - выводим матрицу нашего экземпляра
    public void showMatrix() {
        this.showMatrix(this.matrix);
    }
}
