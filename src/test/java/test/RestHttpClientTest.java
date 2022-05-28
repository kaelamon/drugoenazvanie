package test;

import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.cookie.BasicCookieStore;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.client5.http.impl.io.PoolingHttpClientConnectionManagerBuilder;
import org.apache.hc.core5.http.ClassicHttpRequest;
import org.apache.http.conn.HttpClientConnectionManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.io.IOException;

import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;


public class RestHttpClientTest {

//    @Test
////    void apacheClientTest() throws NoSuchAlgorithmException, KeyStoreException, KeyManagementException, IOException {
////        HttpClientConnectionManager connectionManager = PoolingHttpClientConnectionManagerBuilder.create()
////                .build();
////
////        HttpClient client = HttpClients.custom()
////                .setConnectionManager(connectionManager)
////                .disableRedirectHandling()
////                .setDefaultCookieStore(new BasicCookieStore())
////                .build();
////
////        ClassicHttpRequest request = new HttpGet("http://77.50.236.203:4880/users");
////
////        HttpResponse response = ((CloseableHttpClient) client).execute(request);
////
////        Assertions.assertEquals(200, ((CloseableHttpResponse) response).getCode());
////        }
}
