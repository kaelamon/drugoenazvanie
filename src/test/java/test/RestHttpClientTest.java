package test;



import api.integrationSubsystems.perfomance.models.Cars;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.impl.classic.*;
import org.apache.hc.core5.http.HttpResponse;
import org.apache.hc.core5.http.io.entity.EntityUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;


@Epic("apache Http Client тесты")
@Feature("Тесты api по средством apache Http Client")
public class RestHttpClientTest {

        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpGet httpget = new HttpGet("http://77.50.236.203:4880/cars");

    @Test
    void exampleTest() throws Exception {

        HttpResponse httpresponse = httpclient.execute(httpget);
        String content = EntityUtils.toString(((CloseableHttpResponse) httpresponse).getEntity());
        ObjectMapper objectMapper = new ObjectMapper();
        Cars[] cars = objectMapper.readValue(content, Cars[].class);

        step("Проверим что массив Cars не пустой", () -> {assertNotNull(cars);});

        step("Проверим что массив Cars имеет что-то в себе", () -> {assertTrue(cars.length > 0);});

    }

}
