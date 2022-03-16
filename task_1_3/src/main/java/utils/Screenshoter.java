package utils;

import io.qameta.allure.Attachment;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Вспомогательный класс, содержит статические функции, чтобы делать скриншоты
 */
public class Screenshoter {


    /**
     * Переходит к элементу на странице по его локатору,
     * делает скриншот и сохраняет его по пути "src/main/resources"
     *
     * @param webDriver      Веб драйвер
     * @param elementLocator Локатор еэлемента, который необходимо заснять
     * @return Сохраняет скриншот с именем screenshot.png
     * @throws Exception Возвращает пустой массив байт
     */
    @Attachment
    public static byte[] getScreenshot(WebDriver webDriver, By elementLocator) {
        new Actions(webDriver).moveToElement(webDriver.findElement(elementLocator)).build().perform();
        File screenshot = ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenshot, new File("src/main/resources/screenshot.png"));
            return Files.readAllBytes(Paths.get("src/main/resources", "screenshot.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new byte[0];
    }
}
