package test;

import org.junit.jupiter.api.Test;
import pageobjects.PerfomanceLabSite;
import pageobjects.SearchSite;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestClassWithPageObjects {

    @Test
    public void GoogleSearchForPerfomanceLab() {
        SearchSite searchSite = new SearchSite();
        PerfomanceLabSite perfomanceLabSite = new PerfomanceLabSite();

        open(searchSite.GooglePage);
        searchSite.findInput()
                .shouldBe(visible)
                .setValue("performance lab")
                .pressEnter();
        $(byText(searchSite.PerfomanceLabLink))
                .shouldBe(visible)
                .click();
        switchTo()
                .window(1);
        perfomanceLabSite.perfomanceLabImg()
                .shouldBe(visible);
    }
    @Test
    public void ServicesButtonIsBlue() {
        PerfomanceLabSite perfomanceLabSite = new PerfomanceLabSite();

        open(perfomanceLabSite.PerfomanceLabLink);
        perfomanceLabSite.hoverMenu()
                .shouldBe(visible);
        perfomanceLabSite.hoverMenu()
                .hover();
        perfomanceLabSite.hoverMenuWebTestingLink()
                .shouldBe(visible)
                .click();
        switchTo()
                .window(1);
        perfomanceLabSite.getAPrice()
                .shouldBe(visible);
        assertEquals(perfomanceLabSite.getAPriceBackground(), "rgba(79, 173, 255, 1)");
    }

    @Test
    public void ScrollAndOpenForm(){
        PerfomanceLabSite perfomanceLabSite = new PerfomanceLabSite();

        open(perfomanceLabSite.PerfomanceLabLink);
        perfomanceLabSite.hoverMenu()
                .shouldBe(visible);
        perfomanceLabSite.hoverMenu()
                .hover();
        perfomanceLabSite.autoTestingLink()
                .shouldBe(visible)
                .click();
        perfomanceLabSite.workExamplesElement()
                .shouldBe(visible)
                .scrollTo();
        perfomanceLabSite.lazyImg()
                .click();
        perfomanceLabSite.hubspotElement()
                .shouldBe(visible);
    }
}
