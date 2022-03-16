package pageobject.ru.yandex;

import driver.WebDriverManger;
import utils.Streams;

/**
 * Page Object главной страницы Яндекс
 */
public class YandexMainPage {
    private String serviceNamesLocator = "//div[@class='services-new__item-title']";

    /**
     * Переходит на Яндекс Сервис
     *
     * @param serviceName Имя Яндекс сервиса, на который необходимо перейти
     * @see Streams#findElementInListByExactName(String xpath, String findText)
     * @see WebDriverManger#getTab(String partName)
     */
    public void goYandexService(String serviceName) {
        Streams.findElementInListByExactName(serviceNamesLocator, serviceName).click();
        WebDriverManger.getTab(serviceName);
    }
}
