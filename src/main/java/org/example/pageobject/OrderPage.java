package org.example.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class OrderPage {

    private WebDriver driver;

    public OrderPage(WebDriver driver) {
        this.driver = driver;
    }

//Локаторы
    private By nameInput = By.xpath("//input[@placeholder='* Имя']");
    private By familyInput = By.xpath(("//input[@placeholder='* Фамилия']"));
    private By addressInput = By.xpath("//input[@placeholder='* Адрес: куда привезти заказ']");
    private By subwayInput = By.xpath("//input[@placeholder='* Станция метро']");
    private By phoneInput = By.xpath("//input[@placeholder='* Телефон: на него позвонит курьер']");
    private By submitButton = By.xpath("//button[text()='Далее']");

//Метод для ввода имени
    public void typeNameInput(String name) {
        driver.findElement(nameInput).sendKeys(name);
    }
//Метод для ввода фамилии
    public void typeFamilyInput(String family) {
        driver.findElement(familyInput).sendKeys(family);
    }
//Метод для ввода адреса
    public void typeAddressInput(String address) {
        driver.findElement(addressInput).sendKeys(address);
    }
//Метод для выбора станции метро
    public void choiceSubway(String station) {
        driver.findElement(subwayInput).sendKeys(station, Keys.ARROW_DOWN, Keys.ENTER);
    }
//Метод для ввода номера телефона
    public void typePhoneInput(String phone) {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(phoneInput));
        driver.findElement(phoneInput).sendKeys(phone);
    }
//Метод для кнопки далее
    public void clickSubmitButton() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(submitButton));
        driver.findElement(submitButton).click();
    }
}
