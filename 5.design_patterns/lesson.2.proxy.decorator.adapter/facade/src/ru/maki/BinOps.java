package ru.maki;

public class BinOps {

    protected final int RADIX = 2; // двоичная система

    /*Сложение двух чисел в 2-м записи*/
    public String sum(String a, String b) {
        return Integer.toBinaryString(Integer.parseInt(a, RADIX) + Integer.parseInt(b, RADIX));
    }

    /*Умножение двух чисел в 2-м записи*/
    public String mult(String a, String b) {
        return Integer.toBinaryString(Integer.parseInt(a, RADIX) * Integer.parseInt(b, RADIX));
    }
}
