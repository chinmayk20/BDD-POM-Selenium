package com.qa.pageObjects;

import com.qa.support.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;

@Component
public class CommonFunctions extends DriverFactory {

    public boolean isElementDisplayed (WebElement element) {
        try {
            return element.isDisplayed();
        } catch (Exception exception) {
            return false;
        }
    }

    public WebElement findElementSafe(By byElm) {
        try {
            return driver.findElement(byElm);
        } catch (Exception e) {
            return null;
        }
    }

    public WebElement getElementByTitle(String title) {
        return driver.findElement(By.xpath(title));
    }

    public void waitForScreenToBeStable(long timeOut) {
        try {
            Thread.sleep(timeOut);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public String getElementTextOrName(WebElement expectedScreenElement) {
        return !expectedScreenElement.getText().equalsIgnoreCase("") ? expectedScreenElement.getText() :
                expectedScreenElement.getAttribute("name");
    }

    public Boolean waitForElementInvisibility(WebElement element, long timeout) {
        try {
            return new WebDriverWait(driver, timeout).until(ExpectedConditions.invisibilityOf(element));
        } catch (Exception e) {
            return null;
        }
    }

    public WebElement waitForElementVisibility(WebElement element, long timeout) {
        try {
            return new WebDriverWait(driver, timeout).until(ExpectedConditions.visibilityOf(element));
        } catch (Exception e) {
            return null;
        }
    }

    public WebElement waitForElementVisibility(By element, long timeout) {
        try {
            return new WebDriverWait(driver, timeout).until(ExpectedConditions.visibilityOfElementLocated(element));
        } catch (Exception e) {
            return null;
        }
    }

    public boolean waitForElementVisibilityBool(WebElement element, long timeout) {
        try {
            new WebDriverWait(driver, timeout).until(ExpectedConditions.visibilityOf(element));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean waitForElementInvisibilityBool(WebElement element, long timeout) {
        try {
            new WebDriverWait(driver, timeout).until(ExpectedConditions.invisibilityOf(element));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

   public void getTextFromList(List<WebElement> actualList, Set<String> combinedList) {
       for (WebElement element : actualList) {
           combinedList.add(element.getText());
       }
   }

   public void clickOnTheListElement (List<WebElement> listOfAsset, int i) {
        listOfAsset.get(i).click();
   }

}
