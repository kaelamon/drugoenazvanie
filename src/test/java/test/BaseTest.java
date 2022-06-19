package test;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;

import java.util.Properties;

public class BaseTest {
    Properties properties = new Properties();
    protected String googlePage = properties.getProperty("addresses.google");
    protected String performanceLabLink = properties.getProperty("addresses.performance");

    private static final String ALLURE_SELENIDE_LISTENER_NAME = "AllureSelenide";

    static {
        SelenideLogger.addListener(ALLURE_SELENIDE_LISTENER_NAME, new AllureSelenide()
                .screenshots(true).savePageSource(false));
    }

    @AfterEach
    public void tearDown() {
        //после каждого теста, селенид будет закрывать окно, чтоб каждый тест на свежем вебдрайвере
        Selenide.closeWindow();
    }
}
