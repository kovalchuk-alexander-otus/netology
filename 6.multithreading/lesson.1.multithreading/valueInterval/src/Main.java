import java.util.*;

public class Main {

  public static void main(String[] args) throws InterruptedException {
    String[] texts = new String[25];

    List<Thread> threads = new ArrayList<>(); // объявляем массив потоков

    for (int i = 0; i < texts.length; i++) {
      texts[i] = generateText("aab", 30_000);

      String text = texts[i]; // сохраним строчку в переменную

      Runnable runnable = () -> { // оформим лямбду (логику не менял)
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
      };

      threads.add(new Thread(runnable)); // добавим очередной поток с нашей лямбдой
    }

    long startTs = System.currentTimeMillis(); // start time

    for (Thread thread : threads) { // блок-запуска выполнения всех потоков
      thread.start();
    }

    for (Thread thread : threads) { // блок-ожидания завершения выполнения всех потоков
      thread.join();
    }

    long endTs = System.currentTimeMillis(); // end time

    System.out.println("Time: " + (endTs - startTs) + "ms");
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