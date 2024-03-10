package org.example.tests;

import com.microsoft.playwright.*;
import org.example.pages.*;
import org.testng.annotations.Test;

public class OverviewTest {
    @Test
    public void CheckOverviewTest() {
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
            checkoutPage.fillInForm();
            checkoutPage.clickOnContinueButton();

            OverviewPage overviewPage = new OverviewPage(page);
            overviewPage.clickOnCancelButton();
            productPage.navigateToShoppingCart();
            cartPage.checkoutOder();
            checkoutPage.fillInForm();
            checkoutPage.clickOnContinueButton();
            overviewPage.clickOnFinishButton();
            overviewPage.clickOnBackHomeButton();

        }
    }
}
