package pages.ru.yandex.market;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import pages.ru.yandex.YandexBasePage;
import utils.CustomAssertions;
import utils.Streams;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$$x;

public class YandexMarketMainPage extends YandexBasePage {
    private ElementsCollection categories = $$x("//li[@data-zone-name='category-link']/a/span");
    private ElementsCollection subCategories = $$x("//div[@data-zone-name='link']");
    private SelenideElement catalogButton =  $x("//span[contains(text(), 'Каталог')]/ancestor::button");

    @Step("Выбрать раздел {categoryName}")
    public YandexMarketMainPage selectCategory(String categoryName) {
        clickCategoryButton();
        categories.shouldHave(CollectionCondition.sizeGreaterThan(5));
        boolean flag = Streams.anyMatchElement(categories, categoryName);
        CustomAssertions.assertTrue(flag, "Невозможно выбрать категорию " + categoryName);
        categories.find(exactText(categoryName)).hover();
        return this;
    }

    @Step("Выбрать раздел {subCategoryName}")
    public CatalogSmartphones selectSubCategory(String subCategoryName) {
        subCategories.shouldHave(CollectionCondition.sizeGreaterThan(5));
        boolean flag = Streams.anyMatchElement(subCategories, subCategoryName);
        CustomAssertions.assertTrue(flag, "Невозможно выбрать подкатегорию" + subCategoryName);
        subCategories.find(exactText(subCategoryName)).click();
        return page(CatalogSmartphones.class);
    }

    private void clickCategoryButton() {
        CustomAssertions.assertTrue(catalogButton.is(visible), "Кнопка 'Каталог' не доступна");
        CustomAssertions.assertTrue(catalogButton.getText().equals("Каталог"), "Название кнопки не 'Каталог'");
        catalogButton.click();
    }
}
