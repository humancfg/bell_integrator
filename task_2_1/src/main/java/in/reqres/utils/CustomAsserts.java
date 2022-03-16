package in.reqres.utils;

import io.qameta.allure.Step;
import org.testng.Assert;

public class CustomAsserts {

    @Step("Проверяем, что: '{message}'")
    public static void assertTrue(boolean condition, String message) {
        Assert.assertTrue(condition, message);
    }

    @Step("Проверяем, что: '{message}'")
    public static void assertNotEquals(Integer int1, Integer int2, String message) {
        Assert.assertNotEquals(int1, int2, message);
    }
}
