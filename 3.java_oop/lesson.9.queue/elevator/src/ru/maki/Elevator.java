package ru.maki;

import java.util.LinkedList;
import java.util.Queue;

public class Elevator {

    public final int ELEVATOR_SPEED = 5; // время проезда одного этажа
    public final int ELEVATOR_STOP_TIME = 10; // время нахождения на этаже
    private final int minFloor;
    private final int maxFloor;
    private final Queue<Integer> trip;

    public Elevator(int minFloor, int maxFloor) {
        this.trip = new LinkedList<>();
        this.minFloor = minFloor;
        this.maxFloor = maxFloor;
    }

    // поездка на лифте
    public void liftRide() {
        int floor;
        do {
            floor = Dialog.getInteger("Ожидаю ввода этажа: (для завершения введите 0): ");
            if (floor == -1) continue;
            else {
                if (floor < this.minFloor || floor > this.maxFloor) {
                    System.out.println("Такого этажа в доме нет.");
                } else trip.offer(floor);
            }
        } while (floor != 0);

        System.out.println(this.trip);
    }

    // отчет о поездке
    public void tripReport() {
        int previousFloor = -1;
        int travelTime = 0;
        while (!trip.isEmpty()) {
            if (previousFloor != -1) {
                travelTime += Math.abs(previousFloor - trip.peek()) * this.ELEVATOR_SPEED;
            }
            travelTime += this.ELEVATOR_STOP_TIME;
            previousFloor = trip.poll();

            System.out.printf("этаж %d -> ", previousFloor);

        }
        System.out.println("этаж 0");
        System.out.printf("Время затраченное лифтом на маршрут =: %d с.%n%n", travelTime);

    }
}
