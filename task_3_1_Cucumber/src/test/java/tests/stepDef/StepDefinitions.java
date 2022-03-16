package tests.stepDef;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import driver.DriverManger;
import pages.ru.yandex.YandexBasePage;
import pages.ru.yandex.YandexMainPage;
import pages.ru.yandex.market.CatalogSmartphones;
import pages.ru.yandex.market.YandexMarketMainPage;

import static com.codeborne.selenide.Selenide.open;

public class StepDefinitions {

    @Before
    public void openBrowser() {
        DriverManger.initChrome();
    }

    @After
    public void closeBrowser() {
        DriverManger.quitCurrentDriver();
    }

    @When("Зайти на yandex.ru")
    public void openYandexUrl() {
        YandexBasePage.openYandexUrl(YandexMainPage.class);
    }

    @When("Перейти в яндекс маркет")
    public void goYandexMarket() {
        new YandexMainPage().goMarketService();
    }

    @When("Выбрать категорию {string}")
    public void selectCategory(String category) {
        new YandexMarketMainPage().selectCategory(category);
    }

    @When("Выбрать подкатегорию {string}")
    public void selectSubCategory(String subcategory) {
        new YandexMarketMainPage().selectSubCategory(subcategory);
    }

    @When("Задать параметр «Производитель» {string}")
    public void selectManufacturer(String manufacturer) {
        new CatalogSmartphones().selectManufacturer(manufacturer);
    }

    @When("Дождаться результатов поиска")
    public void waitsSearchResult() {
        new CatalogSmartphones().waitsSearchResult();
    }

    @When("Установить количество показываемых элементов на страницу 12")
    public void setItemsPerPageShowBy12() {
        new CatalogSmartphones().setItemsPerPageShowBy12();
    }

    @Then("Убедится что в выборку попали только {string}")
    public void checksSearchResultsNames(String filterName) {
        new CatalogSmartphones().checksSearchResultsNames(filterName);
    }
}
