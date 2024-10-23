package tests;

import org.example.pageobject.MainPage;
import org.example.pageobject.OrderPage;
import org.example.pageobject.RentPage;
import org.junit.Assert;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.containsString;

//Наследуемся от BaseUITest, там у нас есть before и after
public class OrderFromBodyButtonTest extends BaseUITest {

    @Test
    public void test() {
        MainPage objMainPage = new MainPage(driver);
        OrderPage objOrderPage = new OrderPage(driver);
        RentPage objRentPage = new RentPage(driver);

//открываем главную страницу
        objMainPage.openMainPage();
//кликаем по кнопке куки
        objMainPage.clickCookieButton();
//кликаем по кнопке куки кликаем по нижней кнопке Заказать
        objMainPage.clickOrderOrderButtonBody();

//Вводим данные пользователя
        String name = "Сантехник";
        objOrderPage.typeNameInput(name);

        String family = "Петров";
        objOrderPage.typeFamilyInput(family);

        String address = "ул. Пушкина, дом Колотушкина";
        objOrderPage.typeAddressInput(address);

        String station = "Сокольники";
        objOrderPage.choiceSubway(station);

        String phone = "+79040516472";
        objOrderPage.typePhoneInput(phone);

//кликаем по кнопке Далее
        objOrderPage.clickSubmitButton();

//Заполняем данные на странице Про аренду
        String date = "19.10.2024";
        objRentPage.typeTimeWhen(date);

        objRentPage.clickDaySelected();

        objRentPage.clickRentalPeriodDropdown();

        objRentPage.clickTwoDaysPeriod();

        objRentPage.chooseGrayColour();

        String comment = "Привет";
        objRentPage.typeCommentForCourier(comment);

//кликаем по кнопке Заказать
        objRentPage.clickOrderButton();


//кликаем по кнопке Да
        objRentPage.clickYesButton();

//Проверяем, что текст на финальном окне с заказом соответсвует ожидаемому по тексту "Заказ оформлен"
        String actualText = objRentPage.textInModalHeader();
        String expectedText = "Заказ оформлен";

        Assert.assertThat(actualText, containsString(expectedText));

    }
}