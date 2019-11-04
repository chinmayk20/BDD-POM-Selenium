package com.qa.support;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;

import static com.qa.support.DriverFactory.driver;
import static org.openqa.selenium.OutputType.BYTES;

public class Hooks {

    @After()
    public void embedScreenshot(Scenario scenario) {
        if(scenario.isFailed()) {
            try {
                scenario.write("Current Page URL is " + driver.getCurrentUrl());
                byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(BYTES);
                scenario.embed(screenshot, "image/png");
            } catch (WebDriverException somePlatformsDontSupportScreenshots) {
                System.err.println(somePlatformsDontSupportScreenshots.getMessage());
            }
        }
    }
}
