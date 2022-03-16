package driver;

import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.SessionNotCreatedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static utils.Constants.DEFAULT_TIMEOUT;
import static utils.Constants.PAGE_LOAD_TIMEOUT;

public class WebDriverManger {
    private static WebDriver currentDriver;

    public static WebDriver getCurrentDriver() {
        return currentDriver;
    }

    @Step("Открыть браузер и развернуть на весь экран.")
    public static void initChrome() {
        System.setProperty("webdriver.chrome.driver", System.getenv("CHROME_DRIVER"));
        try {
            currentDriver = new ChromeDriver();
        } catch (SessionNotCreatedException e) {
            e.printStackTrace();
            Assertions.fail("Данный драйвер несовместим с текущим браузером. Используйте другой драйвер");
        }

        setDefaultOptions();
    }

    public static void setDefaultOptions() {
        currentDriver.manage().window().maximize();
        currentDriver.manage().timeouts().implicitlyWait(DEFAULT_TIMEOUT, TimeUnit.SECONDS);
        currentDriver.manage().timeouts().pageLoadTimeout(PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
    }

    public static void quitCurrentDriver() {
        currentDriver.quit();
    }

    public static void getTab(String partName) {
        List<String> tabs = new ArrayList<>(currentDriver.getWindowHandles());
        try {
            for (String tab : tabs) {
                if (!currentDriver.getTitle().contains(partName))
                    currentDriver.switchTo().window(tab);
            }
        } catch (NoSuchWindowException e) {
            e.printStackTrace();
            Assertions.fail("Не удалось открыть вкладку, содержащую " + partName);
        }
    }
}
