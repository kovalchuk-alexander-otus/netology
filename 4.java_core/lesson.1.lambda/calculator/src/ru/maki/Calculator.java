package ru.maki;

import java.util.function.*;

public class Calculator {

    public static final Supplier<Calculator> supplier = Calculator::new;

    public final BinaryOperator<Integer> plus = Integer::sum; // сложение
    public final BinaryOperator<Integer> minus = (a, b) -> a - b; // вычитание
    public final BinaryOperator<Integer> multiple = (a, b) -> a * b; // умножение

    // решение #1
    //  юзаем  Double
    public final BinaryOperator<Double> divideD = (a, b) -> a / b;

    // решение #2
    //  работаем с int и тернарным - возвращаем 0
    public final BinaryOperator<Integer> divideI = (a, b) -> b == 0 ? 0 : a / b;

    // решение #3
    //  работаем с блоковым
    public final BinaryOperator<Integer> divide = (a, b) ->
    {
        if (b == 0) {
            System.out.println("Деление на 0 запрещено");
            return 0;
        } else {
            return a / b;
        }
    };

    public final UnaryOperator<Integer> pow = (a) -> a * a;
    public final UnaryOperator<Integer> abs = (a) -> a > 0 ? a : -a;

    public final Predicate<Integer> isPositive = (a) -> a > 0;

    public final Consumer<Double> printlnD = System.out::println;
    public final Consumer<Integer> println = System.out::println;
}
