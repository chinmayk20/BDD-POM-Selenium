package runner;

import com.qa.support.DriverFactory;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import java.net.MalformedURLException;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/Features", //the path of the feature files
        glue = "StepDef",
        tags = {"~@pending","~@broken", "~@wip", "~@productionOnly", "@test"},
        monochrome = true,
        format = {"pretty", "html:target/html-report", "json:target/cucumber.json", "junit:target/chin/xmlreports.xml","rerun:target/rerun.txt"}
)

public class TestRunner {

    @BeforeClass
    public static void setup(){
        try {
            DriverFactory.initialiseDriver();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    public static void quit(){

        DriverFactory.tearDown();
    }
}
