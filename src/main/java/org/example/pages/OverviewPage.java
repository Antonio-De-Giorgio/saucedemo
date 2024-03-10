package org.example.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class OverviewPage {
    private final Locator cancelButton;
    private final Locator finishButton;

    private final Locator backHomeButton;

    public OverviewPage(Page page) {
        this.cancelButton = page.locator("data-test=cancel");
        this.finishButton = page.locator("data-test=finish");
        this.backHomeButton = page.locator("data-test=back-to-products");
    }

    public void clickOnCancelButton() {
        cancelButton.click();
    }

    public void clickOnFinishButton() {
        finishButton.click();
    }

    public void clickOnBackHomeButton() {
        backHomeButton.click();
    }
}
