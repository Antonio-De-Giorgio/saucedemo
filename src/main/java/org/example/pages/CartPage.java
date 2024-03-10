package org.example.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class CartPage {

    private final Locator continueButton;
    private final Locator checkoutButton;

    public CartPage(Page page) {
        this.continueButton = page.locator("data-test=continue-shopping");
        this.checkoutButton = page.locator("data-test=checkout");
    }

    public void continueOrder() {
        continueButton.click();
    }

    public void checkoutOder() {
        checkoutButton.click();
    }
}
