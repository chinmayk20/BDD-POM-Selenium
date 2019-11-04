package com.qa.pageObjects;

import com.qa.support.DriverFactory;
import com.qa.support.Wait;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.springframework.stereotype.Component;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

@Component
public class ContactsPage extends DriverFactory {

    @FindBy(xpath = "//*[contains(text(),'Contacts')]")
    WebElement contactsLabel;

    @FindBy(xpath="//input[@name='first_name']")
    WebElement firstName;

    @FindBy(xpath="//input[@name='last_name']")
    WebElement lastName;

    @FindBy(xpath="//div[@name='company']//input[@class='search']")
    WebElement company;

    @FindBy(xpath = "//button[@class='ui linkedin button']")
    WebElement saveBtn;

    // Initializing the Page Objects:
    public ContactsPage() {
        PageFactory.initElements(driver, this);
    }

    public boolean verifyContactsLabel(){
        return contactsLabel.isDisplayed();
    }

    public void createNewContact(String title, String ftName, String ltName, String comp){
        Wait.wait.until(visibilityOf(firstName));
        firstName.sendKeys(ftName);
        lastName.sendKeys(ltName);
        company.sendKeys(comp);
        saveBtn.click();

    }
}

