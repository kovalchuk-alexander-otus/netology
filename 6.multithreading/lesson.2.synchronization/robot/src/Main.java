import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    static final int THREADS = 3000; // число маршрутов (а заодно и потоков, в рамках которых они обрабатываются)
    static final int INSTRUCTIONS = 100; // число инструкций в маршруте
    static final String TEMPLATE = "RLRFR"; // шаблонная строка, участвующая в случайной генерации маршрутов
    static final char SEARCHED_SYMBOL = 'R'; // управляющая инструкция, которую подсчитываем в маршруте


    // Map : в ключах - число инструкций SEARCHED_SYMBOL в маршруте, в значениях — количество раз их появления
    public static final Map<Integer, Integer> sizeToFreq = new TreeMap<>();

    // Map : в ключах попавшиеся частоты буквы 'R' (длина непрерывного промежутка), а в значениях — количество раз их появления
    public static final Map<Integer, Integer> sizeToFreqMy = new HashMap<>();
    // Счетчик потоков ... по нему понимаем, что все потоки отработали и можем приступать к формированию отчетности
    public static Integer counter;

    /**
     * Программное обеспечение для робота-доставщика. Инструкции для робота содержат команды:
     * R — поверни направо;
     * L — поверни налево;
     * F — двигайся вперёд.
     *
     * @param args
     */
    public static void main(String[] args) {

        // подготавливаем пул потоков
        final ExecutorService threadPool = Executors.newFixedThreadPool(THREADS);
        counter = THREADS;

        //
        final Runnable calc = () -> {
            var temp = generateRoute(TEMPLATE, INSTRUCTIONS);
            var charArray = temp.toCharArray();
            synchronized (counter) {
                var s = new String((char[]) charArray).chars();
                System.out.println(charArray); // debug

                // вывод количества команд поворота направо (инструкция 'R')
                int count = (int) s
                        .map(c -> (char) c)
                        .filter(c -> c == SEARCHED_SYMBOL)
                        .count();
                System.out.println("count : " + count + " : " + temp);

                // заполняем Map полученным числом инструкций SEARCHED_SYMBOL в маршруте
                synchronized (sizeToFreq) {
                    sizeToFreq.put(count, sizeToFreq.getOrDefault(count, 0) + 1);
                }

                // заполнение Map частотой появления непрерывных отрезков SEARCHED_SYMBOL
                int calcLength = 0;
                int check = 0;
                for (char c : charArray) {
                    if (c == SEARCHED_SYMBOL) {
                        calcLength++;
                    } else {
                        check += calcLength;
                        calcLength = calcMap(calcLength, sizeToFreqMy);
                    }
                }
                if (calcLength > 0) {
                    check += calcLength;
                    calcLength = calcMap(calcLength, sizeToFreqMy);
                }
                System.out.println("check : " + check + " : " + temp);
                counter -= 1;
                System.out.println("counter:" + counter);
            }
        };

        int i = THREADS;
        while (i > 0) {
            threadPool.submit(calc);
            i--;
        }

        System.out.println("before");
        threadPool.shutdown(); // ожидаем завершения выполнения всех потоков в пуле ... TODO: !!! не пашет, как ожидалось
        System.out.println("all must completed");

        // TODO: !!! мне кажется что это костыльное решение - специально завел счетчик потоков
        while (counter > 0) System.out.println(counter);
        // TODO: !!! и наконец, совсем фантастика - если убрать sout из while - программа зависает ... хотя по логам видно, что она добирается до counter = 0 ... я в нокауте


        // а теперь полюбуемся отчетами..
        report();
        reportMy();

    }

    public static void report() {
        int sum = 0;
        int max = sizeToFreq.keySet().stream().mapToInt(v -> v).max().getAsInt();
        System.out.printf("\n\nСамое частое количество повторений %d (встретилось %d раз)\n", max, sizeToFreq.get(max));
        System.out.println("Другие размеры:");

        for (Map.Entry<Integer, Integer> integerIntegerEntry : sizeToFreq.entrySet()) {
            System.out.printf(" -%d (%d раз)\n", integerIntegerEntry.getKey(), integerIntegerEntry.getValue());
            sum += integerIntegerEntry.getKey() * integerIntegerEntry.getValue();
        }
        System.out.printf("check [%d]\n\n", sum);

    }

    public static void reportMy() {
        int sum = 0;

        System.out.printf("\nСтатистика по фрагментам инструкции %s\n", SEARCHED_SYMBOL);
        System.out.println("-------------------------------------------------------");
        System.out.println("|     Длина фрагмента |   Число выявлений в маршрутах |");
        System.out.println("-------------------------------------------------------");
        for (Map.Entry<Integer, Integer> integerIntegerEntry : sizeToFreqMy.entrySet()) {
            System.out.printf("|%20d | %30d|\n", integerIntegerEntry.getKey(), integerIntegerEntry.getValue());
            sum += integerIntegerEntry.getKey() * integerIntegerEntry.getValue();
        }
        System.out.printf("check [%d]\n\n", sum);
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

    public static int calcMap(int calcLength, Map<Integer, Integer> size) {
        if (calcLength > 0) {
            synchronized (size) {
                size.put(calcLength, size.getOrDefault(calcLength, 0) + 1);
            }
            calcLength = 0;
        }
        return calcLength;
    }
}