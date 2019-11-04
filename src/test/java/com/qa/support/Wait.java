package com.qa.support;

import org.openqa.selenium.support.ui.WebDriverWait;

public class Wait extends DriverFactory {

    public static WebDriverWait wait = new WebDriverWait(driver, 90);

}
