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
            } else {
                System.out.println("tut");
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
                    Callable<Integer> dialogCall = new Callable<Integer>() {
                        @Override
                        public Integer call() throws Exception {
                            dialog(v, 10);
                            return random.nextInt();
                        }
                    };
                    // () -> {dialog(v, 10); return 10;}; // random.nextInt(10)
                    // FutureTask<Integer> futureTask = new FutureTask<>(dialogCall);
                    return dialogCall;
                }).collect(Collectors.toList());

        // отправляем задачи на выполнение в пул потоков
        pool.invokeAny(tasks);

        // ..поглядим, какие из потоков активные
        System.out.println(pool);
        Thread.sleep(5000);
        System.out.println(pool);
        pool.shutdownNow();
        System.out.println(pool);
        Thread.sleep(5000);
        System.out.println(pool);

    }
}