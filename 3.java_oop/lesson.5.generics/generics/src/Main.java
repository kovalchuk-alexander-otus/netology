import ru.maki.Box;

public class Main {
    public static void main(String[] args) {

        Box<String>  testString  = new Box<>("привет");
        Box<Integer> testInteger = new Box<>(1);
        Box<Boolean> testBoolean = new Box<>(true);

    }
}