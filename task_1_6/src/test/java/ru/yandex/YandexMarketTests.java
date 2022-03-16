package ru.yandex;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import pages.ru.yandex.YandexBasePage;
import pages.ru.yandex.YandexMainPage;
import props.TestData;

public class YandexMarketTests extends BaseTests {

    @ParameterizedTest(name = "{displayName}" + ".{2}" + ".{3}")
    @MethodSource("utils.TestData#dataProviderFactory")
    @DisplayName("Проверка в Яндекс.Маркет")
    public void yandexMarketTest(String serviceName, String category, String subcategory, String manufacturer, String contains) {
        YandexBasePage.openUrl(TestData.propsUrl.baseUrlYandex(),YandexMainPage.class)
                .goYandexService(serviceName)
                .selectCategory(category)
                .selectSubCategory(subcategory)
                .selectManufacturer(manufacturer)
                .waitsSearchResult()
                .setItemsPerPageShowBy12()
                .checksSearchResultsNames(contains);
    }
}

