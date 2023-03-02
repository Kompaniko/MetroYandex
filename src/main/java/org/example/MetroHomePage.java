package org.example;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static java.time.Duration.ofSeconds;


public class MetroHomePage {

    // локатор кнопки выпадающего списка городов по имени класса
    @FindBy(how = How.CLASS_NAME, using = "select_metro__button")
    private SelenideElement selectCityButton;

    // локатор поля ввода "Откуда" по XPath, поиск по плейсхолдеру
    @FindBy(how = How.XPATH, using = ".//input[@placeholder='Откуда']")
    private SelenideElement fieldFrom;
    // локатор поля ввода "Куда" по XPath, поиск по плейсхолдеру
    @FindBy(how = How.XPATH, using = ".//input[@placeholder='Куда']" )
    private SelenideElement fieldTo;

    // локатор коллеций станций "откуда" и "куда" маршрута по имени класса
    @FindBy(how = How.CLASS_NAME, using = "route-details-block__terminal-station")
    private ElementsCollection routeStationFromTo;

    // метод ожидания загрузки страницы: проверка видимости станции "театральная"
    public void waitForLoadHomePage() {
        // находим элемент по тексу, добавляем ожидание 8 секунд

        $(byText("Театральная")).shouldBe(visible,ofSeconds(8));
    }

    // метод выбора города по названию
    public void chooseCity(String cityName){
        selectCityButton.click();
        // выбор нужного города
            $(byText(cityName)).click();
    }

    // метод ввода названия станции в поле "Откуда"
    public void setStationFrom(String stationFrom) {
        // ввод названия станции в поле ввода, затем с помощью клавищ "Вниз" и enter выбрали его в выпадающем списке
        fieldFrom.setValue(stationFrom).sendKeys(Keys.DOWN, Keys.ENTER);
    }
    // метод ожидания построения маршрута: проверяется видимость кнопки "Получить ссылку на маршрут"
    public void waitForLoadRoute(){
        // ищем веб-элемент по тексту
        $( byText("Получить ссылку на маршрут")).shouldBe(visible);
    }


}