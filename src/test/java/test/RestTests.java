package test;

import api.integrationSubsystems.perfomance.PerfomanceApi;
import api.integrationSubsystems.perfomance.models.User;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class RestTests {
    PerfomanceApi perfomanceApi = new PerfomanceApi();

    @Test
    void getUsersTest() {
        User[] users = perfomanceApi.getUsers()
                .then()
                .statusCode(200)
                .extract().response()
                .getBody()
                .as(User[].class);

        assertNotNull(users);

        assertTrue(users.length > 0);
    }
}
