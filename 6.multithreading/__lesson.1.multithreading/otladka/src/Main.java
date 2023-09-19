import ru.maki.MyThread;

import java.util.Random;
import java.util.concurrent.*;

public class Main {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        // run();

        call();
    }

    static void call() throws ExecutionException, InterruptedException {
        Random random = new Random();
        Callable<Integer> rnd = new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                Thread.sleep(10000);
                return random.nextInt(100);
            }
        };

        FutureTask<Integer> future = new FutureTask<Integer>(rnd);

        new Thread(future).start();

        System.out.println(future.get());
    }

    static void run() throws InterruptedException {
        // запуск отдельного потока
        ThreadGroup mainGroup = new ThreadGroup("main");
        ThreadGroup secondGroup = new ThreadGroup("second");

        MyThread thread = new MyThread(1000);
        var t = thread.start(mainGroup);
        MyThread thread2 = new MyThread(2000);
        var t2 = thread2.start(mainGroup);

        MyThread thread11 = new MyThread(1000);
        var t11 = thread.start(secondGroup);
        MyThread thread12 = new MyThread(2000);
        var t12 = thread2.start(secondGroup);

        // остановим второй поток через какое-то время ... а потом и первый
        Thread.sleep(10000);
        mainGroup.interrupt();

        Thread.sleep(15000);
        t2.interrupt();

        Thread.sleep(5000);
        secondGroup.interrupt();

    }
}