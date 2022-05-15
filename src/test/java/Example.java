import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class Example {
    public static void main(String[] args) {

    }
    @Test
    public void GoogleSearchForPerfomanceLab() {
        open("https://www.google.ru"); // открываеть сайт
        $("input").shouldBe(visible); //на вс€кий случай ждем прогрузки
        $("input").setValue("performance lab").pressEnter(); //пишем название сайта и жмыхаем энтер
        $(byText("https://www.performance-lab.ru")).shouldBe(visible).click(); //нахоим по тексту элемент и ждем когда он прогрузитс€
        switchTo().window(1); //переходим на новую вкладку котора€ открылась
        $x("//img[@alt='ѕерфоманс Ћаб Logo']").shouldBe(visible); //свер€ем что лого перфоманса на месте
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
        assertEquals(color, "rgba(79, 173, 255, 1)"); //провер€ем что по RGBA цвет соотвествует синему
    }

    @Test
    public void ScrollAndOpenForm(){
        open("https://www.performance-lab.ru");
        $(byId("menu-item-317")).shouldBe(visible);
        $(byId("menu-item-317")).hover();
        $(byXpath("//a[@href='https://www.performance-lab.ru/avtomatizacija-testirovanija']"), 1).shouldBe(visible).click();
        $(byText("ѕримеры выполненных проектов")).shouldBe(visible).scrollTo(); //скролим, тут нету свич ту, потому что переход происходит без открыти€ новой вкладки
        $x("//img[@loading='lazy']").click();
        $(byClassName("hubspot-modal-container")).shouldBe(visible);
        sleep(5000); //на вс€кий случай проверить чтоб точно открылась
    }
}
