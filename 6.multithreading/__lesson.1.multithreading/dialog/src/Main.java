import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    private static void dialog(int thread) {
        while (true) {
            System.out.printf("Я поток %s. Всем привет! [%s]%n ", thread, Thread.currentThread().getName());
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                return;
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Создаю потоки...");

        List<Thread> threads = IntStream.range(1, 5).
                mapToObj((v) -> {
                    Runnable dialog = () -> dialog(v);
                    Thread thread = new Thread(dialog);
                    thread.setName("поток " + v);
                    thread.start();
                    return thread;
                }).collect(Collectors.toList());

        Thread.sleep(15000);
        System.out.println("Завершаю все потоки.");
        for (Thread thread : threads) {
            thread.interrupt();
        }

    }
}