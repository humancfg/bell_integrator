package pages.ru.yandex;

import io.qameta.allure.Step;
import props.TestData;
import utils.CustomAssertions;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;

public abstract class YandexBasePage {

    @Step("Зайти на yandex.ru")
    public static <T extends YandexBasePage> T openYandexUrl(Class<T> pageObjectClass) {
        String url = TestData.propsUrl.baseUrlYandex();
        open(url, pageObjectClass);
        CustomAssertions.assertTrue(url.equals("https://www.yandex.ru/"), "Адрес не соответствует " + url);
        return pageObjectClass.cast(page(pageObjectClass));
    }
}
