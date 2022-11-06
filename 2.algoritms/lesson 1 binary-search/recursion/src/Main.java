public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        System.out.println(example(0));
        System.out.println(mult(3,3));
    }

    private static int example(int value){
        System.out.println(value);
        if (value > 10){
            System.out.println("Первый пример");
            return value;
        }
        else return  example(value+1);
    }

    private static int mult(int a, int b){
        if (b == 1) {
            System.out.println("Учим умножение.");
            return a;
        }
        else return a+mult(a, b-1);
    }
}