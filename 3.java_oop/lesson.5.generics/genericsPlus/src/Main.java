import ru.maki.Box;

public class Main {
    public static void main(String[] args) {

        Box<Integer,String> testList = new Box<>(1,"какое-то важное сообщение");
        Box<String, Boolean> testOtherList = new Box<>("однако", true);

    }
}