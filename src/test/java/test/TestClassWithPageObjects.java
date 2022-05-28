package test;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.*;
import pageobjects.PerfomanceLab;
import pageobjects.Search;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestClassWithPageObjects {
    public String PerfomanceLabLink = "https://www.performance-lab.ru";
    public String GooglePage = "https://www.google.ru";

   @AfterEach
    public void CloseWebDriver() {
       //после каждого теста, селенид будет закрывать окно, чтоб каждый тест на свежем вебдрайвере
        Selenide.closeWebDriver();
   }
    @Test
    public void GoogleSearchForPerfomanceLab() {
        Search search = new Search();
        PerfomanceLab perfomanceLab = new PerfomanceLab();

        open(GooglePage);
        search.findInput()
                .shouldBe(visible)
                .setValue("performance lab")
                .pressEnter();
        search.searchByText()
                .shouldBe(visible)
                .click();
        switchTo()
                .window(1);
        perfomanceLab.perfomanceLabImg()
                .shouldBe(visible);

    }
    @Test
    public void ServicesButtonIsBlue() {
        PerfomanceLab perfomanceLab = new PerfomanceLab();

        open(PerfomanceLabLink);
        perfomanceLab.hoverMenu()
                .shouldBe(visible);
        perfomanceLab.hoverMenu()
                .hover();
        perfomanceLab.hoverMenuWebTestingLink()
                .shouldBe(visible)
                .click();
        switchTo()
                .window(1);
        perfomanceLab.getAPrice()
                .shouldBe(visible);
        String errMessage = "Должно быть синим \"(rgba(79, 173, 255, 1)\", у вас " + perfomanceLab.getAPriceBackground();
        assertEquals(perfomanceLab.getAPriceBackground(), "rgba(79, 173, 255, 1)", errMessage);

    }

    @Test
    public void ScrollAndOpenForm(){
        PerfomanceLab perfomanceLab = new PerfomanceLab();

        open(PerfomanceLabLink);
        perfomanceLab.hoverMenu()
                .shouldBe(visible);
        perfomanceLab.hoverMenu()
                .hover();
        perfomanceLab.autoTestingLink()
                .shouldBe(visible)
                .click();
        perfomanceLab.workExamplesElement()
                .shouldBe(visible)
                .scrollTo();
        perfomanceLab.lazyImg()
                .click();
        perfomanceLab.hubspotElement()
                .shouldBe(visible);
    }
}
