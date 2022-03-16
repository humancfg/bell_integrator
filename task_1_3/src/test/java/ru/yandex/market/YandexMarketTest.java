package ru.yandex.market;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import steps.Steps;

import java.util.stream.Stream;

@DisplayName("Задание 1.3")
public class YandexMarketTest extends BaseTest {

    @ParameterizedTest(name = "{displayName}" + "{0}")
    @MethodSource("dataProviderFactory")
    @DisplayName("Проверка в Яндекс.")
    public void yandexMarketTest(String serviceName, String category, String subCategory,
                                 String minPrice, String maxPrice, String checkboxManufacturer1,
                                 String checkboxManufacturer2) {
        Steps.goPage("https://www.yandex.ru");
        Steps.goYandexService(serviceName);
        Steps.selectCategory(category);
        Steps.selectSubCategory(subCategory);
        Steps.setPrice(minPrice, maxPrice);
        Steps.selectManufacturer(checkboxManufacturer1, checkboxManufacturer2);
        Steps.waitsSearchResult();
        Steps.setElementsPerPageShowBy12();
        Steps.waitsUpdatedSearchResults();
        Steps.checkItemsSizeOnPage();
        Steps.saveFirstValueFromResultList();
        Steps.enterSavedValueIntoSearchField();
        Steps.clickFindButton();
        Steps.checksProductNameMatchSavedValue();
    }

    /**
     * @return Поток аргументов для параметров в тестовом методе
     */
    static Stream<Arguments> dataProviderFactory() {
        return Stream.of(
                Arguments.of("Маркет", "Компьютеры", "Ноутбуки", "10000", "90000", "HP", "Lenovo")
        );
    }
}
