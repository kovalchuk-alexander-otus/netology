import ru.maki.Authentication;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Authentication authentication = new Authentication();
        authentication.regUser("author", "itet", 3, "itet@mail.ru");
        authentication.regUser("basov", "gfdfhjnnb", 34, "basov.pavel@gmail.com");
        authentication.regUser("irrrrrrusik", "irrr0chk@", 43, "irairaira@yandex.ru");
        authentication.regUser("tunika", "teterev0chek", 24, "tuny@mail.ru");

        Scanner scanner = new Scanner(System.in);
        String  login, password;
        while (true) {
            System.out.print("Введите логин: \n > ");
            login = scanner.nextLine();
            System.out.print("Введите пароль: \n > ");
            password = scanner.nextLine();
            authentication.checkAccess(login, password);
            System.out.println("Доступ предоставлен");
        }

    }

}