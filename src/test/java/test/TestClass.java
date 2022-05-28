package test;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestClass {

    @AfterEach
    //после каждого теста, селенид будет закрывать окно, чтоб каждый тест на свежем вебдрайвере
    public void CloseWebDriver() {
        Selenide.closeWebDriver();
    }
    @Test
    public void GoogleSearchForPerfomanceLab() {
        open("https://www.google.ru"); // открываеть сайт
        $("input").shouldBe(visible).setValue("performance lab").pressEnter(); //пишем название сайта и жмыхаем энтер
        $(byText("https://www.performance-lab.ru")).shouldBe(visible).click(); //нахоим по тексту элемент и ждем когда он прогрузится
        switchTo().window(1); //переходим на новую вкладку которая открылась
        $x("//img[@alt='Перфоманс Лаб Logo']").shouldBe(visible); //сверяем что лого перфоманса на месте
    }
    @Test
    public void ServicesButtonIsBlue() {
        open("https://www.performance-lab.ru"); // открываеть сайт
        $(byId("menu-item-317")).shouldBe(visible);
        $(byId("menu-item-317")).hover();
        $(byXpath("//a[@href='/website-testing']"), 1).shouldBe(visible).click();
        switchTo().window(1);
        $(".elementor-3212").shouldBe(visible);
        String color = $x("//a[@href='#1']").getCssValue("background-color");
        assertEquals(color, "rgba(79, 173, 255, 1)"); //проверяем что по RGBA цвет соотвествует синему
    }

    @Test
    public void ScrollAndOpenForm(){
        open("https://www.performance-lab.ru");
        $(byId("menu-item-317")).shouldBe(visible);
        $(byId("menu-item-317")).hover();
        $(byXpath("//a[@href='https://www.performance-lab.ru/avtomatizacija-testirovanija']"), 1).shouldBe(visible).click();
        $(byText("Примеры выполненных проектов")).shouldBe(visible).scrollTo(); //скролим, тут нету свич ту, потому что переход происходит без открытия новой вкладки
        $x("//img[@loading='lazy']").click();
        $(byClassName("hubspot-modal-container")).shouldBe(visible); //оставил так, это единственный нормальный способ проверить
    }
}
