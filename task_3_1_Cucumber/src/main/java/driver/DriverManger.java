package driver;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;
import props.TestData;

public class DriverManger {

    @Step("Открыть браузер и развернуть на весь экран")
    public static void initChrome() {
        Configuration.browser="chrome";
        Configuration.startMaximized=true;
        Configuration.timeout= TestData.propsDriver.configurationTimeout();
//        Configuration.headless = true;
    }

    @Step("Закрыть браузер")
    public static void quitCurrentDriver() {
        Selenide.close();
    }
}
