import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.function.Consumer;

public class Main {
    private static final int QUE_LENGTH = 100;
    private static final int WORD_LENGTH = 100_000;
    private static final String WORD_TEMPLATE = "abc";
    private static final int REPS = 10_000;
    private static BlockingQueue<String> queForA = new ArrayBlockingQueue<>(QUE_LENGTH);
    private static BlockingQueue<String> queForB = new ArrayBlockingQueue<>(QUE_LENGTH);
    private static BlockingQueue<String> queForC = new ArrayBlockingQueue<>(QUE_LENGTH);

    public static void main(String[] args) {
        Consumer<Pack> printChampion = (pack) -> {
            long maxCount = 0;
            for (int q = 0; q < REPS; q++) {
                try {
                    long newCandidate = pack.getQue().take().chars().filter(c -> c == pack.getSymbol()).count();
                    maxCount = Math.max(maxCount, newCandidate);
                    // System.out.printf("[%d]:[%d]\n", maxCount, newCandidate);
                } catch (InterruptedException e) {
                    System.out.println("exception при извлечении из очереди");
                    return;
                }
            }
            System.out.printf("mr.Champion in group '%s' [ %d ]\n", pack.getSymbol(), maxCount);
        };
        new Thread(() ->
                printChampion.accept(new Pack(queForA, 'a'))).start();
        new Thread(() ->
                printChampion.accept(new Pack(queForB, 'b'))).start();
        new Thread(() ->
                printChampion.accept(new Pack(queForC, 'c'))).start();

        new Thread(() -> {
            String randomWord;
            for (int i = 0; i < REPS; i++) {
                randomWord = generateText(WORD_TEMPLATE, WORD_LENGTH);
                try {
                    queForA.put(randomWord);
                    queForB.put(randomWord);
                    queForC.put(randomWord);
                } catch (InterruptedException e) {
                    System.out.println("exception при помещении в очереди");
                    return;
                }
            }
        }).start();
    }

    /**
     * Тексто-генератор
     *
     * @param letters - перечень символов, доступных при генерации строки
     * @param length  - длинна строки
     * @return
     */
    public static String generateText(String letters, int length) {
        Random random = new Random();
        StringBuilder text = new StringBuilder();
        for (int i = 0; i < length; i++) {
            text.append(letters.charAt(random.nextInt(letters.length())));
        }
        return text.toString();
    }


}

/**
 * Оболочка, для использования функционального интерфейса Consumer (требующего на вход один аргумент)
 */
@AllArgsConstructor
class Pack {
    @Getter
    private BlockingQueue<String> que;
    @Getter
    private char symbol;
}