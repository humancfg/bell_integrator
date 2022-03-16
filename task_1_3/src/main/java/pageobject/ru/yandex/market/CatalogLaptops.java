package pageobject.ru.yandex.market;

import utils.CustomActions;
import utils.Constants;
import utils.Streams;
import utils.Waits;

/**
 * Page Object страницы каталога с ноутбуками в Яндекс.Маркет
 */
public class CatalogLaptops {
    private String searchButtonLocator = "//span[contains(text(), 'Найти')]/ancestor::button";
    private String searchFieldLocator = "//input[@placeholder='Искать товары']";
    private String minPriceLocator = "//legend[text()='Цена, ₽']/../descendant::input[@name='Цена от']";
    private String maxPriceLocator = "//legend[text()='Цена, ₽']/../descendant::input[@name='Цена до']";
    private String showAllButtonLocator = "//fieldset[@data-autotest-id='7893318']//button[text()='Показать всё']";
    private String rollUpButtonLocator = "//fieldset[@data-autotest-id='7893318']//button[text()='Свернуть']";
    private String checkboxManufacturerList = "//fieldset[@data-autotest-id='7893318']//input[@type='checkbox']/..//span";
    private String loaderLocator = "//div[@role='main']/div[last() and not(contains(@data-apiary-widget-name,'@MarketNode/SearchPartition'))]";
    private String buttonShowByLocator = "//span[contains(text(),'Показывать по')]/ancestor::button";
    private String buttonShowBy12Locator = "//button[text()='Показывать по 12']";
    private String searchResultsNamesLocator = "//div[@data-zone-name='SearchResults']/descendant::h3[@data-zone-name='title']/a/span";
    private static String currentValue;

    /**
     * Вводит минимальную цену в поле "Цена от"
     * и максимальную цену в поле "Цена до" в боковом меню.
     *
     * @param minPrice Строковое значение минимальной цены
     * @param maxPrice Строковое значение максимальной цены
     * @see Waits#elementToBeClickable(String xpath)
     * @see CustomActions#sendKeys(String xpath, String value)
     */
    public void setPrice(String minPrice, String maxPrice) {
        Waits.untilVisibilityOf(minPriceLocator);
        CustomActions.sendKeys(minPriceLocator, minPrice);
        CustomActions.sendKeys(maxPriceLocator, maxPrice);
    }


    /**
     * Кликает на имя производителя рядом с чек-боксом.
     *
     * @param manufacturerName Имя производителя, на чекбокс которого необходимо кликнуть
     * @see Waits#untilVisibilityOf(String)
     * @see Streams#findElementInListByExactName(String xpath, String findName)
     */
    public void selectManufacturer(String manufacturerName) {
        Streams.findElementInListByExactName(checkboxManufacturerList, manufacturerName).click();
        Waits.untilInvisibilityOf(loaderLocator);
    }

    public String getCheckboxManufacturerList() {
        return checkboxManufacturerList;
    }

    /**
     * После нескольких кликов на "Показать всё" и "Свернуть"
     * отображает весь список в фильтре "Производитель" в боковом меню.
     */
    public void showAllManufacturers() {
        CustomActions.click(showAllButtonLocator);
        CustomActions.click(rollUpButtonLocator);
        CustomActions.click(showAllButtonLocator);
        CustomActions.click(rollUpButtonLocator);
    }

    /**
     * Устанавливает количество показываемых товаров на каждую страницу
     * (Локатор этого элемента находиться в самом низу страницы)
     *
     * @see Waits#untilVisibilityOf(String xpath)
     * @see CustomActions#click(String xpath)
     * @see Waits#untilInvisibilityOf(String xpath)
     */
    public void setItemsPerPageShowBy12() {
        CustomActions.click(buttonShowByLocator);
        CustomActions.click(buttonShowBy12Locator);
        Waits.untilInvisibilityOf(loaderLocator);
    }

    /**
     * @return Локатор списка результатов
     */
    public String getSearchResultsNamesLocator() {
        return searchResultsNamesLocator;
    }

    /**
     * Вводит текст в поле "Искать товары" и кликает кнопку "Найти".
     *
     * @param text Текст, который необходимо ввести.
     * @see CustomActions#click(String xpath)
     * @see CustomActions#sendKeys(String xpath, String text)
     */
    public void putValueIntoSearchField(String text) {
        CustomActions.sendKeys(searchFieldLocator, text);
    }

    /**
     * Получает текст из поля "Искать товары"
     *
     * @return Возвращает текст, содержащийся в поле "Искать товары"
     */
    public String getTextFromSearchField() {
        Waits.untilPresenceOfElementLocated(searchFieldLocator);
        return CustomActions.getElementAttribute(searchFieldLocator, Constants.ATTRIBUTE_VALUE);
    }

    /**
     * @return Локатор кнопки "Найти"
     */
    public String getSearchButtonLocator() {
        return searchButtonLocator;
    }

    /**
     * Сохраняет первое значение из списка
     *
     * @see Streams#findFirstElementTextInList(String xpath)
     */
    public static void saveFirstValueFromList() {
        String searchResultsNamesLocator = "//div[@data-zone-name='SearchResults']/descendant::h3[@data-zone-name='title']/a/span";
        currentValue = Streams.findFirstElementTextInList(searchResultsNamesLocator);
    }

    public static String getCurrentValue() {
        return currentValue;
    }
}
