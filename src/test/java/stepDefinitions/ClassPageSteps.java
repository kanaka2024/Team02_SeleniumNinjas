package stepDefinitions;

import java.util.List;

import org.testng.Assert;

import driverFactory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.ManageClassPage;
import pageObjects.LoginPage;
import utils.ExcelReader;
import utils.LoggerLoad;

public class ClassPageSteps {
	
	private ManageClassPage MCPage = new ManageClassPage(DriverFactory.getDriver());
	private ExcelReader excelRead = new ExcelReader();
	
	
//	
//	@Given("Admin is on dashboard page after Login")
//	public void admin_is_on_dashboard_page_after_login() throws InterruptedException {
//		System.out.println("Admin");
//		MCPage.getloginUrl();
//		
//	}
//	@When("Admin clicks {string} button on the navigation bar")
//	public void admin_clicks_button_on_the_navigation_bar(String string) {
//		MCPage.Classbutton();
//	   
//	}
	
	@Given("Admin is on dashboard page after Login and Admin clicks {string} button on the navigation bar")
	public void admin_is_on_dashboard_page_after_login_and_admin_clicks_button_on_the_navigation_bar(String string) throws InterruptedException {
		System.out.println("Admin");
		MCPage.getloginUrl();
		Thread.sleep(2000);
		MCPage.Classbutton();
		   
	}
	
	@Then("The page title should be {string}")
	public void the_page_title_should_be(String expectedTitle) {		
		LoggerLoad.info("Start : Validate the Program page Validate Page title");
		String clsTxt =MCPage.getManageClassPageTitle();		
		Assert.assertTrue(clsTxt.equalsIgnoreCase(expectedTitle));
	}
	
	@Then("The class grid should display the following headers:")
	public void the_class_grid_should_display_the_following_headers(io.cucumber.datatable.DataTable dataTable) {
		List<String> expectedHeaders=dataTable.row(0);
		 Assert.assertTrue(MCPage.verifyGridHeaders(expectedHeaders), "Headers do not match");
	}
	
	@Then("Admin should see the Search Bar in Manage class page")
	public void admin_should_see_the_search_bar_in_manage_class_page() throws InterruptedException {
LoggerLoad.info("Start : Validate the Class page  Search box input is visible");
		
		boolean srchbox = MCPage.srchBox();
		System.out.println("Search box is displayed : "+srchbox);
		Assert.assertEquals(true, srchbox);		
		String srchtxt =MCPage.srchtxt();
		System.out.println("Search box placeholder text is "+srchtxt);
		Assert.assertTrue(srchtxt.contains("Search"));
		LoggerLoad.info("End : Validate the Class page  Search box input is visible");
	}
	
	@Then("Admin should see the {string} and enabled pagination controls under the data table")
	public void admin_should_see_the_and_enabled_pagination_controls_under_the_data_table(String expectedText) {
    LoggerLoad.info("Start : Validate the Program page Validate Pagination text is displayed");
        
		boolean Pgtntxt = MCPage.getPaginationtxt();
		System.out.println("Pagination text is displayed : "+Pgtntxt);
		Assert.assertEquals(true, Pgtntxt);
		LoggerLoad.info("End : Validate the Program page Validate Pagination text is displayed");
	}
	
	@Then("Admin should see Total no of classes in below of the data table.")
	public void admin_should_see_total_no_of_classes_in_below_of_the_data_table() {
    LoggerLoad.info("Start : Validate the Program page Validate datatable footer text is displayed");
		
		boolean Fttxt = MCPage.getFootertxt();
		System.out.println("Footer text is displayed : "+Fttxt);
		Assert.assertEquals(true, Fttxt);
		LoggerLoad.info("End : Validate the Program page Validate datatable footer text is displayed");
	}
	
	



	
}
