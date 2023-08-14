package ru.netology.i18n;

import ru.netology.entity.Country;

public class LocalizationServiceImpl implements LocalizationService {

    public String locale(Country country) {
        if (country != null){
            if (country == Country.RUSSIA) {
                return "Добро пожаловать";
            }
            return "Welcome";
        }
        return "Welcome";
    }
}
