package test;

import api.integrationSubsystems.perfomance.PerfomanceApi;
import api.integrationSubsystems.perfomance.models.Cars;
import api.integrationSubsystems.perfomance.models.User;
import org.junit.jupiter.api.*;

import static io.qameta.allure.Allure.step;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Рест запросы")
public class RestTests {
    PerfomanceApi perfomanceApi = new PerfomanceApi();

    @Test
    @DisplayName("Проверка Рест запроса GET для получения списка Пользователей")
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
    @DisplayName("Проверка Рест запроса GET для получения списка автомобилей")
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
