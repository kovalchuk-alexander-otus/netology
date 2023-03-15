import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        List<String> firstClients = List.of("Anya", "Sveta", "Olya", "Alexandra", "Ruslana", "Olesya", "Vika");

        Queue<String> queue = new ArrayDeque<>(firstClients);

        while (!queue.isEmpty()) {
            if (Math.random() < 0.5) { // проверка условия, которое срабатывает с 50% вероятностью
                queue.offer("a friend of " + queue.peek());
            }
            System.out.printf("%s  сделала новый маникюр%n", queue.poll());
        }
    }
}