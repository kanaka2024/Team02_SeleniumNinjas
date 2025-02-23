package stepDefinitions;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import driverFactory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.AddNewClassPage;
import utils.ExcelReader;

public class AddNewClassPageSteps {

	private AddNewClassPage ANCPage = new AddNewClassPage(DriverFactory.getDriver());
	ExcelReader exlReader = new ExcelReader();
	String expectedResult;
	WebDriver driver = DriverFactory.getDriver();

	@When("Admin enters all mandatory field values with valid data and clicks save button {string} and {string}")
	public void admin_enters_all_mandatory_field_values_with_valid_data_and_clicks_save_button_and(String testCase,
			String sheetName) throws InterruptedException {

		FillFormData(sheetName, testCase);
		ANCPage.clickSaveButton();
	}

	private void FillFormData(String sheetName, String testCase) throws InterruptedException {
		List<Map<String, String>> exlData = exlReader.getData("./src/test/resources/TestData/TestData.xlsx", sheetName);
		// System.out.println(exlData.size());

		for (Map<String, String> data : exlData) {
			if (data.get("TestCase").equalsIgnoreCase(testCase)) {
				System.out.println("Test Data Found: " + data);

				// Enter values from Excel into UI fields
				ANCPage.enterBatchName(data.get("BatchName"));
				ANCPage.enterClassTopic(data.get("ClassTopic"));
				ANCPage.enterClassDescription(data.get("ClassDescription"));
				ANCPage.selectClassDates(data.get("SelectClassDates"));

				// ANCPage.enterNoOfClasses(data.get("NoofClasses"));
				ANCPage.enterStaffName(data.get("StaffName"));
				ANCPage.selectStatus(data.get("Status"));
				ANCPage.enterComments(data.get("Comments"));
				ANCPage.enterNotes(data.get("Notes"));
				ANCPage.selectRecordingOption(data.get("Recording"));
				expectedResult = data.get("ExpectedResult");

			}
		}
	}

	@Then("Admin should see new class details is added in the data table")
	public void admin_should_see_new_class_details_is_added_in_the_data_table() {

		System.out.println("New class successfully added!");
		String message = ANCPage.toastMsg();
		System.out.println(message);
		Assert.assertTrue(message.contains("Success"));
	}

	@When("Admin enters all mandatory field values with invalid data and clicks save button {string} and {string}")
	public void admin_enters_all_mandatory_field_values_with_invalid_data_and_clicks_save_button_and(String string,
			String string2) {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@Then("Error message should appear in alert")
	public void error_message_should_appear_in_alert() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@When("Admin selects class date in date picker {string} and {string}")
	public void admin_selects_class_date_in_date_picker_and(String testCase, String sheetName)
			throws InterruptedException {
		FillFormData(sheetName, testCase);
	}

	@Then("Admin should see no of class value is added automatically")
	public void admin_should_see_no_of_class_value_is_added_automatically() {
		String value = ANCPage.getNumOfClasses();
		System.out.println(value);
		assertEquals(value, expectedResult);

	}

	@When("Admin clicks date picker")
	public void admin_clicks_date_picker() {
		ANCPage.getDatePicker();
	}

	@Then("Admin should see weekends dates are disabled to select")
	public void admin_should_see_weekends_dates_are_disabled_to_select() {
		// Locate all the date elements in the calendar
		List<WebElement> weekendDates = driver.findElements(By.xpath("//td[contains(@class, 'p-disabled')]"));

		// Verify that Saturday (Sa) and Sunday (Su) are disabled
		for (WebElement weekend : weekendDates) {
			String dateText = weekend.getText();
			Assert.assertTrue(weekend.getAttribute("class").contains("p-disabled"),
					"Weekend date " + dateText + " is not disabled!");
		}
	}

	@When("Admin skips adding value in the mandatory fields and enters a value in the optional field {string} and {string}")
	public void admin_skips_adding_value_in_the_mandatory_fields_and_enters_a_value_in_the_optional_field_and(
			String testCase, String sheetName) throws InterruptedException {
		FillFormData(sheetName, testCase);
		ANCPage.clickSaveButton();
	}

	@Then("Admin should see an error message below mandatory field {string}, it should be highlighted in red color")
	public void admin_should_see_an_error_message_below_mandatory_field_it_should_be_highlighted_in_red_color(String fieldName) {
		if (fieldName == "BatchName") {
			Assert.assertTrue(ANCPage.isBatchNameFieldReq());
		} else if (fieldName == "ClassTopic") {
			Assert.assertTrue(ANCPage.isClassTopicFieldReqMsg());
		} else if (fieldName == "ClassDates") {
			Assert.assertTrue(ANCPage.isClassDatesReqMsg());
		} else if (fieldName == "StaffName") {
			Assert.assertTrue(ANCPage.isStaffNameReqMsg());
		} else if (fieldName == "Status") {
			Assert.assertTrue(ANCPage.isStatusReqMsg());
		}

	}

}
