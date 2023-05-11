import java.util.*;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {

  public static void main(String[] args) throws InterruptedException, ExecutionException {
    String[] texts = new String[25];

    final ExecutorService threadPool = Executors.newFixedThreadPool(25);
    List<Future> futures = new ArrayList<>(); // объявляем массив потоков

    for (int i = 0; i < texts.length; i++) {
      texts[i] = generateText("aab", 30_000);

      String text = texts[i]; // сохраним строчку в переменную

      Callable<Integer> callable = () -> { // оформим лямбду (логику не менял)
        int maxSize = 0;
        for (int s = 0; s < text.length(); s++) {
          for (int j = 0; j < text.length(); j++) {
            if (s >= j) {
              continue;
            }
            boolean bFound = false;
            for (int k = s; k < j; k++) {
              if (text.charAt(k) == 'b') {
                bFound = true;
                break;
              }
            }
            if (!bFound && maxSize < j - s) {
              maxSize = j - s;
            }
          }
        }
        System.out.println(text.substring(0, 100) + " -> " + maxSize);
        return maxSize;
      };

      futures.add(threadPool.submit(callable)); // добавим очередной поток с нашей лямбдой
    }

    long startTs = System.currentTimeMillis(); // start time

    int maxRange = 0;
    for (Future<Integer> future : futures) { // блок-запуска выполнения всех потоков
      maxRange = Math.max(maxRange, future.get());
    }
    System.out.printf("Максимальный интервал значений: %d%n%n", maxRange);

    long endTs = System.currentTimeMillis(); // end time

    System.out.println("Time: " + (endTs - startTs) + "ms");

    threadPool.shutdown();
  }

  public static String generateText(String letters, int length) {
    Random random = new Random();
    StringBuilder text = new StringBuilder();
    for (int i = 0; i < length; i++) {
      text.append(letters.charAt(random.nextInt(letters.length())));
    }
    return text.toString();
  }
}