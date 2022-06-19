package test;

import io.qameta.allure.*;
import org.junit.jupiter.api.*;
import pageobjects.PerfomanceLab;
import pageobjects.Search;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.*;
import static org.junit.jupiter.api.Assertions.*;

@Epic("Проверки с использованием PageObjects")
@Feature("Проверки с использованием PageObjects, для домашнего задания по Автоматизированным тестам")
public class TestClassWithPageObjects extends BaseTest {


    @Test
    @DisplayName("Проверка нахождения сайта \"Перфоманс Лаб\" через гугл")
    @Story("Проверка нахождения сайта \"Перфоманс Лаб\" через гугл")
    @Description("Проверяем что сайт Перфоманс Лаб находится через поисковик гугл и при переходе проверяем что сайт открылся")
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
    @Story("Проверка что кнопка \"Узнать Цену\" синяя")
    @Description("Проверяем что кнопка \"Узнать Цену\" синяя на странице \"Тестирование сайта\"")
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
        step("Проверяем что кнопка синяя", () -> {
            assertEquals(perfomanceLab.getAPriceBackground(), "rgba(79, 173, 255, 1)");});
    }

    @Test
    @DisplayName("Проверка что кнопка \"Узнать Цену\" красная")
    @Story("Проверка что кнопка \"Узнать Цену\" красная")
    @Description("Негативный кейс! Проверяем что кнопка \"Узнать Цену\" крассная на странице \"Тестирование сайта\"")
    public void servicesButtonIsRed() {
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
        step("Проверяем что кнопка красная", () -> {
            assertEquals(perfomanceLab.getAPriceBackground(), "rgba(255, 0, 0, 1)");});
    }

    @Test
    @DisplayName("Проверка открытия окна \"Примеры выполненных проектов\"")
    @Story("Проверка открытия окна \"Примеры выполненных проектов\"")
    @Description("Проверка открытия окна \"Примеры выполненных проектов\" на странице \"Автоматизация тестирования\"")
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
