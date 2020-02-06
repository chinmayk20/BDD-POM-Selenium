package StepDef;

import com.qa.pageObjects.loginPageObjects;
import com.qa.support.ReadConfigProperties;
import com.qa.support.DriverFactory;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class loginPageStepDef extends DriverFactory {

    loginPageObjects loginPageObjects = new loginPageObjects();
    ReadConfigProperties readProp = new ReadConfigProperties();

    @And("^I see login page$")
    public void iSeeLoginPage() {
        System.out.println(loginPageObjects.validateLoginPageTitle());
    }

    @And("^I click on login Button$")
    public void iClickOnLoginButton()  {
        loginPageObjects.clickOnLoginButton();
    }

    @And("^I enter the username and password$")
    public void iEnterTheUsernameAndPassword() {

        loginPageObjects.login(readProp.getPropertyValue("username"), readProp.getPropertyValue("password"));
    }

    @Given("^I am testing hashmap$")
    public void iAmTestingHashmap() {

        HashMap<String, String> myh = new HashMap();

        HashMap<String, String> scrollObjects = new HashMap<String, String>();

        scrollObjects.put("56", "89");

        myh.put("a", "abc");
        myh.put("b", "apq");

        System.out.println(myh.size());

        for (Map.Entry p : myh.entrySet()){
            System.out.println(p.getValue());
        }


    }

    @And("^I am testing boolean$")
    public void iAmTestingBoolean() {

        String[] names = {"",""};
        int[] marks = {1,2};


        for (int i:marks){
            System.out.println(i);
        }


        ArrayList<String> abc = new ArrayList<>();


        abc.add("Chin");
        abc.add("kool");

        System.out.println("Chin" + abc);

        List<String> mp = new ArrayList<>();    // most common type

        mp.add("my");
        mp.add("name");

        System.out.println("new chin " + mp);


        List name = new ArrayList();  // allows to add various objects strings, int, double etc bad side no same type of data




        for (String a : abc){
            System.out.println(a);
        }

        int p = 0;

        while(p<=10){
            System.out.println(p);
            p++;
            boolean a = p == 5 ? true:false;
            if (a){
                break;
            }
        }

        List<Integer> mynumbers = new ArrayList<>();

        mynumbers.add(7);
        mynumbers.add(17);
        mynumbers.add(73);
        mynumbers.add(7);
        mynumbers.add(5);
        mynumbers.add(4);
        mynumbers.add(2);

        List<Integer> mynewnos = new ArrayList<>();

        HashMap<String, Integer> strintmap = new HashMap<>();

        strintmap.put("abc",3);

        for (int m : mynumbers){
            System.out.println("CK");
            while(detailscorrect(m)==true){
                break;
            }

        }


    }

    public boolean detailscorrect(Integer nmb){

        boolean yes;
        yes = 5==nmb;
        return yes;
    }

}
