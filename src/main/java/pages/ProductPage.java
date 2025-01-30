package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.MethodHandles;

import java.time.Duration;

public class ProductPage extends MethodHandles {

    Actions actions;
    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public final By addToCardButton = By.id("btn-add-to-cart");
    public final By cardIcon = By.xpath("//a[@aria-label='cart']");

    public void clickOnAddToCardButton(int index) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement ele = wait.until(ExpectedConditions.elementToBeClickable(addToCardButton));
        scrollIntoView(driver, ele);
        actions = new Actions(driver);
        ele = driver.findElements(addToCardButton).get(index-1);
        actions.moveToElement(ele).click().build().perform();
    }

    public CheckoutPage clickOnCardIcon() throws InterruptedException {
        Thread.sleep(7000);
        scrollIntoView(driver,webElement(cardIcon));
        click(cardIcon,10);
        return new CheckoutPage(driver);
    }


}
