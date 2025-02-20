package pageObjects;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

import utils.Constants;

public class LoginPage {

	private WebDriver driver;

	private By username = By.xpath("//input[@id='username']");
	private By password = By.xpath("//input[@id='password']");
	private By login = By.xpath("//button[@id='login']");
	private By roleselection = By.xpath("//div[@id=\"mat-select-value-1\"]");
    private By adminselectionfromrole = By.xpath("//*[@id=\"mat-option-0\"]/span") ;
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	public void getloginUrl() {
		driver.get(Constants.baseUrl);
	}

	public String getPageTitle() {
		return driver.getTitle();
	}

	public void enterCredentials(String usrname, String passwrd) {
		driver.findElement(username).sendKeys(usrname);
		driver.findElement(password).sendKeys(passwrd);
	}
	
	
   public void roleSelectionClick() {
	   driver.findElement(roleselection).click(); 
	   driver.findElement(adminselectionfromrole).click();
	   }
	 
	public void Submitforlogin() {
		driver.findElement(login).click();
	}
}
