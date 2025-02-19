package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import driverFactory.DriverFactory;

import pageObjects.LoginPage;

import utils.Constants;
import utils.ExcelReader;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
public class LoginPageSteps {
	
	private LoginPage loginpg = new LoginPage(DriverFactory.getDriver());
	private ExcelReader excelRead = new ExcelReader();

	
	@Given("Verify admin is able to land on home page")
	public void verify_admin_is_able_to_land_on_home_page() {
		
			System.out.println("The user ois on Login page");
	}

	@When("Admin gives the correct LMS portal URL")
	public void admin_gives_the_correct_lms_portal_url() {
	
		loginpg.getloginUrl();
	}

	@Then("Admin should land on the home page")
	public void admin_should_land_on_the_home_page() {
	 
		String actualTitle = loginpg.getPageTitle();
		Assert.assertEquals("LMS", actualTitle.trim());
	}

}
