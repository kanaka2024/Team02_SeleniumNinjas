package stepDefinitions;

import java.io.IOException;
import java.util.List;

import org.testng.Assert;
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
		lpage = new LoginPage(DriverFactory.getDriver());

	}

	@Given("Admin in Home page")
	public void admin_in_Home_page() {
		lpage.getloginUrl();
		lpage.getPageTitle();

	}

	@When("Click Add New Batch")
	public void click_add_new_batch() {
		// page.batchaddclick();
		String title = page.currentUrl();
		System.out.println("title: " + title);

		// Assert.assertTrue(title.contains("batch"));

	}

	@Then("Create New Batches for {string} in {string}")
	public void create_new_batches_for_testcase_in_sheetname(String testCase, String Sheet) throws IOException {

		System.out.println("Sheetname: " + Sheet);
		utils.ExcelReader.BatchRecordsStatus batchStatus = page.addbatch(Sheet, testCase);

		if (testCase.equalsIgnoreCase("MandatoryFields")) {
			System.out.println("#### Mandatory");

			S_Assert.assertTrue(batchStatus.getMessage().contains("Successful"));

		} else if (testCase.equalsIgnoreCase("WithoutProgramNameField")) {

			S_Assert.assertEquals(page.getInlineErrorMessageProgramName(), "Program Name is required.");

		} else if (testCase.equalsIgnoreCase("WithoutBatchNameFields")) {

			S_Assert.assertEquals(page.getInlineErrorMessageBatchName(), "Batch Name is required.");

		} else if (testCase.equalsIgnoreCase("WithoutDescripFields")) {
			S_Assert.assertEquals(page.getInlineErrorMessageDesc(), "Batch Description is required.");

		} else if (testCase.equalsIgnoreCase("WithoutNumberClassFields")) {

			S_Assert.assertEquals(page.getInlineErrorMessageClassNum(), "Number of classes is required.");

		} else if (testCase.equalsIgnoreCase("Alreadyexists")) {
			System.out.println("#### Already Exists");

			S_Assert.assertTrue(page.formFieldInlineError());

		}
	}

}