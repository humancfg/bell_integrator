package pages.ru.yandex;

import io.qameta.allure.Step;
import utils.CustomAssertions;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;

public abstract class YandexBasePage {

    @Step("Зайти на {url}")
    public static <T extends YandexBasePage> T openUrl(String url, Class<T> pageObjectClass) {
        open(url, pageObjectClass);
        CustomAssertions.assertTrue(url.equals("https://www.yandex.ru/"), "Адрес не соответствует " + url);
        return pageObjectClass.cast(page(pageObjectClass));
    }
}
