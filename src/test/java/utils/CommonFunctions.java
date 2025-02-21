package utils;

import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import driverFactory.DriverFactory;
import pageObjects.LoginPage;

public class CommonFunctions {
	
	private WebDriver driver;
	private ConfigReader configReader;
	private WebDriverWait wait;
	Properties prop;
	private LoginPage login = new LoginPage(DriverFactory.getDriver()) ;
	
    // Constructor initializes WebDriver and WebDriverWait
    public CommonFunctions(WebDriver driver, int timeoutInSeconds) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
    }

	
//	public commonFunctions(WebDriver driver ) {
//		this.driver = driver;
//		}

	public void loginDetails() {	
		configReader=new ConfigReader();
		prop =configReader.init_prop();
		String username1=prop.getProperty("user");
	    String password1=prop.getProperty("password");
	    login.enterCredentials(username1, password1);
		login.roleSelectionClick();
		login.Submitforlogin();
		
		}
}
