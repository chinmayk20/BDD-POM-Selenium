package StepDef;

import com.qa.support.DriverFactory;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.service.DriverService;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {Config.class})
@SpringJUnitConfig
public abstract class WebTest {

    protected WebDriver driver;

    protected WebTest() {
        try {
            driver = DriverFactory.driver;
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

}

@Configuration
@ComponentScan(basePackages = {"com.discovery.es"})
class Config {

}
