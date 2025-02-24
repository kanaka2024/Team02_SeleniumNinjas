package utils;

import java.util.List;
import java.util.Map;

import driverFactory.DriverFactory;
import pageObjects.AddNewClassPage;

public class ClassDataHelper {
	private static String createdClassTopic;
	private ExcelReader excelReader;
	private AddNewClassPage ANCPage;
	private String expectedResult;

	// Constructor to initialize ExcelReader
	public ClassDataHelper() {
		this.excelReader = new ExcelReader();
		this.ANCPage = new AddNewClassPage(DriverFactory.getDriver());
	}

	public String fillFormData(String sheetName, String testCase, boolean isAdd) throws InterruptedException {
		List<Map<String, String>> exlData = excelReader.getData("./src/test/resources/TestData/TestData.xlsx",
				sheetName);
		String classTopic = "";
		for (Map<String, String> data : exlData) {
			if (data.get("TestCase").equalsIgnoreCase(testCase)) {
				System.out.println("Test Data Found: " + data);

				if (isAdd) {
					ANCPage.enterBatchName(data.get("BatchName")); // To do: get Batch name from Anusuya
					ANCPage.enterClassTopic(data.get("ClassTopic"));
					classTopic=data.get("ClassTopic");
				}

				ANCPage.enterClassDescription(data.get("ClassDescription"));
				ANCPage.selectClassDates(data.get("SelectClassDates"));
				ANCPage.enterStaffName(data.get("StaffName"));
				ANCPage.selectStatus(data.get("Status"));
				ANCPage.enterComments(data.get("Comments"));
				ANCPage.enterNotes(data.get("Notes"));
				ANCPage.selectRecordingOption(data.get("Recording"));
				expectedResult= data.get("ExpectedResult");
			}
		}
		return classTopic;
	}

	public static void setCreatedClassTopic(String classTopic) {
		createdClassTopic = classTopic;
	}

	public String getCreatedClassTopic() {
		return createdClassTopic;
	}
	
	public String getExpectedResult() {
		return expectedResult;
	}

}
