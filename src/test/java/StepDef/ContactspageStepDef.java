package StepDef;

import com.qa.helpers.DataHelper;
import com.qa.pageObjects.ContactsPage;
import com.qa.pageObjects.HomePageObjects;
import com.qa.support.DriverFactory;
import com.qa.support.TestUtil;
import cucumber.api.java.en.And;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;


public class ContactspageStepDef extends DriverFactory {

//    @Autowired
//    HomePageObjects homePageObjects;
//
//    @Autowired
//    ContactsPage contactsPage;

    ContactsPage contactsPage = new ContactsPage();
    HomePageObjects homePageObjects = new HomePageObjects();

    public List<HashMap<String, String>> datamap;

    public ContactspageStepDef()
    {
        datamap = DataHelper.data(System.getProperty("user.dir") + "/src/test/java/com/qa/testData/MyTestData.xlsx","contacts");
    }

    String sheetName = "contacts";

    public Object[][] getCRMTestData(String title){
        Object data[][] = TestUtil.getTestData(sheetName);
        return data;
    }

    @And("^I click on contacts link$")
    public void iClickOnContactsLink() {
        homePageObjects.clickOnContactsLink();
        homePageObjects.clickOnNewContactLink();

    }

    @And("^I create a new contact with \"([^\"]*)\" dataset$")
    public void iCreateANewContactWithDataset(String arg1) throws Throwable {

        int index = Integer.parseInt(arg1)-1;
//        for(HashMap h:datamap)
//        {
//            System.out.println(h.keySet());
//            System.out.println(h.values());
//        }

        System.out.println(datamap.get(index).get("title"));
        System.out.println(datamap.get(index).get("firstname"));
        System.out.println(datamap.get(index).get("lastname"));
        System.out.println(datamap.get(index).get("company"));


       contactsPage.createNewContact(datamap.get(index).get("title"),datamap.get(index).get("firstname"),datamap.get(index).get("lastname"),datamap.get(index).get("company"));
    }

    @And("^I see (.*) as name$")
    public void iSeeChinmayAsName(String name) {

        switch (name) {
            case "Chinmay":
                System.out.println("ck");
                break;
            case "Arin":
                System.out.println("Arin");
                break;
        }

    }
}

