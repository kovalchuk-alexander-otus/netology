import ru.maki.OnTaskDoneListener;
import ru.maki.OnTaskErrorListener;
import ru.maki.Worker;

public class Main {
    public static void main(String[] args) {

        OnTaskDoneListener listener = System.out::println;
        OnTaskErrorListener errorListener = System.out::println;

        Worker worker = new Worker(listener, errorListener);

        worker.start();
    }
}