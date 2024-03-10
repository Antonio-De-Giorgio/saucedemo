package org.example.tests;

import com.microsoft.playwright.*;
import org.example.pages.CartPage;
import org.example.pages.CheckoutPage;
import org.example.pages.LoginPage;
import org.example.pages.ProductPage;
import org.testng.annotations.Test;

public class CheckoutTest {
    @Test
    public void CheckCheckoutTest() {

        boolean isHeadless = false;
        try (Playwright playwright = Playwright.create()) {
            BrowserType browserType = playwright.firefox();
            Browser browser = browserType.launch(new BrowserType.LaunchOptions().setChannel("firefox").setHeadless(isHeadless));
            BrowserContext context = browser.newContext();
            Page page = context.newPage();
            LoginPage loginPage = new LoginPage(page);
            loginPage.navigate();
            loginPage.login();

            ProductPage productPage = new ProductPage(page);
            productPage.navigateToShoppingCart();

            CartPage cartPage = new CartPage(page);
            cartPage.checkoutOder();

            CheckoutPage checkoutPage = new CheckoutPage(page);
            checkoutPage.checkError();

            checkoutPage.clickOnCancelButton();
            cartPage.checkoutOder();

            checkoutPage.fillInForm();
            checkoutPage.clickOnContinueButton();

        }
    }
}
