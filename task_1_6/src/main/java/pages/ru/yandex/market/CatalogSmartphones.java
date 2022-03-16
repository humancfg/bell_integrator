package pages.ru.yandex.market;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import pages.ru.yandex.YandexBasePage;
import utils.CustomAssertions;
import utils.Streams;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class CatalogSmartphones extends YandexBasePage {
    private SelenideElement searchResultsLoader = $x("//div[@role='main']/div[last() and not(contains(@data-apiary-widget-name,'@MarketNode/SearchPartition'))]");
    private ElementsCollection searchResultsNames = $$x("//article[@data-autotest-id='product-snippet']/descendant::a[@title]/span");
    private String buttonMoreLoader = "//div[@data-apiary-widget-name='@MarketNode/SearchPager']/descendant::button[@disabled]";


    @Step("Задать параметр «Производитель» {manufacturerName}")
    public CatalogSmartphones selectManufacturer(String manufacturerName) {
        SelenideElement rollDownManufacturer = $x("//legend[text()='Производитель']/..//button[text()='Показать всё']");
        SelenideElement manufacturerInputField = $x("//legend[text()='Производитель']/../descendant::input[@name='Поле поиска']");
        SelenideElement name = $x("//input[@name='Производитель " + manufacturerName + "']/../div/span");
        rollDownManufacturer.click();
        manufacturerInputField.sendKeys(manufacturerName);
        CustomAssertions.assertTrue(name.getText().equals(manufacturerName),
                "Чекбокс производителя " + manufacturerName + " не существует");
        name.shouldBe(visible).click();
        return page(CatalogSmartphones.class);
    }

    @Step("Дождаться результатов поиска.")
    public CatalogSmartphones waitsSearchResult() {
        searchResultsLoader.is(disappear);
        CustomAssertions.assertTrue(searchResultsLoader.is(appear), "Результаты поиска не обновились");
        return page(CatalogSmartphones.class);
    }

    @Step("Установить количество показываемых элементов на страницу. 12")
    public CatalogSmartphones setItemsPerPageShowBy12() {
        SelenideElement buttonShowBy = $x("//button[contains(@id, 'dropdown-control')]");
        SelenideElement showBy12 = $x("//button[text()='Показывать по 12']");

        if (buttonShowBy.is(visible)) {
            buttonShowBy.shouldBe(visible).click();
            showBy12.shouldBe(visible).click();
            searchResultsLoader.is(disappear);
            searchResultsNames.shouldHave(size(12));
            CustomAssertions.assertTrue(searchResultsNames.size() == 12,
                    "На странице показывает " + searchResultsNames.size() + " элементов");
        }
        return page(CatalogSmartphones.class);
    }

    @Step("Убедится что в выборку попали только {contains}. Если страниц несколько – проверить все.")
    public CatalogSmartphones checksSearchResultsNames(String contains) {
        SelenideElement buttonMore = $x("//div[@data-apiary-widget-name='@MarketNode/SearchPager']//button[text()='Показать ещё']");
        while (buttonMore.is(exist)) {
            buttonMore.click();
            $x(buttonMoreLoader).shouldNotBe(appear);
        }
        boolean flag = Streams.allMatchElements(searchResultsNames, contains);
        CustomAssertions.assertTrue(flag, "В выборку попали не только " + contains);
        return page(CatalogSmartphones.class);
    }
}
