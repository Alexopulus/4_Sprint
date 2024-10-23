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

    public void typeTimeWhen(String date) {
        driver.findElement(timeWhen).sendKeys(date);
    }

    public void clickDaySelected() {
        driver.findElement(daySelected).click();
    }

    public void clickRentalPeriodDropdown() {
        driver.findElement(rentalPeriodDropdown).click();
    }

    public void clickTwoDaysPeriod() {
        driver.findElement(twoDaysPeriod).click();
    }

    public void clickThreeDaysPeriod() {
        driver.findElement(threeDaysPeriod).click();
    }

    public void chooseBlackColour()  {
        driver.findElement(bikeBlackColour).click();
    }

    public void chooseGrayColour()  {
        driver.findElement(bikeGrayColour).click();
    }

    public void typeCommentForCourier(String comment)  {
        driver.findElement(commentForСourier).sendKeys(comment);
    }

    public void clickOrderButton() {
        driver.findElement(orderButton).click();
    }

    public void clickYesButton() {
        new WebDriverWait(driver, Duration.ofSeconds(4))
                .until(ExpectedConditions.visibilityOfElementLocated(yesButton));
        driver.findElement(yesButton).click();
    }

    public String textInModalHeader() {
        return driver.findElement(By.xpath("//div[contains(@class, 'Order_ModalHeader')]")).getText();
    }
}