package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;

import utils.Constants;

public class LoginPage {
	
	private WebDriver driver;

	private By username = By.xpath("//input[@id='username']");
	private By password = By.xpath("//input[@id='password']");
	private By login = By.xpath("//button[@id='login']");
	
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	public void getloginUrl() {
		driver.get(Constants.baseUrl);
	}

	public String getPageTitle() {
		return driver.getTitle();
	}

}
