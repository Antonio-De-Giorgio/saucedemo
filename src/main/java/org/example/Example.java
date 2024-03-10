package org.example;

import com.microsoft.playwright.*;

public class Example {
    public static void main(String[] args) {
        boolean isHeadless = false;
        try (Playwright playwright = Playwright.create()) {
            BrowserType browserType = playwright.firefox();
            Browser browser = browserType.launch(new BrowserType.LaunchOptions().setChannel("firefox").setHeadless(isHeadless));
            BrowserContext context = browser.newContext();
            Page page = context.newPage();
            page.navigate("https://amazon.de");

            synchronized (page) {
                page.wait(10000);
            }
            // other actions...
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}