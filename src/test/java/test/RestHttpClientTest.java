package test;



import api.integrationSubsystems.perfomance.models.Cars;
import api.integrationSubsystems.perfomance.models.User;
import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.impl.classic.*;
import org.apache.hc.core5.http.HttpResponse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Scanner;


@DisplayName("Рест запросы через Apache HTTP")
public class RestHttpClientTest {
    @Test
    void exampleTest() throws Exception {

        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpGet httpget = new HttpGet("http://77.50.236.203:4880/cars");
        System.out.println("Request Type: "+httpget.getMethod());
        HttpResponse httpresponse = httpclient.execute(httpget);
        Scanner sc = new Scanner(((CloseableHttpResponse) httpresponse).getEntity().getContent());

        //System.out.println(httpresponse.getStatusLine());
        while(sc.hasNext()) {
            System.out.println(sc.nextLine());
        }

    }

}
