import java.util.List;
import java.util.Random;
import java.util.concurrent.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {

    static final int POOL_COUNT = Runtime.getRuntime().availableProcessors();


    static int dialog(int threadNum, int countRun) {
        int begin = countRun;
        int count = 0;
        while (countRun-- > 0) {
            if (!Thread.currentThread().isInterrupted()) {
                System.out.printf("any#%d [ %d : %d ]\n", threadNum, countRun, begin);
                count++;
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    return -100;
                } finally {
                    System.out.printf("%s завершен\n", Thread.currentThread().getName());
                    return -200;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        System.out.println(POOL_COUNT);
        Random random = new Random();

        // создаем пул потоков ..по числу процессоров
        final ExecutorService pool = Executors.newFixedThreadPool(POOL_COUNT);

        // готовим коллекцию тасок
        List<Callable<Integer>> tasks = IntStream.range(1, POOL_COUNT).
                mapToObj((v) -> {
                    Callable<Integer> dialogCall = () -> dialog(v, 10); // random.nextInt(10)
                    // FutureTask<Integer> futureTask = new FutureTask<>(dialogCall);
                    return dialogCall;
                }).collect(Collectors.toList());

        // отправляем задачи на выполнение в пул потоков
        pool.invokeAll(tasks);

        // дабы проверить, проходит ли прога дальше - добавил это
        System.out.println("any");

        // ввиду того, что даже после завершения всех процессов прога не останавливается - добавил строчку ниже
        //pool.shutdown();
    }
}