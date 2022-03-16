package tests.ru.yandex;

import driver.DriverManger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public class BaseTests {
    @BeforeEach
    public void beforeEach(){
        DriverManger.initChrome();
    }

    @AfterEach
    public void afterEach() {
        DriverManger.quitCurrentDriver();
    }
}
