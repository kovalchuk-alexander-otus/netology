import ru.maki.BinOps;

public class Main {
    public static void main(String[] args) {
        //демонстрация
        BinOps bins = new BinOps();
        System.out.println(bins.sum("0010", "0100"));
        System.out.println(bins.mult("101", "010"));
    }
}