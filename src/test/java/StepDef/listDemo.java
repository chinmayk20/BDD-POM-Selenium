package StepDef;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class listDemo {


    @And("^I print values using simple for loop$")
    public void iPrintValuesUsingSimpleForLoop()  {
        List<String> ll = new ArrayList<>();
        ll.add("abc");
        ll.add("abcd");
        for (int i =0; i<ll.size(); i++){
            System.out.println("simple for loop " + ll.get(i));
        }

    }

    @And("^I print values using advanced loop$")
    public void iPrintValuesUsingSimpleAdvancedLoop() {
        List<String> lp = new ArrayList<>();
        System.out.println("print values using simple advanced loop");
        lp.add("ab");
        lp.add("abd");

        for (String myI : lp){
            System.out.println(" fancy for loop " + myI);
        }
    }

    @And("^I print values using iterator$")
    public void iPrintValuesUsingIterator() throws Throwable {
        List<String> lpp = new ArrayList<>();
        System.out.println("print values using iterator$");
        lpp.add("ab");
        lpp.add("abd");
        lpp.add("abdb");

        Iterator<String> it = lpp.iterator();

        while (it.hasNext()){
            System.out.println(it.next());
        }
    }

    @And("^I print values using While loop$")
    public void iPrintValuesUsingWhileLoop() throws Throwable {

        List<String> lpk = new ArrayList<>();
        System.out.println("print values using while loop");
        lpk.add("ab");
        lpk.add("abd");
        lpk.add("abdb");

        int num = 0;
        while (lpk.size()>num){
            System.out.println(lpk.get(num));
            num++;
        }

    }


    @And("^assert whether string exist in the list$")
    public void assertWhetherStringExistInTheList() {

        List<String> lpk = new ArrayList<>();
        lpk.add("ab");
        lpk.add("abd");
        lpk.add("abdb");
        lpk.add("Expected");

        String expected = "Expected";

        boolean yesChinmay = false;
        for (String ab : lpk){
            if (ab.equalsIgnoreCase(expected)){
                yesChinmay = true;
            }
        }
        Assert.assertTrue(yesChinmay);
    }

    @And("^also check using try and catch method$")
    public void alsoCheckUsingTryAndCatchMethod() {

        String all = myMet("SIGN IN");
        System.out.println(all);

        List<String> lpk = new ArrayList<>();
        lpk.add("ab");
        lpk.add("abd");
        lpk.add("abdb");
        lpk.add("Expected");

        String expected = "Expected";

        for (String a : lpk){
            try {

            } catch (Exception e){

            }
        }
    }

    public String myMet(String abc){
        String searchLocator = "new UiSelector().textContains(\""+abc+"\")";

        return searchLocator;
    }


    @And("^I create a list of lists$")
    public void iCreateAListOfLists() {

        List<Integer> ls=new ArrayList<>();
        ls.add(1);
        ls.add(2);

        List<Integer> ls1=new ArrayList<>();
        ls1.add(3);
        ls1.add(4);

        List<List<Integer>> ls2=new ArrayList<>();
        ls2.add(ls);
        ls2.add(ls1);
//
//        List<List<List<Integer>>> ls3=new ArrayList<>();
//        ls3.add(ls2);

        for (List<Integer> my : ls2){
            System.out.println(" ls2 is " + my);


        }

        for (List<Integer> my : ls2){
            System.out.println(" ls2 is *** " + my.get(0));
            System.out.println(" ls2 is *** " + my.get(1));

        }
    }
}
