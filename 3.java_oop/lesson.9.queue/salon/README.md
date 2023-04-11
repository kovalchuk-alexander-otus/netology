# Домашнее задание к занятию «Коллекции Queue»

## Цель задания

1. Применить очередь для обработки набора данных.

------

## Инструкция к заданию

1. Для каждой задачи создайте отдельный реплит, если об обратном не сказано в условии.
1. Саму программу напишите в IDEA, реплит используется только для сдачи кода.
3. В окне редактора IDEA наберите программный код, решающий поставленную задачу.
5. Загрузите файлы из папки Src проекта в реплит.
6. Отправьте выполненную работу на проверку в личном кабинете Нетологии.

------

## Материалы, которые пригодятся для выполнения задания

1. [Как поделиться реплитом для проверки.](https://github.com/netology-code/java-homeworks/blob/java-43/QA_ReplitShare.md)
2. [Как автоотформатировать код.](https://github.com/netology-code/java-homeworks/blob/java-43/QA_Format.md)
3. [Как залить проект из IDEA в реплит.](https://github.com/netology-code/java-homeworks/blob/java-43/QA_ReplitUpload.md)

------

## Задание 1 (обязательное)

Вы начинающий мастер по маникюру.
Вы знаете, что делаете свою работу достаточно хорошо, так что каждый новый клиент с вероятностью 50% приведёт своего друга.

У вас есть список первых клиентов. Каждого клиента можно описать просто строкой:

```java
List<String> firstClients = List.of("Anya", "Sveta", "Olya", "Alexandra", "Ruslana", "Olesya", "Vika");
```

Создайте `Queue`-коллекцию из этих клиентов. Каждого клиента вы принимаете в порядке очереди.
В конце обработки каждого клиента с вероятностью 50% записывается его друг.
В Java сэмулировать эту вероятность можно так:

```java
if (Math.random() < 0.5) { // проверка условия, которое срабатывает с 50% вероятностью
    // друг записался
} else {
    // друг не записался
}
```

Имя другу можно сгенерировать из имени того, чьим другом он является через фразу `a friend of`.
Например, если порекомендовала `Sveta`, то друга будут звать `a friend of Sveta`.
Если и её друг порекомендует, то такого друга будут звать `a friend of a friend of Sveta`.
Новый записывающийся всегда встаёт в конец очереди.

Напишите программу, которая будет разбирать очередь из клиентов, с вероятностью 50% добавляя нового клиента после обработки текущего клиента.

В качестве обработки клиента достаточно выводить на экран фразу виду: `<имя> сделал новый маникюр`. Например, `Alexandra сделала новый маникюр`.

### Шаги реализации
Создайте пустую очередь и заполните её из списка `firstClients`.

Создайте цикл разбора очереди клиентов. Для этого нужно создать цикл `while` с проверкой очереди на непустоту в качестве условия.

На каждой итерации извлекайте следующего клиента, обрабатывайте его и затем пытайтесь добавить в очередь его друга.

------

## Правила приёма работы

Прикреплена ссылка на реплит с решением задачи.

------

## Критерии оценки

1. Программа запускается и отрабатывает без ошибок.
2. Программа соответствует всем требованиям из условия задачи.
3. Программа работает правильно на всех примерах из условия.
4. Программный код отформатирован и соответствует пройденным требованиям к качеству кода.
5. Программа спроектирована достаточно логично и правильно, не противоречит общепринятым практикам и традициям.
6. При наличии недочётов, в зависимости от их серьёзности и количества, работа может быть отправлена на доработку или принята. Решение принимается на основе экспертной оценки работы.

