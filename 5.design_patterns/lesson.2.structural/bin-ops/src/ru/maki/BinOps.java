package ru.maki;

public class BinOps {

    /**
     * сложение двух бинарных чисел
     *
     * @param a
     * @param b
     * @return
     */
    public String sum(String a, String b) {
        int res = Integer.parseInt(a, 2) + Integer.parseInt(b, 2);
        return (String) Integer.toBinaryString(res);
    }

    /**
     * умножение двух бинарных чисел
     *
     * @param a
     * @param b
     * @return
     */
    public String mult(String a, String b) {
        int res = Integer.parseInt(a, 2) * Integer.parseInt(b, 2);
        return (String) Integer.toBinaryString(res);
    }
}
