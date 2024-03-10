package org.example.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class CheckoutPage {

    private final Locator firstName;
    private final Locator lastName;
    private final Locator postalCode;
    private final Locator errorMessage;
    private final Locator cancelButton;
    private final Locator continueButton;

    public CheckoutPage(Page page) {
        this.firstName = page.locator("data-test=firstName");
        this.lastName = page.locator("data-test=lastName");
        this.postalCode = page.locator("data-test=postalCode");
        this.errorMessage = page.locator("data-test=error");
        this.cancelButton = page.locator("data-test=cancel");
        this.continueButton = page.locator("data-test=continue");
    }

    public void clickOnContinueButton() {
        continueButton.click();
    }

    public void clickOnCancelButton() {
        cancelButton.click();
    }

    public void fillInForm() {
        firstName.fill("Max");
        lastName.fill("Mustermann");
        postalCode.fill("69469");
    }

    public void checkError() {
        clickOnContinueButton();
        if (errorMessage.isVisible()) {
            fillInForm();
        }
    }
}
