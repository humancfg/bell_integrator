package utils;

import io.qameta.allure.Step;

public class CustomAssertions {

    @Step("Проверяем что нет ошибки: '{message}'")
    public static void assertTrue(boolean condition, String message){
        org.junit.jupiter.api.Assertions.assertTrue(condition,message);
    }
}
