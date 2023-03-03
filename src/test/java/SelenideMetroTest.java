import com.codeborne.selenide.CollectionCondition;
import org.example.MetroHomePage;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

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

    //  проверка отображения времени маршрута
   @Test
    public void checkRouteApproxTimeIsDisplay()  {
        // открытие браузера и переход на страницу стенда
        // инициализация класса
        MetroHomePage metroPage = open("https://qa-metro.stand-2.praktikum-services.ru/",
                MetroHomePage.class);
        // ожидание загрузки страницы
        metroPage.waitForLoadHomePage();
       // выбрали Санкт-Петербург в списке городов
       metroPage.chooseCity("Санкт-Петербург");
        // постройка маршрута от "Невский проспект" до "Улица Дыбенко"
        metroPage.buildRoute("Невский проспект", "Петроградская");
        // проверка, что отображается корректное название станции начала маршрута
       $$(byXpath("/html/body/div[3]/div/ul[2]/li/span[2]")).shouldHave(CollectionCondition.itemWithText("≈ 6 мин."));
    }
}
