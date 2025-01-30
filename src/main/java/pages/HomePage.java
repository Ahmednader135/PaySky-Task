package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utils.MethodHandles;

public class HomePage extends MethodHandles {
    Actions actions;
    public HomePage(WebDriver driver) {
        super(driver);
    }
    private final By loginButton = By.linkText("Sign in");
    private final By product = By.cssSelector(".card");


    public ProductPage clickOnProductButton(int index){
        scrollIntoView(driver,webElement(product));
        actions = new Actions(driver);
        WebElement ele = driver.findElements(product).get(index-1);
        actions.moveToElement(ele).click().build().perform();
        return new ProductPage(driver);
    }



}
