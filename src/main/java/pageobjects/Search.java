package pageobjects;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class Search {

    public SelenideElement findInput() {
        return $("input");
    }
    public SelenideElement searchByText(){
        return $x("//h3[contains(text(),'Перфоманс Лаб')]");
    }

}
