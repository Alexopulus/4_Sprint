package tests;

import org.example.pageobject.MainPage;
import org.example.pageobject.OrderPage;
import org.example.pageobject.RentPage;
import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.containsString;

public class OrderFromHeaderButtonTest extends BaseUITest {

    @Test
    public void test() {
        MainPage objMainPage = new MainPage(driver);
        OrderPage objOrderPage = new OrderPage(driver);
        RentPage objRentPage = new RentPage(driver);

        objMainPage.openMainPage();

        objMainPage.clickCookieButton();

        objMainPage.clickOrderButtonHeader();

        String name = "Водопроводчик";
        objOrderPage.typeNameInput(name);

        String family = "Иванов";
        objOrderPage.typeFamilyInput(family);

        String address = "ул. Колотушкина, дом Пушкина";
        objOrderPage.typeAddressInput(address);

        String station = "Комсомольская";
        objOrderPage.choiceSubway(station);

        String phone = "+79102835765";
        objOrderPage.typePhoneInput(phone);

        objOrderPage.clickSubmitButton();

        String date = "23.10.2024";
        objRentPage.typeTimeWhen(date);

        objRentPage.clickDaySelected();

        objRentPage.clickRentalPeriodDropdown();

        objRentPage.clickThreeDaysPeriod();

        objRentPage.chooseBlackColour();

        String comment = "По кайфу";
        objRentPage.typeCommentForCourier(comment);

        objRentPage.clickOrderButton();

        objRentPage.clickYesButton();

        String actualText = objRentPage.textInModalHeader();
        String expectedText = "Заказ оформлен";

        Assert.assertThat(actualText, containsString(expectedText));

    }
}