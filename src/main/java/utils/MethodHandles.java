package utils;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MethodHandles {

    protected WebDriver driver;
    WebDriverWait wait;
    Actions actions;


    public MethodHandles(WebDriver driver){
        this.driver = driver;
    }

    protected WebElement webElement(By locator){
        return driver.findElement(locator);
    }

    protected void explicitWait(By locator, int time){
        wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        wait.until(ExpectedConditions.and(
                ExpectedConditions.visibilityOf(webElement(locator)),
                ExpectedConditions.presenceOfElementLocated(locator),
                ExpectedConditions.visibilityOfElementLocated(locator),
                ExpectedConditions.elementToBeClickable(locator)
        ));
    }

    protected void scrollIntoView(WebDriver driver, WebElement element) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    protected void click(By locator,int time){
        explicitWait(locator,time);
        webElement(locator).click();
    }
    protected void sendKeys(By locator, String text) {
        explicitWait(locator, 20);
        webElement(locator).sendKeys(text);
    }
    protected String getText(By locator){
        explicitWait(locator,20);
        return webElement(locator).getText();
    }

    protected boolean isDisplayed(By locator, int time){
        explicitWait(locator,time);
        return webElement(locator).isDisplayed();
    }









}
