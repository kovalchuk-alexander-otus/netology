public class Examples {
    // пример рекурсии #1
    // System.out.println(example(0));
    public static int example(int value) {
        System.out.println(value);
        if (value > 10) {
            System.out.println("Первый пример");
            return value;
        } else return example(value + 1);
    }

    // пример рекурсии #2
    // System.out.println(mult(3,3));
    public static int mult(int a, int b) {
        if (b == 1) {
            System.out.println("Учим умножение.");
            return a;
        } else return a + mult(a, b - 1);
    }
}
