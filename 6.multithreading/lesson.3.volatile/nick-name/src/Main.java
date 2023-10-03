import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    static AtomicInteger counter3 = new AtomicInteger();
    static AtomicInteger counter4 = new AtomicInteger();
    static AtomicInteger counter5 = new AtomicInteger();

    public static void main(String[] args) throws InterruptedException {
        Random random = new Random();
        String[] texts = new String[100_000];
        for (int i = 0; i < texts.length; i++) {
            texts[i] = generateText("abc", 3 + random.nextInt(3));
        }

        Thread thread1 = new Thread(() -> {
            for (String text : texts) {
                if (isPalindrome(text)) {
                    counter(text);
                }
            }
        });
        Thread thread2 = new Thread(() -> {
            for (String text : texts) {
                if (isSingleLetter(text)) {
                    counter(text);
                }
            }
        });
        Thread thread3 = new Thread(() -> {
            for (String text : texts) {
                if (isOrderedLetter(text)) {
                    counter(text);
                }
            }
        });
        thread3.start();
        thread2.start();
        thread1.start();
        thread1.join();
        thread2.join();
        thread1.join();
        System.out.printf("Красивых слов с длиной 3: %d шт\n", counter3.get());
        System.out.printf("Красивых слов с длиной 4: %d шт\n", counter4.get());
        System.out.printf("Красивых слов с длиной 5: %d шт\n", counter5.get());
    }

    /**
     * Счетчик количества слов, соответствующей длинны
     *
     * @param text
     */
    private static void counter(String text) {
        switch (text.length()) {
            case 5:
                counter5.addAndGet(1);
                break;
            case 4:
                counter4.addAndGet(1);
                break;
            case 3:
                counter3.addAndGet(1);
                break;
            default:
        }
    }

    /**
     * Проверка, что nickName - палиндром (одинаково читается как слева направо, так и справа налево)
     *
     * @param nickName
     * @return
     */
    private static boolean isPalindrome(String nickName) {
        return nickName.contentEquals(new StringBuilder(nickName).reverse());
    }

    /**
     * Проверка, что nickName состоит из одной буквы
     *
     * @param nickName
     * @return
     */
    private static boolean isSingleLetter(String nickName) {
        char previous = 'z';
        for (char c : nickName.toCharArray()) {
            if (previous != 'z' && previous != c) {
                return false;
            }
            previous = c;
        }
        return true;
    }

    /**
     * Проверка, что nickName состоят из букв, упорядоченных по возрастанию
     *
     * @param nickName
     * @return
     */
    private static boolean isOrderedLetter(String nickName) {
        char previous = 'z';
        for (char c : nickName.toCharArray()) {
            if (previous != 'z' && previous > c) {
                return false;
            }
            previous = c;
        }
        return true;
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