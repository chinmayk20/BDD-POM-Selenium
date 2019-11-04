package StepDef;

import com.qa.pageObjects.CommonFunctions;
import com.qa.pageObjects.HomePageObjects;
import com.qa.support.EnumConstants;
import com.qa.support.DriverFactory;
import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class HomepageStepsDef extends DriverFactory {

//    @Autowired
//    HomePageObjects hm;
//
//    @Autowired
//    CommonFunctions cm;


    HomePageObjects hm = new HomePageObjects();
    CommonFunctions cm = new CommonFunctions();

    //cm is reference variabvle
    // new CommonFunctions(); is called object



    @Given("^I navigate to the login page$")
    public void iNavigateToTheLoginPage() {
        hm.navigateToHomePage();
    }

    @And("^I click login button$")
    public void iClickLoginButton() {

    }

    @Then("^I should see the userform page$")
    public void iShouldSeeTheUserformPage() {
        System.out.println("hi");
    }

    @And("^I enter the username as \"([^\"]*)\" and password as \"([^\"]*)\"$")
    public void iEnterTheUsernameAsAndPasswordAs(String username, String password) throws Throwable {
    }

    @And("^I enter following new credentials$")
    public void iEnterFollowingNewCredentials(DataTable table) {


    }


    @And("^I close the browser$")
    public void iCloseTheBrowser() throws Throwable {
        driver.manage().deleteAllCookies();
        driver.quit();
    }

    @And("^I see \"([^\"]*)\" links$")
    public void iSeeFollowingLinks() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @And("^I see (.*) link$")
    public void iSeeContactsLinks(EnumConstants.MenuBar menuBar ) {
        switch (menuBar) {
            case Home:
                hm.isContactsLinkDisplayed();
                break;
            case Contacts:
                hm.isHomeLinkDisplayed();
                break;
            case Calendar:
                hm.isCalendarLinkDisplayed();
                break;
        }

    }

    @And("^I see following links$")
    public void iSeeFollowingLinks(List<String> menu) {
        for (String m : menu){
            String a = "//*[contains(text(),"+"'m'"+")]";
            boolean element = cm.getElementByTitle(a).isDisplayed();
        }
    }
}
