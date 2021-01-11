package StepDef;

import com.qa.pageObjects.loginPageObjects;
import com.qa.support.DriverFactory;
import com.qa.testData.UserData;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import io.cucumber.datatable.DataTable;
import org.openqa.selenium.WebElement;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.junit.Assert.assertTrue;

public class DataDrivenExamples extends DriverFactory {


    loginPageObjects loginPageObjects = new loginPageObjects();

    @And("^I am good$")
    public void iAmGood() {
        System.out.println("test");
    }

    @Then("^I enter valid data on the page using raw$")
    public void iEnterValidDataOnThePageUsingRaw(DataTable table) {

        List<List<String>> data = Collections.singletonList(table.row(0));
//        for (List<String> da : data){
//            System.out.println(da);
//        }

        System.out.println(data.get(0).get(1));
        System.out.println(data.get(1).get(1));

        System.out.println(data.get(0).get(2));
        System.out.println(data.get(1).get(2));
//        driver.findElement(By.cssSelector("input[name*='title']")).sendKeys(data.get(0).get(1));
//        driver.findElement(By.cssSelector("input[name*='firstname']")).sendKeys(data.get(1).get(1));
    }

    @And("^I enter following new credentials$")
    public void iEnterFollowingNewCredentials(DataTable table) {

        List<List<String>> myData = Collections.singletonList(table.row(0));
        for (List<String> abc : myData)
            System.out.println(abc.get(0));
    }


    @Then("^I enter valid data on the page using HashMap$")
    public void iEnterValidDataOnThePageUsingHashMap(DataTable table) {

        for (Map<Object, Object> user : table.asMaps(String.class,String.class)){
            System.out.println(user.get("title"));
            System.out.println(user.get("firstname"));
            System.out.println(user.get("lastname"));
            System.out.println(user.get("company"));
//        driver.findElement(By.cssSelector("input[name*='title']")).sendKeys(user.get("title"));
//        driver.findElement(By.cssSelector("input[name*='firstname']")).sendKeys(user.get("firstname"));
        }
    }

    @Then("^I enter valid data on the page using POJO type$")
    public void iEnterValidDataOnThePageUsingPOJOType(List<UserData> myData) {

        for (UserData user : myData){
            System.out.println(user.getFirstname());
            System.out.println(user.getLastname());
//                driver.findElement(By.cssSelector("input[name*='title']")).sendKeys(user.getFirstname());
//                driver.findElement(By.cssSelector("input[name*='title']")).sendKeys(user.getLastname());
        }

    }

    @And("^using stream list check links present$")
    public void thisIsToCheckList(List<String> links){
        List<String> displayedLinks = loginPageObjects.myLoginList.stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
        assertTrue("Expecting all thee links displayed in the Accounts Section. Displayed Links in Accounts "+displayedLinks.toString() + " Expected Links "+links.toString(),
                displayedLinks.containsAll(links));
    }

    @Then("^I enter valid ([^\"]*)$")
    public void iEnterValidTtle(String myValue){
        System.out.println(myValue);
    }

    @Then("^I also enter valid ([^\"]*) and ([^\"]*)$")
    public void iAlsoEnterValidTtleAndFirstname(String abc, String pqr){
        System.out.println(abc);
        System.out.println(pqr);
    }

    @Then("^the user click on the following ([^\"]*)$")
    public void theUserClickOnTheFollowingLink(String link) {
        System.out.println(link);
    }

    @And("^appropriate ([^\"]*) gets displayed$")
    public void appropriatePageGetsDisplayed(String link) {
        switch (link){
            case "linkpolicy":
                assertTrue("linkpolicy Page did NOT display", loginPageObjects.myLoginList.get(0).isDisplayed());
                break;
            case "linkterms":
                assertTrue("Privacy Policy Page did NOT display", loginPageObjects.myLoginList.get(0).isDisplayed());
                break;
        }
    }
}