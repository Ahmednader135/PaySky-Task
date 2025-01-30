package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.MethodHandles;

import java.time.Duration;


public class CheckoutPage extends MethodHandles {
    Select select;
    public CheckoutPage(WebDriver driver) {
        super(driver);
    }


    private final By proceedToCheckoutButton = By.xpath("//button[@data-test='proceed-1']");

    private final By proceedToCheckoutButton2 = By.xpath("//button[@data-test='proceed-2']");
    //button[@data-test='proceed-3']
    private final By proceedToCheckoutButton3 = By.xpath("//button[@data-test='proceed-3']");

    private final By paymentDropDownList = By.cssSelector("#payment-method");

    private final By confirmButton = By.xpath("//button[@data-test='finish']");

    private final By orderConfirmationMessage = By.cssSelector("#order-confirmation");



    private final By emailField = By.id("email");
    private final By passwordField = By.id("password");
    private final By loginButton = By.cssSelector(".btnSubmit");



    public void clickOnProceedToCheckoutButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement ele = wait.until(ExpectedConditions.presenceOfElementLocated(proceedToCheckoutButton));
        scrollIntoView(driver, webElement(proceedToCheckoutButton));
        click(proceedToCheckoutButton, 10);

    }
    public void clickOnProceedToCheckoutButton2() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement ele = wait.until(ExpectedConditions.presenceOfElementLocated(proceedToCheckoutButton2));
        scrollIntoView(driver, webElement(proceedToCheckoutButton2));
        click(proceedToCheckoutButton2, 10);
    }
    public void clickOnProceedToCheckoutButton3() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement ele = wait.until(ExpectedConditions.presenceOfElementLocated(proceedToCheckoutButton3));
        scrollIntoView(driver, webElement(proceedToCheckoutButton3));
        click(proceedToCheckoutButton3, 10);
    }
    public  void SelectFromPaymentDropDownElement(String VisibleText){
        select =new Select(driver.findElement(paymentDropDownList));
        select.selectByVisibleText(VisibleText);
    }
    public void clickOnConfirmButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement ele = wait.until(ExpectedConditions.presenceOfElementLocated(confirmButton));
        scrollIntoView(driver, webElement(confirmButton));
        click(confirmButton, 10);

    }
    public void clickOnConfirmButton2() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement ele = wait.until(ExpectedConditions.presenceOfElementLocated(confirmButton));
        scrollIntoView(driver, webElement(confirmButton));
        click(confirmButton, 10);

    }
    public boolean getOrderConfirmationMessage(String expectedValue){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement ele = wait.until(ExpectedConditions.presenceOfElementLocated(orderConfirmationMessage));
        scrollIntoView(driver, webElement(orderConfirmationMessage));
        return getText(orderConfirmationMessage).contains(expectedValue);
    }


    public void insertEmail(String email){
        sendKeys(emailField,email);
    }
    public void insertPassword(String password){
        sendKeys(passwordField,password);
    }

    public AccountPage clickOnLoginButton() {
        scrollIntoView(driver,webElement(loginButton));
        click(loginButton,10);
        return new AccountPage(driver);
    }

}
