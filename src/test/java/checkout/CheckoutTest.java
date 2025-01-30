package checkout;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.*;

import java.io.FileNotFoundException;

public class CheckoutTest extends BaseTests {

    @Test
    public void checkoutCycle_TC() throws FileNotFoundException, InterruptedException {
        ProductPage productPage = homePage.clickOnProductButton(2);
        productPage.clickOnAddToCardButton(1);
        CheckoutPage checkoutPage = productPage.clickOnCardIcon();
        checkoutPage.clickOnProceedToCheckoutButton();
        checkoutPage.insertEmail(dataModel().Email);
        checkoutPage.insertPassword(dataModel().Password);
        checkoutPage.clickOnLoginButton();
        checkoutPage.clickOnProceedToCheckoutButton2();
        checkoutPage.clickOnProceedToCheckoutButton3();
        checkoutPage.SelectFromPaymentDropDownElement(dataModel().Cash);
        checkoutPage.clickOnConfirmButton();
        checkoutPage.clickOnConfirmButton2();
        boolean resultCardInfo2 = checkoutPage.getOrderConfirmationMessage(dataModel().ExpectedResult);
        if (resultCardInfo2)
        {
            System.out.println(" The order is completed successfully ");
        }
        else {
            System.out.println("The order isn't completed successfully");
        }
    }
}
