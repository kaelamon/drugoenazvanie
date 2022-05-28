package api.integrationSubsystems.perfomance;

import api.connection.Connection;
import io.restassured.response.Validatable;

public class PerfomanceApi {
    Connection connection = new Connection();

    public Validatable getUsers() {
        return connection.getSpecification().log().all().get("/users");
    }
}
