package com.qa.pageObjects;

import com.qa.support.ReadConfigProperties;
import com.qa.support.DriverFactory;
import com.qa.support.Wait;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.springframework.stereotype.Component;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

@Component
public class HomePageObjects extends DriverFactory {

    ReadConfigProperties readProp = new ReadConfigProperties();
    CommonFunctions cm = new CommonFunctions();

    @FindBy(xpath = "//*[@class='user-display']")
    @CacheLookup
    public WebElement userNameLabel;

    @FindBy(xpath = "//*[contains(text(),'Contacts')]")
    public WebElement contactsLink;

    @FindBy(xpath = "//*[contains(text(),'Home')]")
    public WebElement HomeLink;

    @FindBy(xpath = "//*[contains(text(),'Calendar')]")
    public WebElement CalendarLink;


    @FindBy(xpath = "//button[contains(text(),'New')]")
    public WebElement newContactLink;

    @FindBy(xpath = "//a[contains(text(),'Deals')]")
    public WebElement dealsLink;

    @FindBy(xpath = "//a[contains(text(),'Tasks')]")
    public WebElement tasksLink;

    // Initializing the Page Objects:
    public HomePageObjects() {
        PageFactory.initElements(driver, this);
    }

    public String verifyHomePageTitle(){
        return driver.getTitle();
    }

    public boolean verifyCorrectUserName(){
        return userNameLabel.isDisplayed();
    }

    public String getUserName(){
        return userNameLabel.getText();
    }

    public ContactsPage clickOnContactsLink(){
        Wait.wait.until(visibilityOf(contactsLink));
        contactsLink.click();
        return new ContactsPage();
    }

    public HomePageObjects isContactsLinkDisplayed(){
        cm.isElementDisplayed(contactsLink);
        return new HomePageObjects();
    }

    public HomePageObjects isHomeLinkDisplayed(){
        cm.isElementDisplayed(HomeLink);
        return new HomePageObjects();
    }

    public HomePageObjects isCalendarLinkDisplayed(){
        cm.isElementDisplayed(CalendarLink);
        return new HomePageObjects();
    }

    public void clickOnNewContactLink(){
        newContactLink.click();

    }

    public void navigateToHomePage() {
        System.out.println("home page is - "+ readProp.getPropertyValue("url"));
        String url = readProp.getPropertyValue("url");
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get(url);

    }
}
