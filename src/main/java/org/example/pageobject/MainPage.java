package org.example.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class MainPage {

    private WebDriver driver;

    public static String MAIN_PAGE_URL = "https://qa-scooter.praktikum-services.ru/";

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public MainPage openMainPage() {
        driver.get(MAIN_PAGE_URL);
        return this;
    }

//Локаторы на главной странице
    private By faqOpenAnswers = By.xpath(".//div[@class='accordion__panel' and not(@hidden)]");
    private By orderButtonHeader = By.className("Button_Button__ra12g");
    private By cookieButton = By.id("rcc-confirm-button");

//Метод кликает по кнопке Заказать в хедере главной страницы
    public void clickOrderButtonHeader() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(orderButtonHeader));
        driver.findElement(orderButtonHeader).click();
    }

//Метод кликает по кнопке Заказать в теле главной страницы
    public void clickOrderOrderButtonBody() {
        WebElement orderButtonBody = driver.findElement(By.xpath("(//button[contains(text(), 'Заказать')])[2]"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", orderButtonBody);
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOf(orderButtonBody));
        orderButtonBody.click();
    }

//Метод кликает по кукибаттону
    public void clickCookieButton() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(cookieButton));
        driver.findElement(cookieButton).click();
    }

//Метод реализует скролл до элемента
    public void scrollToElement(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
    }

//Метод для элемента вопроса
    public WebElement checkFaqQuestion(String questionText) {
        By questionLocator = By.xpath(String.format("//div[@aria-expanded and text()='%s']", questionText));
        return new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(questionLocator));
    }

//Метод для элемента ответа
    public WebElement checkFaqAnswer() {
        return new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(faqOpenAnswers));
    }
}
