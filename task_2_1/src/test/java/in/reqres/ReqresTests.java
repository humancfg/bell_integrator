package in.reqres;

import in.reqres.dto.*;
import in.reqres.utils.CustomAsserts;
import in.reqres.utils.CustomCollections;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import props.TestData;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static in.reqres.specifications.Specification.installAllSpec;
import static io.restassured.RestAssured.given;

public class ReqresTests {

    /**
     * Отображает логи в Allure, а так же в консоль
     */
    @BeforeTest
    public void beforeTest() {
        RestAssured.filters(new AllureRestAssured());
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
        RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
    }

    @Test(testName = "Убедиться, что имена файлов аватаров пользователей не уникальны")
    public void uniqueAvatarNamesTest() {
        installAllSpec(200);
        String endpoint = TestData.endpoint.usersSecondPage();
        UserDataListResponse userDataListResponse = given()
                .when()
                .get(endpoint)
                .then()
                .extract().body().as(UserDataListResponse.class);
        List<UserDataResponse> usersAvatars = userDataListResponse.getUserDataResponseList();
        List<String> usersAvatarNames = CustomCollections.getOnlyAvatarNames(usersAvatars);
        Set<String> unique = new HashSet<>(usersAvatarNames);
        CustomAsserts.assertNotEquals(usersAvatarNames.size(), unique.size(), "Все имена автаров уникальны");
    }

    /**
     * Задание 2.2
     * 1. Используя сервис https://reqres.in/ протестировать авторизацию пользователя в системе.
     * 2. Необходимо создание двух тестов на успешный логи и логин с ошибкой из-за не введённого пароля
     */
    @Test(testName = "Проверка успешной авторизации с логином и паролем")
    public void authFullTest() {
        installAllSpec(200);
        UserAuthRequest userFullData = new UserAuthRequest("tobias.funke@reqres.in", "pistol");
        String endpoint = TestData.endpoint.login();
        UserAuthResponse authResponse =
                given()
                        .body(userFullData)
                        .when()
                        .post(endpoint)
                        .then()
                        .extract()
                        .as(UserAuthResponse.class);
        String token = authResponse.getToken();
        CustomAsserts.assertTrue(token != null, "Токен присвоен");
    }

    @Test(testName = "Проверка не успешной авторизации без пароля")
    public void authWithoutPassTest() {
        installAllSpec(400);
        UserAuthRequest userWithoutPass = new UserAuthRequest("tobias.funke@reqres.in");
        String endpoint = TestData.endpoint.login();
        ErrorUserAuthResponse errorResponse = given()
                .body(userWithoutPass)
                .when()
                .post(endpoint)
                .then()
                .extract().as(ErrorUserAuthResponse.class);
        String error = errorResponse.getError();
        String expected = "Missing password";
        CustomAsserts.assertTrue(error.equals(expected),
                "В теле ответа в поле 'message' сообщение '" + expected + "'");
    }


    /**
     * Задание 2.3
     * Используя сервис https://reqres.in/ убедится что операция LIST \<RESOURCE\> возвращает
     * данные отсортированные по годам
     */
    @Test(testName = "Убедиться, что данные отсортированы по годам")
    public void sortYearsTest() {
        installAllSpec(200);
        String endpoint = TestData.endpoint.unknown();
        UserDataResourceListResponse usersResources = given()
                .when()
                .get(endpoint)
                .then()
                .extract()
                .body()
                .as(UserDataResourceListResponse.class);
        List<UserDataResourceResponse> years = usersResources.getUserDataResponseList();
        List<Integer> actual = CustomCollections.saveYears(years);
        List<Integer> expected = CustomCollections.saveSortedYears(years);
        CustomAsserts.assertTrue(actual.equals(expected), "Данные отсортированы по годам");
    }
}
