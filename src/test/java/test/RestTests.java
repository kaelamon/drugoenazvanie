package test;

import api.integrationSubsystems.perfomance.PerfomanceApi;
import api.integrationSubsystems.perfomance.models.Cars;
import api.integrationSubsystems.perfomance.models.User;
import io.qameta.allure.*;
import org.junit.jupiter.api.*;

import static io.qameta.allure.Allure.step;
import static org.junit.jupiter.api.Assertions.*;

@Epic("Rest Assured тесты")
@Feature("Тесты api по средством Rest Assured")
public class RestTests {
    PerfomanceApi perfomanceApi = new PerfomanceApi();

    @Test
    @Story("Проверка Рест запроса GET для получения списка пользователей")
    @Description("Проверка Рест запроса GET для получения списка пользователей")
    void getUsersTest() {
        User[] users = perfomanceApi.getUsers()
                .then()
                .statusCode(200)
                .extract().response()
                .getBody()
                .as(User[].class);

        step("Проверим что массив User не пустой", () -> {assertNotNull(users);});

        step("Проверим что массив User имеет что-то в себе", () -> {assertTrue(users.length > 0);});

    }

    @Test
    @Story("Проверка Рест запроса GET для получения списка автомобилей")
    @Description("Проверка Рест запроса GET для получения списка автомобилей")
    void getCarsTest() {
        Cars[] cars = perfomanceApi.getCars()
                .then()
                .statusCode(200)
                .extract().response()
                .getBody()
                .as(Cars[].class);

        step("Проверим что массив Cars не пустой", () -> {assertNotNull(cars);});

        step("Проверим что массив Cars имеет что-то в себе", () -> {assertTrue(cars.length > 0);});
    }
}
