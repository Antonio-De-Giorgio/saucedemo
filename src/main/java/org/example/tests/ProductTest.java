package org.example.tests;

import com.microsoft.playwright.*;
import org.example.pages.LoginPage;
import org.example.pages.ProductPage;
import org.testng.annotations.Test;

public class ProductTest {
    @Test
    public void CheckProductsTest() {
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
            productPage.sortTest();
            productPage.addProductToCart();
            productPage.navigateToShoppingCart();
        }
    }
}
