package ru.yandex.market;

import driver.WebDriverManger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public class BaseTest {


    /**
     * @see WebDriverManger#initChrome()
     */
    @BeforeEach
    public void beforeEach() {
        WebDriverManger.initChrome();
    }

    /**
     * @see WebDriverManger#quitCurrentDriver()
     */
    @AfterEach
    public void afterEach() {
        WebDriverManger.quitCurrentDriver();
    }
}
