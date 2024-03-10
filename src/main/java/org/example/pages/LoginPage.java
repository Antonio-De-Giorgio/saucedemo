package org.example.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class LoginPage {
    private final Page page;
    private final Locator userName;
    private final Locator password;
    private final Locator loginButton;
    private final Locator errorMessage;

    public LoginPage(Page page) {
        this.page = page;
        this.userName = page.locator("data-test=username");
        this.password = page.locator("data-test=password");
        this.loginButton = page.locator("data-test=login-button");
        this.errorMessage = page.locator("error");
    }

    public void navigate() {
        page.navigate("https://saucedemo.com");
    }

    public void login() {
        userName.fill("standard_user");
        password.fill("secret_sauce");
        loginButton.click();
    }

    public void checkerror() {
        loginButton.click();

        if (errorMessage.isVisible()) {
            login();
        } else {
            userName.fill("ERROR");
        }
    }
}
