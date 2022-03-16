package utils;

import driver.WebDriverManger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class CustomActions {

    /**
     * Наводит курсор мыши на элемент
     *
     * @param webElement Веб-элемент на который необходимо навести курсор
     */
    public static void hover(WebElement webElement) {
        new Actions(WebDriverManger.getCurrentDriver()).moveToElement(webElement).build().perform();
    }

    /**
     * Кликает на вэб-элемент по его локатору
     *
     * @param xpath Локатор элемента, на который необходимо кликнуть
     */
    public static void click(String xpath) {
        WebDriverManger.getCurrentDriver().findElement(By.xpath(xpath)).click();
    }

    /**
     * Отправляет значение в поле веб-элемента по его локатору
     *
     * @param xpath Локатор элемента с полем, в которое необходимо ввести текст
     */
    public static void sendKeys(String xpath, String text) {
        WebDriverManger.getCurrentDriver().findElement(By.xpath(xpath)).sendKeys(text);
    }

    /**
     * Получает значение свойства/атрибута локатора веб-элемента
     *
     * @param xpath         Локатор элемента
     * @param attributeName Имя атрибута
     * @return Текущее значение свойства/атрибута или null, если значение не задано
     */
    public static String getElementAttribute(String xpath, String attributeName) {
        return WebDriverManger.getCurrentDriver().findElement(By.xpath(xpath)).getAttribute(attributeName);
    }
}
