package pageobject.ru.yandex.market;

import utils.CustomActions;
import utils.Streams;
import utils.Waits;

/**
 * Page Object главной страницы Яндекс.Маркет
 */
public class YandexMarketMainPage {
    private String categoryItemsLocator = "//li[@data-zone-name='category-link']";
    private String subCategoryItemsLocator = "//div[@data-zone-name='link']";
    private String catalogButtonLocator = "//span[contains(text(), 'Каталог')]/ancestor::button";

    /**
     * Вызывает список категорий при нажатии кнопку "Каталог"
     * и наводит курсор мыши на категорию
     *
     * @param categoryName Имя категории, на которую нужно навести курсор
     * @see CustomActions#click(String xpath)
     * @see Waits#untilVisibilityOfAllElements(String xpath)
     * @see CustomActions#hover
     * @see Streams#findElementInListByExactName(String xpath, String findName)
     */
    public void selectCategory(String categoryName) {
        CustomActions.click(catalogButtonLocator);
        Waits.untilVisibilityOfAllElements(categoryItemsLocator);
        CustomActions.hover(Streams.findElementInListByExactName(categoryItemsLocator, categoryName));
    }

    /**
     * Кликает на выбранную подкатегорию
     *
     * @param subCategoryName Имя подкатегории, на которую необходимо кликнуть
     * @see Waits#untilVisibilityOfAllElements(String xpath)
     * @see Streams#findElementInListByExactName(String xpath, String findName)
     */
    public void selectSubCategory(String subCategoryName) {
        Waits.untilVisibilityOfAllElements(subCategoryItemsLocator);
        Streams.findElementInListByExactName(subCategoryItemsLocator, subCategoryName).click();
    }
}
