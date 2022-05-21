package pageobjects;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.*;

public class SearchSite {
    public String GooglePage = "https://www.google.ru";
    public String PerfomanceLabLink = "https://www.performance-lab.ru";

    public SelenideElement findInput() {
        return $("input");
    }

}
