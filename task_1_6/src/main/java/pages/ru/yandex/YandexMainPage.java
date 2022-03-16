package pages.ru.yandex;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import pages.ru.yandex.market.YandexMarketMainPage;
import utils.CustomAssertions;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;


public class YandexMainPage extends YandexBasePage {
    private SelenideElement serviceNamesLocator = $x("//div[@class='services-new__item-title']");

    @Step("Перейти в Яндекс.{serviceName}")
    public YandexMarketMainPage goYandexService(String serviceName) {
        CustomAssertions.assertTrue(serviceNamesLocator.getText().equals(serviceName), "Сервис " + serviceName + " не найден");
        serviceNamesLocator.shouldBe(visible).shouldHave(text(serviceName)).click();
        switchTo().window(1);
        return page(YandexMarketMainPage.class);
    }
}
