package utils;

import driver.WebDriverManger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;


/**
 * Этот класс содержит ожидаемые условия
 */
public class Waits {

    /**
     * Ожидание проверки, что каждый элемент выбран
     *
     * @param xpath Локатор списка элементов
     */
    public static void eachElementIsSelected(String xpath) {
        WebDriverManger.getCurrentDriver().findElements(By.xpath(xpath)).forEach(WebElement::isSelected);
    }

    /**
     * Ожидание проверки, что каждый элемент в списке виден
     *
     * @param xpath Локатор списка элементов
     */
    public static void untilEachElementIsVisible(String xpath) {
        List<WebElement> list = WebDriverManger.getCurrentDriver().findElements(By.xpath(xpath));
        for (WebElement ele : list) {
            ele.isDisplayed();
        }
    }

    /**
     * Ожидание того, что количество веб-элементов в списке
     * соответствует указанному ожидаемому занчению
     *
     * @param xpath         Локатор списка веб-элементов
     * @param expectedValue Ожидаемое количество элементов
     */
    public static void numberOfElementsToBe(String xpath, Integer expectedValue) {
        new WebDriverWait(WebDriverManger.getCurrentDriver(), Constants.DEFAULT_TIMEOUT)
                .until(ExpectedConditions.numberOfElementsToBe(By.xpath(xpath), expectedValue));
    }

    /**
     * Ожидание для проверки, что элемент невидим на странице
     *
     * @param xpath Локатор элемента
     */
    public static void untilInvisibilityOf(String xpath) {
        new WebDriverWait(WebDriverManger.getCurrentDriver(), Constants.DEFAULT_TIMEOUT)
                .until(ExpectedConditions.invisibilityOf(WebDriverManger.getCurrentDriver().findElement(By.xpath(xpath))));
    }

    /**
     * Ожидание для проверки, что элемент станет видимым
     * и в то же время проверяет кликабельность
     *
     * @param xpath Локатор элемента
     */
    public static void elementToBeClickable(String xpath) {
        new WebDriverWait(WebDriverManger.getCurrentDriver(), Constants.DEFAULT_TIMEOUT)
                .until(ExpectedConditions.elementToBeClickable(WebDriverManger.getCurrentDriver().findElement(By.xpath(xpath))));
    }

    /**
     * Ожидание для проверки, что элемент, который присутствует
     * в DOM структуре странице, видимый.
     * Видимость означает, что элементы не только отображаются,
     * но также имеют высоту и ширину, превышающие 0.
     *
     * @param xpath Локатор эелемента
     */
    public static void untilVisibilityOf(String xpath) {
        new WebDriverWait(WebDriverManger.getCurrentDriver(), Constants.DEFAULT_TIMEOUT)
                .until(ExpectedConditions.visibilityOf(WebDriverManger.getCurrentDriver().findElement(By.xpath(xpath))));
    }

    /**
     * Ожидание для проверки, что все элементы, присутствующие на веб-странице,
     * которые соответствуют локатору, видны. Видимость означает,
     * что элементы не только отображаются, но также имеют высоту и ширину, превышающие 0.
     *
     * @param xpath Локатор списка эелементов
     */
    public static void untilVisibilityOfAllElements(String xpath) {
        new WebDriverWait(WebDriverManger.getCurrentDriver(), Constants.DEFAULT_TIMEOUT)
                .until(ExpectedConditions.visibilityOfAllElements(WebDriverManger.getCurrentDriver().findElements(By.xpath(xpath))));
    }

    /**
     * Ожидает для проверки наличия элемента в DOM структуре страницы.
     * При этом необязательно должен быть виден на странице
     *
     * @param xpath Локатор элемента
     */
    public static void untilPresenceOfElementLocated(String xpath) {
        new WebDriverWait(WebDriverManger.getCurrentDriver(), Constants.DEFAULT_TIMEOUT)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
    }
}
