package com.qa.support;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import static org.openqa.selenium.remote.CapabilityType.PLATFORM;
import static org.openqa.selenium.remote.CapabilityType.VERSION;

public class DriverFactory {

    public static WebDriver driver;
    private static GetDefaults getDefaults = new GetDefaults();
    private static ReadConfigProperties readConfigProperties = new ReadConfigProperties();
    private static String OS = System.getProperty("os.name").toLowerCase();
    private static String browser = getDefaults.getBrowserType();
    private static String environment = getDefaults.getEnvironment();
    private static String language = getDefaults.getLanguage();

    private static void createChromeDriver(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    private static void createFirefoxDriver(){
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
    }

    private static void createBrowserstackDriver(String browser) throws MalformedURLException{
        DesiredCapabilities capability;
        if (browser.contains("browserstack-ie")){
            System.out.println("<<<<< running browserstack tests >>>>>" + getDefaults.getBrowserStackProps());
            capability = DesiredCapabilities.internetExplorer();
        }else {
            System.out.println("<<<<< running browserstack tests >>>>>" + getDefaults.getBrowserStackProps());
            capability = DesiredCapabilities.chrome();
        }
        capability.setCapability("browserstack.user", readConfigProperties.getPropertyValue("browserstack_user"));
        capability.setCapability("browserstack.key", readConfigProperties.getPropertyValue("browserstack_key"));
        capability.setCapability(VERSION, getDefaults.getBrowserStackProps().getProperty("browserStackVersion"));
        capability.setCapability(PLATFORM, getDefaults.getBrowserStackProps().getProperty("browserStackPlatform"));
        driver = new RemoteWebDriver(new URL(readConfigProperties.getPropertyValue("browserstack_url")), capability);
    }

    public static void initialiseDriver() throws MalformedURLException{
        System.out.println("Test Running on" + " OS:-" + OS + " browser:-" + browser + " environment:- " + environment + " language:- " + language);
        if (browser.equals("chrome")) {
            createChromeDriver();
        } else if (browser.equals("firefox")) {
            createFirefoxDriver();
        } else if (browser.contains("browserstack")) {
            createBrowserstackDriver(browser);
        }
    }

    public static void tearDown(){
        driver.quit();
    }
}
