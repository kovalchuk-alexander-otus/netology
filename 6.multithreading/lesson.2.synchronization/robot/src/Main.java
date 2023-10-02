import java.util.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    static final int THREADS = 1000; // число маршрутов (а заодно и потоков, в рамках которых они обрабатываются)
    static final int INSTRUCTIONS = 100; // число инструкций в маршруте
    static final String TEMPLATE = "RLRFR"; // шаблонная строка, участвующая в случайной генерации маршрутов
    static final char SEARCHED_SYMBOL = 'R'; // управляющая инструкция, которую подсчитываем в маршруте


    // Map : в ключах - число инструкций SEARCHED_SYMBOL в маршруте, в значениях — количество раз их появления
    public static final Map<Integer, Integer> sizeToFreq = new HashMap<>();

    public static Logger LOGGER;

    /**
     * Программное обеспечение для робота-доставщика. Инструкции для робота содержат команды:
     * R — поверни направо;
     * L — поверни налево;
     * F — двигайся вперёд.
     *
     * @param args
     */
    public static void main(String[] args) {

        LOGGER = Logger.getLogger(Main.class.getName());
        LOGGER.setLevel(Level.OFF);
        LOGGER.info("START");

        // подготавливаем пул потоков
        final ThreadPoolExecutor threadPool = (ThreadPoolExecutor) Executors.newFixedThreadPool(THREADS);

        //
        final Runnable calc = () -> {
            var temp = generateRoute(TEMPLATE, INSTRUCTIONS);
            var charArray = temp.toCharArray();
            var s = new String((char[]) charArray).chars();
            LOGGER.info(temp);

            // вывод количества команд поворота направо (инструкция 'R')
            int count = (int) s
                    .map(c -> (char) c)
                    .filter(c -> c == SEARCHED_SYMBOL)
                    .count();
            LOGGER.info("count : " + count + " : " + temp);

            // заполняем Map полученным числом инструкций SEARCHED_SYMBOL в маршруте
            synchronized (sizeToFreq) {
                sizeToFreq.put(count, sizeToFreq.getOrDefault(count, 0) + 1);
                sizeToFreq.notify();
            }
        };

        Thread lider = new Thread(() -> {
            while(!Thread.interrupted()) {
                try {
                    synchronized (sizeToFreq) {
                        sizeToFreq.wait();
                        int max = sizeToFreq.keySet().stream().mapToInt(v -> v).max().getAsInt();
                        System.out.printf("\n                    %d", max);
                    }
                } catch (InterruptedException e) {
                    return;
                }
            }
        });
        lider.start();

        // запускаем в цикле все потоки
        int i = THREADS;
        while (i > 0) {
            threadPool.submit(calc);
            i--;
        }

        // зависаем в ожидании, пока все потоки отработают
        LOGGER.info("before: " + threadPool.getActiveCount());
        while (threadPool.getActiveCount() > 0) { // для формирования отчета, ждем, чтобы все запущенные потоки отработали
        }
        lider.interrupt();
        threadPool.shutdown(); // помечаем, что потоки следует гасить после завершения работы ..иначе программа не остановится
        LOGGER.info("all must completed: " + threadPool.getActiveCount());

        // а теперь полюбуемся отчетами..
        report();
    }

    /**
     * Отчет
     */
    public static void report() {
        LOGGER.info("START формирования отчета REPORT");
        int sum = 0, count = 0;
        int max = sizeToFreq.keySet().stream().mapToInt(v -> v).max().getAsInt();
        System.out.printf("\n\nСамое частое количество повторений %d (встретилось %d раз)\n", max, sizeToFreq.get(max));
        System.out.println("Другие размеры:");

        for (Map.Entry<Integer, Integer> integerIntegerEntry : sizeToFreq.entrySet()) {
            sum += integerIntegerEntry.getKey() * integerIntegerEntry.getValue();
            count += integerIntegerEntry.getValue();
            if (integerIntegerEntry.getKey() == max) {
                continue;
            }
            System.out.printf(" -%d (%d раз)\n", integerIntegerEntry.getKey(), integerIntegerEntry.getValue());
        }
        LOGGER.info(String.format("\ncheck [%d]\n", sum));
        LOGGER.info(String.format("check count [%d]\n\n", count));
    }

    /**
     * Генератор маршрутов
     *
     * @param letters
     * @param length
     * @return
     */
    public static String generateRoute(String letters, int length) {
        Random random = new Random();
        StringBuilder route = new StringBuilder();
        for (int i = 0; i < length; i++) {
            route.append(letters.charAt(random.nextInt(letters.length())));
        }
        return route.toString();
    }
}