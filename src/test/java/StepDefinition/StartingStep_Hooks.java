package StepDefinition;

import com.automationFramework.driverFactory.DriverFactory;
import com.automationFramework.utility.ConfigPropertiesReader;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;

import java.util.Properties;

public class StartingStep_Hooks {
    public static WebDriver driver;
    public ConfigPropertiesReader propertiesFile;
    public Properties prop;

    @Before(order = 0)
    public void getProperty() {
        propertiesFile = new ConfigPropertiesReader();
        prop = propertiesFile.initializeProperties();
    }

    @Before(order = 1)
    public void launchBrowser() {
        String browser = prop.getProperty("browser");
        driver = DriverFactory.initDriver(browser);
        driver.get(prop.getProperty("url"));
    }

    @After
    public void quitBrowser() {
        DriverFactory.quitDriver();
    }
}
