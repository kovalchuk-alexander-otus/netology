import ru.maki.Calculator;

public class Main {
    public static void main(String[] args) {

        Calculator calculator = Calculator.supplier.get();

        int a = calculator.plus.apply(1, 2);
        int b = calculator.minus.apply(1, 1);
        // деление на ноль в математике запрещено
        //  поидее - результатом будет бесконечность
        //  для инта подобное понятие отсутствует - поэтому решил преобразовать в Double
        double c = calculator.divideD.apply((double) a, (double) b);
        calculator.printlnD.accept(c);

        // какого-то элегантного решения для int не нашел
        //  просто возвращаю 0, если в основании деления 0 ... но это как-то не верно
        //  (для инта сделал две реализации - в блоковой, вывожу в консоль сообщение ... но также возвращаю 0)
        int d = calculator.divide.apply(2, 0);
        calculator.println.accept(d);
    }
}