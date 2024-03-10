package org.example.factory;

import com.microsoft.playwright.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Objects;
import java.util.Properties;

public class BrowserFactory {
    private Properties properties;

    public Page initializeBrowser(String browserName, String headless) {
        boolean isHeadless = Boolean.parseBoolean(headless);

        Playwright playwright = Playwright.create();

        Browser browser = switch (browserName.toLowerCase()) {
            case "chromium" -> playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(isHeadless));
            case "chrome" ->
                    playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(isHeadless));
            case "firefox" -> playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(isHeadless));
            case "webkit" -> playwright.webkit().launch(new BrowserType.LaunchOptions().setHeadless(isHeadless));
            default ->
                    throw new IllegalArgumentException("Please provide a valid browser name (chrome, firefox, webkit or chromium).");
        };

        BrowserContext browserContext = browser.newContext();

        return browserContext.newPage();
    }
    public Properties initializeConfigProperties() {
        try {
            ClassLoader classLoader = getClass().getClassLoader();
            String configUrl = Objects.requireNonNull(classLoader.getResource("config/config.properties")).getPath();
            FileInputStream fileInputStream = new FileInputStream(configUrl);
            properties = new Properties();
            properties.load(fileInputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return properties;
    }
}