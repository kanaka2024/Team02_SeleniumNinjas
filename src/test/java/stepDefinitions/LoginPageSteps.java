package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import driverFactory.DriverFactory;

import pageObjects.LoginPage;

import utils.Constants;
import utils.ExcelReader;
import utils.helperMethod;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
public class LoginPageSteps {
	
	private LoginPage loginpg = new LoginPage(DriverFactory.getDriver());
	private helperMethod helper = new helperMethod(DriverFactory.getDriver());
	
	@Given("Admin is in LoginPage")
	public void admin_is_in_login_page() {
	   
	}

	@When("Admin enters valid user and password with select role as Admin.")
	public void admin_enters_valid_user_and_password_with_select_role_as_admin() {
		loginpg.getloginUrl();
		helper.loginDetails();
	}

	@Then("Admin should be landing to home page")
	public void admin_should_be_landing_to_home_page() {
		String actualTitle = loginpg.getPageTitle();
		Assert.assertEquals("LMS", actualTitle.trim());
	}
		

}
