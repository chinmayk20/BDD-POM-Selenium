package com.qa.pageObjects;

import com.qa.support.DriverFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.springframework.stereotype.Component;

@Component
public class loginPageObjects extends DriverFactory {

    @FindBy(name = "email")
    WebElement username;

    @FindBy(name = "password")
    WebElement password;

    @FindBy(xpath = "//*[@class='ui fluid large blue submit button']")
    WebElement LoginButton;

    @FindBy(xpath = "")
    WebElement appLogo;

    @FindBy(xpath = "//span[contains(text(),'Log In')]")
    private WebElement logIn;

    //div[@class='ui fluid large blue submit button']

    //Initialising Page Objects

    public loginPageObjects() {
        PageFactory.initElements(driver, this);
        //this points to currrent class object, I can also write LoginPage.driver
    }


    //Actions on Login Page

    public String validateLoginPageTitle() {
        return driver.getTitle();
        //returns title of the driver and stored in a String
    }

    public boolean validateCRMLogo() {
        return appLogo.isDisplayed();
        //return is true/false hence boolean
    }

    public void clickOnLoginButton(){
        logIn.click();
    }

    public HomePageObjects login(String un, String pwd) {
        username.sendKeys(un);
        password.sendKeys(pwd);
        LoginButton.click();
        return new HomePageObjects();
        //return homePage class objects (hence instead of void HomePage)
    }
}


