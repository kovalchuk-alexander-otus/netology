import ru.maki.Matrix;

import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // проинициализируем матрицу размером 8x8 произвольными значениями в диапазоне 0-255
        Matrix matrix = new Matrix();

        // осуществим поворот на 90°/180°/270° по часовой стрелке
        while (true) {
            int degree = 0;
            System.out.print("Выберите угол поворота матрицы 90/180/270 или введите 'end' для выхода:");
            String input = scanner.nextLine();
            if ("end".equals(input)) {
                break;
            }
            try {
                degree = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Вы ввели неверное значение, попробуйте еще раз");
                continue;
            }
            int[][] newMatrix = matrix.rotation(degree);

            // выведем обе матрицы на экран
            matrix.print();
            matrix.print(newMatrix, "Результат вращения на " + degree + "° по часовой стрелке");
        }
    }
}