package ru.netology.i18n;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import ru.netology.entity.Country;

class LocalizationServiceImplTest {
    @ParameterizedTest
    @EnumSource(Country.class)
    void localeTest(Country country) {
        switch (country) {
            case RUSSIA:
                System.out.print("Добро пожаловать");
                break;
            default:
                System.out.print("Welcome");
        }
    }
}