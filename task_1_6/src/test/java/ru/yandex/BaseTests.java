package ru.yandex;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import props.TestData;

public class BaseTests {
//    @Step("Открыть браузер и развернуть на весь экран")
    @BeforeEach
    public void option(){
        Configuration.browser="chrome";
        Configuration.timeout= TestData.propsDriver.configurationTimeout();
        Configuration.startMaximized=true;
    }

    @AfterEach
    public void after() {
        Selenide.close();
    }
}
