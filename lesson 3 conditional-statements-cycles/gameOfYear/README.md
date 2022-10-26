## Задача 2. Угадываем високосность
Эта задача является усложнением предыдущей задачи про високосный год. В качестве домашней работы вы можете сдать любую из этих двух задач, этого будет достаточно для зачёта.

### Описание
Нужно написать программу, которая будет играть с пользователем в следующую игру.
Каждый ход программа спрашивает у него два числа: год и число дней в этом году.
Вы проверяете, правильно ли пользователь указал количество дней в этом году и, если правильно, повторяете ход. В противном случае игра завершается.
По окончании игры напишите пользователю сколько раз он угадал, это и будет количество набранных очков в игре.

### Функционал программы
1. Вывод сообщения в консоли `Введите год и количество дней в формате yyyy число`.
2. Ввод года в формате `yyyy` (например 2004) и количества дней (например, 365).
3. Проверка соответствия количества дней году
4. Повтор до тех пор пока пользователь не ошибётся; если пользователь ошибся, надо вывести правильный ответ
5. Вывод количества правильных вводов

### Пример
```
Введите год в формате: yyyy количество-дней
2000
366
Введите год в формате: yyyy количество-дней
2018
365
Введите год в формате: yyyy количество-дней
2019
300
Неправильно! В этом году 365 дней!
Набрано очков: 2
```

### Реализация
1. Создадим новый repl на сайте [repl.it](https://repl.it/repls), как написано в инструкции к выполнению домашней работы.

4. Чтобы читать сообщения из консоли воспользуемся специальным объектом `Scanner` (на следующих лекциях
мы подробнее познакомимся с термином объект), его создание делается только один раз на всю программу, не забудьте заимпортить.

```java
Scanner scanner = new Scanner(System.in);
```

2. Создадим в методе `main` целочисленную переменную, которая будет считать количество набранных очков; начальное её значение - 0.

3. Создадим цикл `while (true) {}`, итерацией которого будет один ход игры.

6. В начале хода просим пользователя ввести и считываем год и количество дней в этом году по мнению пользователя.

7. Считаем правильное количество дней для введённого года, использую логику из предыдущей задачи про високосный год. Будет здорово, если вы вынесете логику определения количества дней в году в отдельный метод, который по году считает количество в нём дней.

8. Условным оператором проверяем, совпадает ли введённое пользователем число дней в этом году с правильным числом дней в году. Если совпадает, увеличиваем счётчик успешных попыток и переходим к следующей итерации. Если не совпадает, то завершаем игру и выводим количество правильных вводов (это хранится в счётчике).

9. Завершение работы программы.