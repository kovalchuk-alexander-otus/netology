package ru.netology.i18n;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import ru.netology.entity.Country;
import ru.netology.i18n.LocalizationService;
import ru.netology.i18n.LocalizationServiceImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LocalizationServiceImplTest {

    final LocalizationService localizationService = new LocalizationServiceImpl();

    @ParameterizedTest
    @CsvSource({
            "RUSSIA,         Добро пожаловать",
            "GERMANY,        Welcome",
            "USA,            Welcome",
            "BRAZIL,         Welcome"
    })
    void testLocale(Country country, String locale) {
        String expectedLocale = localizationService.locale(country);
        assertEquals(locale, expectedLocale);
    }

}
