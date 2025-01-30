package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.MethodHandles;

public class AccountPage extends MethodHandles {
    public AccountPage(WebDriver driver) {
        super(driver);
    }

    private final By homeButton = By.cssSelector(".nav-link.active");

    public HomePage clickOnHomeButton() {
        click(homeButton,10);
        return new HomePage(driver);
    }
}
