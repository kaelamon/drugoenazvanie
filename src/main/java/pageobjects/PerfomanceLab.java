package pageobjects;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class PerfomanceLab {

    //картинка перфа
    public SelenideElement perfomanceLabImg() {
        return $x("//img[@alt='Перфоманс Лаб Logo']");
    }
    //Меню "Услуги"
    public SelenideElement hoverMenu() {
        return $(byId("menu-item-317"));
    }

    //элемент "Тестирование сайта"
    public SelenideElement hoverMenuWebTestingLink() {
        return $(byXpath("//a[@href='/website-testing']"), 1);
    }
    //Кнопка "узнать цену"
    public SelenideElement getAPrice() {
        return $(".elementor-3212");
    }

    //Цвет кнопки "узнать цену"
    public String getAPriceBackground() {
        return $x("//a[@href='#1']").getCssValue("background-color");
    }
    //элемент "Автоматизация тестирвоани" по линку
    public SelenideElement autoTestingLink() {
        return $(byXpath("//a[@href='https://www.performance-lab.ru/avtomatizacija-testirovanija']"), 1);
    }

    //элемент "Примеры выполненных проектов" найденый по тексту
    public SelenideElement workExamplesElement() {
        return $(byText("Примеры выполненных проектов"));
    }

    //Картинка под текстом "Примеры выполненных проектов"
    public SelenideElement lazyImg() {
        return $x("//img[@loading='lazy']");
    }
    //элемент окна обратногой связи З.Ы. когда он закрыт hubspot-modal-container меняет имя на hubspot-modal-container closed
    public SelenideElement hubspotElement() {

        return $(byClassName("hubspot-modal-container"));
    }
}
