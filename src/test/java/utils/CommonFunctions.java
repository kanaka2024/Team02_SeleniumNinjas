package utils;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

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
	public String expectedmessage = null;
	private LoginPage login = new LoginPage(DriverFactory.getDriver()) ;
	
    // Constructor initializes WebDriver and WebDriverWait
    public CommonFunctions(WebDriver driver, int timeoutInSeconds) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
    }



    //For positive scenario - Reading from config.property file
	public void loginDetails() {	
		configReader=new ConfigReader();
		prop =configReader.init_prop();
		String username1=prop.getProperty("user");
	    String password1=prop.getProperty("password");
	    login.enterCredentials(username1, password1);
		login.roleSelectionClick();
		login.Submitforlogin();
		
		}
	//For negative scenario - Reading from excel test data - Login sheet
	public void enterExcelDataForLogin(String sheetname, Integer rownumber){

		ExcelReader reader = new ExcelReader();
		List<Map<String, String>> testdata = reader.getData("src\\test\\resources\\TestData\\TestData.xlsx", sheetname);
		String username  = testdata.get(rownumber).get("Username");
		String password = testdata.get(rownumber).get("Password");
		String expectedmessage = testdata.get(rownumber).get("Expected message");
		this.expectedmessage=expectedmessage;
		login.enterCredentials(username, password);
		login.roleSelectionClick();
		login.Submitforlogin();
		
	}
	
	//For 404 page not found issue and broken link
	public int httpcodestatus() throws IOException, InterruptedException{
		HttpClient client = HttpClient.newHttpClient();

        // Create a HttpRequest with HEAD method
        HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create("https://lms-frontend-hackathon-oct24-173fe394c071.herokuapp.com"))
            .method("HEAD", HttpRequest.BodyPublishers.noBody()) // Replacing URL usage
            .build();

        // Send the request and receive response
        HttpResponse<Void> response = client.send(request, HttpResponse.BodyHandlers.discarding()); // No body expected

        // Get response code
        int r = response.statusCode();
        System.out.println("Http code: " + r);
       return r;
	}

	public void  loginThroughKeyboard(){
		configReader=new ConfigReader();
		prop =configReader.init_prop();
		String username1=prop.getProperty("user");
	    String password1=prop.getProperty("password");
	    login.EnterThroughKeyboardnLogin(username1, password1);
	}
	public void  loginThroughMouseOverAction(){
		configReader=new ConfigReader();
		prop =configReader.init_prop();
		String username1=prop.getProperty("user");
	    String password1=prop.getProperty("password");
	    login.ClickThroughMouse(username1, password1);
	}
	
}
	
