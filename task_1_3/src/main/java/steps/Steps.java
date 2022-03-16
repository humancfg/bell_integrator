package steps;

import driver.WebDriverManger;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import pageobject.ru.yandex.YandexMainPage;
import pageobject.ru.yandex.market.CatalogLaptops;
import pageobject.ru.yandex.market.YandexMarketMainPage;
import utils.CustomActions;
import utils.Screenshoter;
import utils.Waits;

public class Steps {
    /**
     * Шаг: Зайти на yandex.ru
     *
     * @param url адрес веб-страницы
     */
    @Step("Зайти на yandex.ru.")
    public static void goPage(String url) {
        WebDriverManger.getCurrentDriver().get(url);
    }

    /**
     * Шаг: Переход в Яндекс Сервис
     *
     * @param serviceName Имя Яндекс Сервиса, на который необходимо перейти
     */
    @Step("Перейти в Яндекс.{serviceName}")
    public static void goYandexService(String serviceName) {
        new YandexMainPage().goYandexService(serviceName);
    }

    /**
     * Шаг: Выбрать раздел(категорию)
     *
     * @param categoryName Имя категории
     */
    @Step("Выбрать раздел {categoryName}")
    public static void selectCategory(String categoryName) {
        new YandexMarketMainPage().selectCategory(categoryName);
    }

    /**
     * Шаг: Выбрать раздел(подкатегорию)
     *
     * @param subCategoryName Имя подкатегории
     */
    @Step("Выбрать раздел {subCategoryName}")
    public static void selectSubCategory(String subCategoryName) {
        new YandexMarketMainPage().selectSubCategory(subCategoryName);
    }

    /**
     * Шаг: Задать параметр "Цена, Р"
     *
     * @param minPrice Значение минимальной цены
     * @param maxPrice Значение максимальной цены
     */
    @Step("Задать параметр «Цена, Р» от {minPrice} до {maxPrice} рублей.")
    public static void setPrice(String minPrice, String maxPrice) {
        new CatalogLaptops().setPrice(minPrice, maxPrice);
    }

    /**
     * Шаг: Выбрать производителя
     *
     * @param manufacturerName1 Имя производителя1
     * @param manufacturerName2 Имя производителя2
     */
    @Step("Выбрать производителя {manufacturerName1} и {manufacturerName2}")
    public static void selectManufacturer(String manufacturerName1, String manufacturerName2) {
        CatalogLaptops catalogLaptops = new CatalogLaptops();
        catalogLaptops.showAllManufacturers();
        catalogLaptops.selectManufacturer(manufacturerName1);
        catalogLaptops.selectManufacturer(manufacturerName2);
        Waits.eachElementIsSelected(catalogLaptops.getCheckboxManufacturerList());
    }

    /**
     * Шаг: Дождаться результатов поиска
     */
    @Step("Дождаться результатов поиска")
    public static void waitsSearchResult() {
        CatalogLaptops catalogLaptops = new CatalogLaptops();
        String results = catalogLaptops.getSearchResultsNamesLocator();
        Waits.untilEachElementIsVisible(results);
    }

    /**
     * Шаг: Установить количество показываемых элементов на страницу 12
     */
    @Step("Установить количество показываемых элементов на страницу 12.")
    public static void setElementsPerPageShowBy12() {
        new CatalogLaptops().setItemsPerPageShowBy12();
    }

    /**
     * Шаг: Дождаться обновления результатов
     */
    @Step("Дождаться обновления результатов.")
    public static void waitsUpdatedSearchResults() {
        CatalogLaptops catalogLaptops = new CatalogLaptops();
        String results = catalogLaptops.getSearchResultsNamesLocator();
        Waits.untilEachElementIsVisible(results);
    }

    /**
     * Шаг: Проверить, что на странице отображалось 12 элементов
     */
    @Step("Проверить, что на странице отображалось 12 элементов.")
    public static void checkItemsSizeOnPage() {
        Integer expectedSize = 12;
        CatalogLaptops catalogLaptops = new CatalogLaptops();
        String locator = catalogLaptops.getSearchResultsNamesLocator();
        Waits.numberOfElementsToBe(locator, expectedSize);
    }

    /**
     * Шаг: Запомнить наименование первого значения в списке
     */
    @Step("Запомнить наименование первого значения в списке.")
    public static void saveFirstValueFromResultList() {
        CatalogLaptops.saveFirstValueFromList();
    }

    /**
     * Шаг: В поисковую строку ввести запомненное значение
     */
    @Step("В поисковую строку ввести запомненное значение.")
    public static void enterSavedValueIntoSearchField() {
        String savedValue = CatalogLaptops.getCurrentValue();
        new CatalogLaptops().putValueIntoSearchField(savedValue);
    }

    /**
     * Шаг: Нажать кнопку "Найти"
     */
    @Step("Нажать кнопку «Найти»")
    public static void clickFindButton() {
        String findButton = new CatalogLaptops().getSearchButtonLocator();
        CustomActions.click(findButton);
    }

    /**
     * Шаг: Проверить, что наименование товара соответствует сохраненному значению.
     */
    @Step("Проверить, что наименование товара соответствует сохраненному значению.")
    public static void checksProductNameMatchSavedValue() {
        CatalogLaptops catalogLaptops = new CatalogLaptops();
        String savedValue = CatalogLaptops.getCurrentValue();
        String productName = catalogLaptops.getTextFromSearchField();
        Assertions.assertEquals(savedValue, productName,
                "Наименование товара несоответствует сохраненному значению");
        if (!savedValue.equals(productName)) {
            Screenshoter.getScreenshot(WebDriverManger.getCurrentDriver(), By.xpath(catalogLaptops.getTextFromSearchField()));
        }
    }
}
