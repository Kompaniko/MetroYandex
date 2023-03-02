import org.example.MetroHomePage;
import org.junit.Test;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;


public class SelenideMetroTest {

    @Test
    public void checkChooseCityDropdown(){
        // открытие браузера и переход на страницу стенда
        // инициализация класса
        MetroHomePage metroPage = open("https://qa-metro.stand-2.praktikum-services.ru/",
                MetroHomePage.class);
        // ожидание загрузки страницы
        metroPage.waitForLoadHomePage();
        // выбрали Санкт-Петербург в списке городов
        metroPage.chooseCity("Санкт-Петербург");
        //  проверка что видна станция "Невский Проспект"
        $(byText("Невский проспект")).shouldBe(visible);
        //.shouldBe(visible)" -
        // это метод Selenide, который проверяет, что найденный элемент видимый (отображается на экране).
    }

}
