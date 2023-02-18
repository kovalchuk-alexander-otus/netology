import ru.maki.PasswordChecker;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        try (Scanner scanner = new Scanner(System.in)) {
            PasswordChecker passwordChecker = new PasswordChecker();

            System.out.println("Введите мин. длину пароля: ");
            int minLength = scanner.nextInt();
            passwordChecker.setMinLength(minLength);

            System.out.println("Введите макс. допустимое количество повторений символа подряд: ");
            int maxRepeats = scanner.nextInt();
            passwordChecker.setMaxRepeats(maxRepeats);

            String password;
            scanner.nextLine(); // слижем перевод строки

            while (true) {
                System.out.println("Введите пароль или end: ");
                password = scanner.nextLine();

                if ("end".equals(password)) {
                    break;
                }

                System.out.println(passwordChecker.verify(password) ? PasswordChecker.SUITABLE :
                        PasswordChecker.NOT_SUITABLE);
            }
        }

    }
}