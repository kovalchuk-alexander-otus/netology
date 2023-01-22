import ru.maki.Check;
import ru.maki.Stack.SinglyStack;

public class Main {
    public static void main(String[] args) {
        SinglyStack<Integer> singlyStack = new SinglyStack<>();
        singlyStack.printMe();
        singlyStack.push(0);
        singlyStack.push(1);
        singlyStack.push(2);
        singlyStack.push(3);
        singlyStack.push(4);
        singlyStack.push(5);
        singlyStack.pop();
        singlyStack.pop();
        singlyStack = singlyStack.reverse();
        singlyStack.pop();
        singlyStack.pop();
        singlyStack = singlyStack.reverse();
        singlyStack.pop();
        singlyStack.pop();

        // автоматизированная проверка ...
        // check();
        // Check.viewResult();
    }

    public static void check() {
        Check.checkResult("EMPTY\n" +
                "Добавим 0\n" +
                "0\n" +
                "Добавим 1\n" +
                "1 -> 0\n" +
                "Добавим 2\n" +
                "2 -> 1 -> 0\n" +
                "Добавим 3\n" +
                "3 -> 2 -> 1 -> 0\n" +
                "Добавим 4\n" +
                "4 -> 3 -> 2 -> 1 -> 0\n" +
                "Добавим 5\n" +
                "5 -> 4 -> 3 -> 2 -> 1 -> 0\n" +
                "Снимем со стека\n" +
                "5\n" +
                "4 -> 3 -> 2 -> 1 -> 0\n" +
                "Снимем со стека\n" +
                "4\n" +
                "3 -> 2 -> 1 -> 0\n" +
                "Ревёрс!\n" +
                "0 -> 1 -> 2 -> 3\n" +
                "Снимем со стека\n" +
                "0\n" +
                "1 -> 2 -> 3\n" +
                "Снимем со стека\n" +
                "1\n" +
                "2 -> 3\n" +
                "Ревёрс!\n" +
                "3 -> 2\n" +
                "Снимем со стека\n" +
                "3\n" +
                "2\n" +
                "Снимем со стека\n" +
                "2\n" +
                "EMPTY\n");
    }
}