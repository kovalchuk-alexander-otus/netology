package ru.maki;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.TreeMap;

public class MissedCalls {
    final Map<LocalDateTime, String> missedCalls;

    public MissedCalls() {
        this.missedCalls = new TreeMap<>();
    }

    // очистка списка пропущенных звонков
    public void clearMissedCalls() {
        this.missedCalls.clear();
    }

    // регистрация пропущенного вызова
    public void setMissedCalls(String phoneNumber) {
        this.missedCalls.put(LocalDateTime.now(), phoneNumber);
    }

    // вывод информации по пропущенным вызовам
    public void printMissedCalls(PhoneBook phoneBook) {
        String name;
        String phoneNumber;

        if (this.missedCalls.isEmpty()) System.out.println("У вас нет пропущенных вызовов.");
        else {
            for (LocalDateTime localDateTime : this.missedCalls.keySet()) {
                phoneNumber = this.missedCalls.get(localDateTime);
                name = phoneBook.searchNameByNumber(phoneNumber);
                if (name == null) System.out.println(phoneNumber);
                else System.out.println(name);
            }
        }
    }

}
