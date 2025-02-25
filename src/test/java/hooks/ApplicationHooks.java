package hooks;

import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import driverFactory.DriverFactory;
import utils.ConfigReader;
import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;


public class ApplicationHooks {
	
	private DriverFactory driverFactory;
    private WebDriver driver;
    private ConfigReader configReader;
    private static Properties prop;

    private static Logger log = LogManager.getLogger();

    // Initialize configuration before all tests
    @Before(order = 0)
    public void getProperty() {
        configReader = new ConfigReader();
        prop = configReader.init_prop();
    }

    // Launch the browser before each test scenario
    @Before(order = 1)
    public void launchBrowser() {
        String browserName = prop.getProperty("browser");
        driverFactory = new DriverFactory();
        driver = driverFactory.init_driver(browserName);
    }

    // Quit the browser after all test scenarios
   @After(order = 1)
    public void quitBrowser() {
        if (driver != null) {
driver.quit();
        }
    }

    // Capture screenshots if the scenario fails
    @After(order = 1)
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            // Take a screenshot in case of failure
            String screenshotName = scenario.getName().replaceAll(" ", "_");
            byte[] sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(sourcePath, "image/png", screenshotName);
        }
    }

    // Provide WebDriver instance for the page objects
    public WebDriver getDriver() {
        return driver;
    }
}


