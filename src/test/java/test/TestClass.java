package test;

import io.qameta.allure.*;
import org.junit.jupiter.api.*;


import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@Epic("Проверки без использования PageObjects")
@Feature("Проверки без использования PageObjects, для домашнего задания по Автоматизированным тестам")
public class TestClass extends BaseTest {

    @Test
    @DisplayName("Проверка нахождения сайта \"Перфоманс Лаб\" через гугл")
    @Story("Проверка нахождения сайта \"Перфоманс Лаб\" через гугл")
    @Description("Проверяем что сайт Перфоманс Лаб находится через поисковик гугл и при переходе проверяем что сайт открылся")
    public void googleSearchForPerformanceLab() {
        open("https://www.google.ru"); // открываеть сайт
        $("input").shouldBe(visible).setValue("performance lab").pressEnter(); //пишем название сайта и жмыхаем энтер
        $(byText("https://www.performance-lab.ru")).shouldBe(visible).click(); //нахоим по тексту элемент и ждем когда он прогрузится
        switchTo().window(1); //переходим на новую вкладку которая открылась
        $x("//img[@alt='Перфоманс Лаб Logo']").shouldBe(visible); //сверяем что лого перфоманса на месте
    }
    @Test
    @DisplayName("Проверка что кнопка \"Узнать Цену\" синяя")
    @Story("Проверка что кнопка \"Узнать Цену\" синяя")
    @Description("Проверяем что кнопка \"Узнать Цену\" синяя на странице \"Тестирование сайта\"")
    public void servicesButtonIsBlue() {
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
    @DisplayName("Проверка открытия окна \"Примеры выполненных проектов\"")
    @Story("Проверка открытия окна \"Примеры выполненных проектов\"")
    @Description("Проверка открытия окна \"Примеры выполненных проектов\" на странице \"Автоматизация тестирования\"")
    public void scrollAndOpenForm(){
        open("https://www.performance-lab.ru");
        $(byId("menu-item-317")).shouldBe(visible);
        $(byId("menu-item-317")).hover();
        $(byXpath("//a[@href='https://www.performance-lab.ru/avtomatizacija-testirovanija']"), 1).shouldBe(visible).click();
        $(byText("Примеры выполненных проектов")).shouldBe(visible).scrollTo(); //скролим, тут нету свич ту, потому что переход происходит без открытия новой вкладки
        $x("//img[@loading='lazy']").click();
        $(byClassName("hubspot-modal-container")).shouldBe(visible); //оставил так, это единственный нормальный способ проверить
    }
}
