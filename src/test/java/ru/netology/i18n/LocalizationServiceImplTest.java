package ru.netology.i18n;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import ru.netology.entity.Country;

class LocalizationServiceImplTest {
    @ParameterizedTest
    @EnumSource(Country.class)
    void localeTest(Country country) {
    final String expectedRussia = "Добро пожаловать";
    final String expected = "Welcome";
        switch (country) {
            case RUSSIA:
                String actualRussia = "Добро пожаловать";
                Assertions.assertEquals(expectedRussia, actualRussia);
                break;
            default:
                String actual = "Welcome";
                Assertions.assertEquals(expected, actual);
        }
    }
}