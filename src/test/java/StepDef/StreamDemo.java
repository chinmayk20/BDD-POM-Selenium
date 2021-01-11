package StepDef;

import com.qa.support.DriverFactory;
import cucumber.api.java.en.And;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamDemo extends DriverFactory {

    ArrayList<String> names = new ArrayList<String>();

    List<String> chinpublic = Arrays.asList("Arin","Kola","ArinBoss","Azbhijeet");


    @And("^I print count using stream filter$")
    public void iPrintValuesUsingStreamFilter() {
        names.add("Adam");
        names.add("Ishaan");
        names.add("Arin");
        names.add("Joy");
        names.add("Abhijeet");

        Long myname = names.stream().filter(a -> a.startsWith("A")).count();
        System.out.println(myname);
    }

    @And("^I filter and print all names in the list using stream$")
    public void iFilterListUsingStream()  {
        names.add("Adam");
        names.add("Ishaan");
        names.add("Arin");
        names.add("Joy");
        names.add("Abhijeet");

        names.stream().filter(a -> a.startsWith("A")).forEach(a -> System.out.println(a));
        names.stream().forEach(a -> System.out.println(a));
        names.forEach(System.out::println);
        names.stream().forEach(System.out::println);
    }

    @And("^Find first with matching results$")
    public void findFirstWithMatchingResults() {
        //Convert Array into a List
        List<String> chin = Arrays.asList("Arin","Kola","ArinBoss","Azbhijeet");

        String p = chin.stream().filter(a -> a.startsWith("A")).findFirst().get();
        System.out.println(p);
    }

    @And("^I test map to a new condition$")
    public void iTestMapToANewCondition() throws Throwable {

        //Convert Array into a List
        List<String> chin = Arrays.asList("Arin","Kola","ArinBoss","Azbhijeet");

        chin.stream().filter(a -> a.endsWith("s")).map(a -> a.toUpperCase()).forEach(System.out::println);

        //Sorted list
        chin.stream().filter(a ->  a.startsWith("A")).sorted().forEach(System.out::println);
    }


    @And("^I Combine two lists and print Distinct list$")
    public void iCombineTwoListsAndPrintDistinctList() {

        List<String> chin = Arrays.asList("Arin","Kola","ArinBoss","Azbhijeet");
        List<String> chintwo = Arrays.asList("Arin","Kola","ArinBoss2","Azbhijeet2");

        Stream.concat(chin.stream(),chintwo.stream()).forEach(System.out::println);
        //Store in another list
        List<String> combined = Stream.concat(chin.stream(),chintwo.stream()).collect(Collectors.toList());
        combined.stream().sorted().forEach(System.out::println);
        combined.stream().distinct().forEach(System.out::println);
    }


    @And("^I assert the condition$")
    public void iAssertTheCondition() {
        //Selenium Validations
        List<String> chin = Arrays.asList("Arin","Kola","ArinBoss","Azbhijeet");
        boolean ch = chin.stream().anyMatch(a -> a.equalsIgnoreCase("Arin"));
        System.out.println(ch);
        Assert.assertTrue(ch);
    }

    @And("^I test collector with desired filter validation and get first name$")
    public void iTestCollectorWithDesiredFilterValidation() {
        List<String> chin = Arrays.asList("Arin","Kola","ArinBoss","Azbhijeet");
        List<String> my = chin.stream().filter(a -> a.startsWith("A")).map(a ->a.toUpperCase()).collect(Collectors.toList());
        String a = my.stream().findFirst().get();
        System.out.println(a);

        //Just to get the First
        System.out.println("*******");
        chinpublic.stream().filter(s -> s.startsWith("A")).limit(1).forEach(s -> System.out.println(a));
    }

    @And("^Convert Array into Distinct values and sort$")
    public void convertArrayIntoDistinctValuesAndSort() {

        List<Integer> chin = Arrays.asList(1, 3, 8, 3, 2, 1, 8,9);

        //using distinct and sort
        chin.stream().distinct().sorted().forEach(System.out::println);

        //using collector to Set - does same as distinct and sort
        chin.stream().collect(Collectors.toSet()).forEach(System.out::println);
    }

    @And("^Get text and compare sorted list$")
    public void getTextAndCompareSortedList() {
        // Capture all elements
        List<WebElement> itemList = driver.findElements(By.xpath(""));
        //Capture the text
        List<String> originaltext = itemList.stream().map(a -> a.getText()).collect(Collectors.toList());
        //Sort teh list
        List<String> Sortedlist = originaltext.stream().sorted().collect(Collectors.toList());
        Assert.assertTrue(originaltext.equals(Sortedlist));
    }


    @And("^Pagination on webpage$")
    public void paginationOnWebpage() {

        List<String> price;
        do {
            // Capture all elements
            List<WebElement> itemList = driver.findElements(By.xpath(""));
            //Capture the text
            price = itemList.stream().filter(a -> a.getText().contains("")).
                    map(a -> getPriceVegie(a)).collect(Collectors.toList());

            if (price.size() < 1) {
                //Click on next page
            }
        }while (price.size() < 1);

    }

    private String getPriceVegie(WebElement a) {
        String price = a.findElement(By.xpath("")).getText();
        return price;
    }
}
