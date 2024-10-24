package org.example.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class RentPage {

    private WebDriver driver;

    public RentPage(WebDriver driver) {
        this.driver = driver;
    } //div[contains(@class, 'datepicker__day--selected')]

//локаторы
    private By timeWhen = By.xpath("//input[@placeholder='* Когда привезти самокат']");
    private By daySelected = By.xpath("//div[contains(@class, 'datepicker__day--selected')]");
    private By rentalPeriodDropdown = By.className("Dropdown-control");
    private By twoDaysPeriod = By.xpath("//div[text()='двое суток']");
    private By threeDaysPeriod = By.xpath("//div[text()='трое суток']");
    private By bikeBlackColour = By.xpath("//label[text()='чёрный жемчуг']");
    private By bikeGrayColour = By.xpath("//label[text()='серая безысходность']");
    private By orderButton = By.cssSelector(".Button_Button__ra12g.Button_Middle__1CSJM:nth-of-type(2)");
    private By yesButton = By.xpath("//button[text()='Да']");
    private By commentForСourier = By.xpath("//input[@placeholder='Комментарий для курьера']");

//метод для заполнения даты
    public void typeTimeWhen(String date) {
        driver.findElement(timeWhen).sendKeys(date);
    }

//метод для валидации выбранного дня
    public void clickDaySelected() {
        driver.findElement(daySelected).click();
    }

//метод для клика по дропдауну с выбором диапазона аренды
    public void clickRentalPeriodDropdown() {
        driver.findElement(rentalPeriodDropdown).click();
    }

//метод для клика по двухдневному периоду
    public void clickTwoDaysPeriod() {
        driver.findElement(twoDaysPeriod).click();
    }

//метод для клика по трехдневному периоду
    public void clickThreeDaysPeriod() {
        driver.findElement(threeDaysPeriod).click();
    }

//метод для выбора черного цвета
    public void chooseBlackColour()  {
        driver.findElement(bikeBlackColour).click();
    }

//метод для выбора серого цвета
    public void chooseGrayColour()  {
        driver.findElement(bikeGrayColour).click();
    }

//метод для ввода коммента для курьера
    public void typeCommentForCourier(String comment)  {
        driver.findElement(commentForСourier).sendKeys(comment);
    }

//метод для клика по кнопке заказать
    public void clickOrderButton() {
        driver.findElement(orderButton).click();
    }

//метод для клика по кнопке да
    public void clickYesButton() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(yesButton));
        driver.findElement(yesButton).click();
    }

//метод для получения текста в модальном окне
    public String textInModalHeader() {
        return driver.findElement(By.xpath("//div[contains(@class, 'Order_ModalHeader')]")).getText();
    }
}