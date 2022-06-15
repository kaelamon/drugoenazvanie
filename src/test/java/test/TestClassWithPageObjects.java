package test;

import org.junit.jupiter.api.*;
import pageobjects.PerfomanceLab;
import pageobjects.Search;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.*;
import static org.junit.jupiter.api.Assertions.assertEquals;


@DisplayName("Проверки с использованием PageObjects")
public class TestClassWithPageObjects {
    public String performanceLabLink = "https://www.performance-lab.ru";
    public String googlePage = "https://www.google.ru";

   @AfterEach
    public void closeWebDriver() {
       //после каждого теста, селенид будет закрывать окно, чтоб каждый тест на свежем вебдрайвере
        closeWebDriver();
   }
    @Test
    @DisplayName("Проверка нахождения сайта \"Перфоманс Лаб\" через гугл")
    public void googleSearchForPerformanceLab() {
        Search search = new Search();
        PerfomanceLab perfomanceLab = new PerfomanceLab();

        step("Открываем страницу гугла", () -> {open(googlePage);});
        step("Вводим \"performance lab\" и нажимаем кнопку Enter", () -> {
            search.findInput()
                .shouldBe(visible)
                .setValue("performance lab")
                .pressEnter();});
        step("Ищем текст \"Перфоманс Лаб\"", () -> {
            search.searchByText()
                .shouldBe(visible)
                .click();});
        step("Переключаемся на новую вкладку", () -> {
            switchTo()
                    .window(1);});
        step("Проверяем что картинка \"Перфоманс Лаб\" на главной странице видна", () -> {
            perfomanceLab.perfomanceLabImg()
                .shouldBe(visible);});
    }
    @Test
    @DisplayName("Проверка что кнопка \"Узнать Цену\" синяя")
    public void servicesButtonIsBlue() {
        PerfomanceLab perfomanceLab = new PerfomanceLab();

        step("Открываем сайт \"Перфоманс Лаб\"", () -> {open(performanceLabLink);});
        step("Проверяем видимость кнопки \"Услуги\"", () -> {
            perfomanceLab.hoverMenu()
                .shouldBe(visible);});
        step("Наводимся на кнопку \"Услуги\"", () -> {
            perfomanceLab.hoverMenu()
                .hover();});
        step("Нажимаем на кнопку \"Тестирование сайта\"", () -> {
            perfomanceLab.hoverMenuWebTestingLink()
                .shouldBe(visible)
                .click();});
        step("Переключаемся на новую вкладку", () -> {
            switchTo()
                .window(1);});
        step("Проверка что кнопка \"Узнать цену\" отображается", () -> {
            perfomanceLab.getAPrice()
                .shouldBe(visible);});
        String errMessage = "Должно быть синим \"(rgba(79, 173, 255, 1)\", у вас " + perfomanceLab.getAPriceBackground();
        step("Проверяем что кнопка синяя", () -> {
            assertEquals(perfomanceLab.getAPriceBackground(), "rgba(79, 173, 255, 1)", errMessage);});
    }

    @Test
    @DisplayName("Проверка открытия окна \"Примеры выполненных проектов\"")
    public void scrollAndOpenForm(){
        PerfomanceLab perfomanceLab = new PerfomanceLab();

        step("Открываем сайт \"Перфоманс Лаб\"", () -> {open(performanceLabLink);});
        step("Проверяем видимость кнопки \"Услуги\"", () -> {
            perfomanceLab.hoverMenu()
                    .shouldBe(visible);});
        step("Наводимся на кнопку \"Услуги\"", () -> {
            perfomanceLab.hoverMenu()
                    .hover();});
        step("Нажимаем на кнопку \"Автоматизация тестирования\"", () -> {
            perfomanceLab.autoTestingLink()
                    .shouldBe(visible)
                    .click();
        });
        step("Скролим до текста \"Примеры выполненных проектов\"", () -> {
            perfomanceLab.workExamplesElement()
                    .shouldBe(visible)
                    .scrollTo();
        });
        step("Нажимаем на кнопку \"Примеры выполненных проектов\"", () -> {
            perfomanceLab.lazyImg()
                    .click();
        });
        step("Проверяем что окно обратной связи открылось", () -> {
            perfomanceLab.hubspotElement()
                    .should(exist);
        });


    }
}
