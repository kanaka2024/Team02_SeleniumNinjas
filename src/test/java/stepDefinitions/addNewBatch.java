package stepDefinitions;

import java.io.IOException;

import org.testng.asserts.SoftAssert;

import driverFactory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.LoginPage;
import pageObjects.batchModule;

public class addNewBatch {

	private batchModule page;
	private SoftAssert S_Assert = new SoftAssert();
	private LoginPage lpage;


	public addNewBatch() {
		page = new batchModule(DriverFactory.getDriver()); // Get the driver from driverManager
		lpage=new LoginPage(DriverFactory.getDriver());

	}

	@Given("Admin in Home page")
	public void admin_in_Home_page() {
		lpage.getloginUrl();
		lpage.getPageTitle();		
	   
	}

	@When("Click Add New Batch")
	public void click_add_new_batch() {
        //page.batchaddclick();
		String title = page.currentUrl();
		System.out.println("title: " + title);

		// Assert.assertTrue(title.contains("batch"));

	}

	@Then("^Create New Batches(.+)$")
	public void Create_New_Batches(String Sheet) throws IOException {
		System.out.println("Sheetname: " + Sheet);
		String S = page.addbatch(Sheet);
		S_Assert.assertEquals(S, "Successful", "mismatch!");
	}

}
