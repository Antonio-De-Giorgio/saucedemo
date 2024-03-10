package org.example.tests;

import com.microsoft.playwright.*;
import org.example.base.BaseTest;
import org.example.pages.LoginPage;
import org.example.pages.ProductPage;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    public void VerifyLoginIsPossible() {
        boolean isHeadless = false;
        try (Playwright playwright = Playwright.create()) {
            BrowserType browserType = playwright.webkit();
            Browser browser = browserType.launch(new BrowserType.LaunchOptions().setChannel("webkit").setHeadless(isHeadless));
            BrowserContext context = browser.newContext();
            Page page = context.newPage();
            LoginPage loginPage = new LoginPage(page);

            loginPage.navigate();
            loginPage.checkerror();
            loginPage.login();

            ProductPage productPage = new ProductPage(page);
            productPage.logout();

            loginPage.checkerror();
        }

    }
}

