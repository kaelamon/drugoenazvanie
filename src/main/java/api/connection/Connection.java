package api.connection;

import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class Connection {

    private String baseURI = "http://77.50.236.203:4880";

    public RequestSpecification getSpecification(){
        return given().baseUri(baseURI).when();
    }
}
