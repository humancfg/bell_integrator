package utils;

import driver.WebDriverManger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Streams {

    /**
     * Находит текст <b>по точному совпадению</b> в списке веб-элементов
     *
     * @param xpath    Локатор списка элементов для фильтрации
     * @param findText Текст, который необходимо найти в элементе
     * @return Веб-элемент с найденным текстом
     */
    public static WebElement findElementInListByExactName(String xpath, String findText) {
        return WebDriverManger.getCurrentDriver().findElements(By.xpath(xpath)).stream()
                .filter(x -> x.getText().equals(findText))
                .findFirst()
                .get();
    }

    /**
     * Получает текст первого элемента в списке веб-элементов
     *
     * @param xpath Локатор списка элементов
     * @return Полученный текст у элемента
     */
    public static String findFirstElementTextInList(String xpath) {
        return WebDriverManger.getCurrentDriver().findElements(By.xpath(xpath)).stream()
                .findFirst()
                .get()
                .getText();
    }
}
