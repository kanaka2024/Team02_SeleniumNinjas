package pageObjects;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import driverFactory.DriverFactory;
import utils.CommonFunctions;
import utils.ExcelReader;
//import utils.batchRecords;
import utils.ExcelReader.batchRecords;

public class batchModule {
	public WebDriver driver;
	public CommonFunctions comMethod;
	public WebDriverWait wait;
	public ExcelReader readbatch = new ExcelReader();

	// Locators
	By batchButton = By.xpath("//*[@class='ng-star-inserted']/button[3]");
	By pageName = By.xpath("//*[@class='ng-star-inserted']/button[3]/span[1]");
	By batchLabel = By.xpath("//*[@class='mat-card mat-focus-indicator']/mat-card-title/div[1]");
	By B_Delete = By.xpath("//*[@class='mat-card-title']/div[2]/div/button");
	By navigateStatus = By.xpath("//*[@class='p-paginator-pages ng-star-inserted']");
	By editiconui = By.xpath("//*[@class='p-button-icon pi pi-pencil']");
	By deleteiconui = By.xpath("//*[@class='p-button-icon pi pi-trash']");
	By sorticon = By.xpath("//*[@class='p-sortable-column-icon pi pi-fw pi-sort-alt']");
	By checkboxui = By.xpath("//*[@class='p-datatable-tbody']/tr/td[1]/p-tablecheckbox");
	By headerpath = By.xpath("//*[@class='p-datatable-thead']/tr/th");
	By checkboxvalidate = By.xpath("//*[@class='p-datatable-thead']/tr/th/p-tableheadercheckbox");
	// By Addbatch = By.xpath("//*[@class='mat-menu-content
	// ng-tns-c225-3']");c230-53'
	By Addbatch = By.xpath("//button[@role='menuitem']");
	//// button[normalize-space()='Add New Batch']
	By closebatch = By.xpath("//*[@class='p-dialog-header-close-icon ng-tns-c81-9 pi pi-times']");
	By Addbatchheader = By.xpath("//*[@id='pr_id_3-label']");

	// Add batch locators
	By batchprogramName = By.xpath("//*[@role='button']");
	By batchprogmatch = By.xpath("//*[@id='programName']/div/input");
	By batchprogdropdown = By.xpath("//*[@id='programName']/div/div[2]/span");
	By batchproglist = By.xpath("//*[contains(@class,'p-dropdown-items ng-tns-c88')]/p-dropdownitem/li/span");

	// p-dropdown-items-wrapper ng-tns-c88-66
	// *[contains(@class,'p-toast-summary ng-tns-c91')]
	By batchBName1 = By.xpath("//*[@id='batchProg']");
	By batchBName2 = By.xpath("//*[@pattern='^[0-9]{0,5}$']");
	By batchDesc = By.xpath("//*[@id='batchDescription']");
	// By batchstatusActive= By.xpath("//*[@ng-reflect-input-id='ACTIVE']");
	By batchstatusActive = By.xpath("(//p-radiobutton[@name='category']//div[@class='p-radiobutton-box'])[1]");
	By batchstatusInactive = By.xpath("(//p-radiobutton[@name='category']//div[@class='p-radiobutton-box'])[2]");
	By batchNoOfClass = By.xpath("//*[@id='batchNoOfClasses']");
	By batchCancelbutton = By.xpath("//*[@label='Cancel']']");
	By batchSavebutton = By.xpath("//*[@label='Save']");

	By BatchTxt = By.xpath("//*[text()='Batch']");
	By Searchbatch = By.xpath("//*[@id='filterGlobal']");
	By reacordtxt = By.xpath("//*[@class='p-datatable-tbody']/tr[1]/td[2]");

	By SuccessMSg = By.xpath("//*[contains(@class,'p-toast-message-content ng-tns-c91')]");
	By SuccessMSgclose = By.xpath("//*[contains(@class,'p-toast-icon-close-icon pi pi-times na-†ns-c91')]");
	By Session = By
			.xpath("//*[@class='cdk-overlay-backdrop cdk-overlay-transparent-backdrop cdk-overlay-backdrop-showing']");

	public batchModule(WebDriver driver) {
		this.driver = driver;
		this.comMethod = new CommonFunctions(DriverFactory.getDriver(), 20);

	}

	public void landbatchpage() {
		WebElement batchbutton = comMethod.elementToBeClickable(batchButton);
		batchbutton.click();
		Actions actions = new Actions(driver);
		actions.moveByOffset(200, 300).click().perform();

	}

	public String checkBatchpage() {
		// landbatchpage();
		String label = driver.findElement(pageName).getText();
		return label;

	}

	public String currentUrl() {
		return driver.getCurrentUrl();
	}

	By ttitle = By.xpath("//span[text()=' LMS - Learning Management System ']");

	public String title() {
		
		return driver.findElement(ttitle).getText();
	}

	public String batchheading() {

		WebElement batchlabel = comMethod.visibilityOfElementLocated(batchLabel);
		String label = batchlabel.getText();
		return label;

	}

	public boolean H_deleteIcon() {
		WebElement deleteicon = comMethod.visibilityOfElementLocated(B_Delete);
		return deleteicon.isDisplayed();
	}

	public boolean pageNavigate() {
		WebElement navigateState = comMethod.visibilityOfElementLocated(navigateStatus);
		return navigateState.isEnabled();
	}

	public boolean editIcon() {
		List<WebElement> editiconUI = comMethod.visibilityOfAllElementsLocated(editiconui);
		System.out.println("Size edit : " + editiconUI.size());
		boolean editiconstatus = comMethod.tableRowUIElements(editiconUI);
		return editiconstatus;
	}

	public boolean deleteIcon()

	{
		List<WebElement> deleteiconUI = comMethod.visibilityOfAllElementsLocated(deleteiconui);
		boolean deleteiconstatus = comMethod.tableRowUIElements(deleteiconUI);
		return deleteiconstatus;
	}

	public boolean checkBox()

	{
		List<WebElement> checkboxUI = comMethod.visibilityOfAllElementsLocated(checkboxui);
		boolean checkboxstatus = comMethod.tableRowUIElements(checkboxUI);
		return checkboxstatus;
	}

	public boolean tableHeaders()

	{

		List<WebElement> headerelements = comMethod.visibilityOfAllElementsLocated(headerpath);
		List<String> Headers = Arrays.asList("Batch Name", "Batch Description", "Batch Status", "No Of Classes",
				"Program Name", "Edit / Delete");
		boolean headerresult = comMethod.tableHeaders(headerelements, Headers);
		return headerresult;
	}

	// method for AddBatchclick
	public void batchaddclick() {
		WebElement batchh = comMethod.presenceOfElementLocated(batchButton);
		batchh.click();
		WebElement Add = comMethod.presenceOfElementLocated(Addbatch);

		Add.click();

	}
	// method for closeaddBatchclick

	public void batchaddclose() {

		WebElement Addclose = comMethod.presenceOfElementLocated(closebatch);

		Addclose.click();

	}

	public boolean checkboxvalidate() {

		// driver.findElement(batchButton).click();

		// batchaddclick();
		// batchaddclose();

		WebElement checkAll = comMethod.elementToBeClickable(checkboxvalidate);

		checkAll.click();
		List<WebElement> checkboxUI = comMethod.visibilityOfAllElementsLocated(checkboxui);
		for (WebElement e : checkboxUI) {
			comMethod.visibilityOfAllElementsLocated(checkboxui);

			if (!e.isSelected()) {
				System.out.println("checkbox  is not checked in row No: ");
				return false;
			}
		}
		return true;
	}

	public boolean sortIcon()

	{

		List<WebElement> sorticonUI = comMethod.visibilityOfAllElementsLocated(sorticon);
		boolean sorticonstatus = comMethod.tableRowUIElements(sorticonUI);
		return sorticonstatus;
	}

	// ----------------Add New BatchUI--------------//

	public String addbatchUI() {

		landbatchpage();
		WebElement Add = comMethod.presenceOfElementLocated(Addbatch);

		String name = Add.getText();

		return name;

	}

	public String addbatchpopup() {
		batchaddclick();
		WebElement batchheader = comMethod.presenceOfElementLocated(Addbatchheader);
		String bname = batchheader.getText();
		System.out.println(bname);
		batchaddclose();
		return bname;

	}

	// -----------------------------Add New Batch----------------------//

	public String addbatch(String Pname) throws IOException {

		List<batchRecords> batchRecordlist = new ArrayList<>();
		batchRecordlist = readbatch.readExcel_LMSPrograms(Pname);

		try {
			if (batchRecordlist != null) {

				for (batchRecords record : batchRecordlist) {
					landbatchpage();
					batchaddclick();
					WebElement batch_progmatch = comMethod.presenceOfElementLocated(batchprogmatch);
					batch_progmatch.clear();
					WebElement batchprog_dropdown = comMethod.presenceOfElementLocated(batchprogdropdown);
					batchprog_dropdown.click();
					List<WebElement> BatchpageProgList = comMethod.presenceOfElementsLocated(batchproglist);
					System.out.println("BatchpageProgList Size: " + BatchpageProgList.size());
					// Iterate through options and add text to the list
					for (int i = 0; i <= BatchpageProgList.size() - 1; i++) {
						String B_ProgName = BatchpageProgList.get(i).getText();
						// System.out.println("BatchpageProgList: "+B_ProgName);
						if (B_ProgName.equalsIgnoreCase(record.getProgramName())) {
							BatchpageProgList.get(i).click();
							break;
						}

					}

					// Log.info("Batch Extracted from the excel");
					WebElement batchB_Name2 = comMethod.presenceOfElementLocated(batchBName2);
					// batchB_Name2.click();

					batchB_Name2.sendKeys(record.getBatchName());
					// Log.info("batch no is entering");
					WebElement batch_Desc = comMethod.visibilityOfElementLocated(batchDesc);
					batch_Desc.sendKeys(record.getDescription());
					WebElement batchstatus_Active = comMethod.elementToBeClickable(batchstatusActive);
					batchstatus_Active.click();
					WebElement batch_NoOfClass = comMethod.presenceOfElementLocated(batchNoOfClass);
					batch_NoOfClass.sendKeys(record.getNoOfClass());
					// batchprogramName.sendKeys("ChatBotTest");
					WebElement batch_Savebutton = comMethod.elementToBeClickable(batchSavebutton);
					batch_Savebutton.click();
				}
			}
		} catch (Exception e) {
			System.out.println("Record completed");
		}
		String Succes_msg = handlealert();

		return Succes_msg;

	}

	public String handlealert() {
		By toastLocator = By.cssSelector("div.p-toast-message-content[role='alert']");

		// Wait for the toast to appear
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		WebElement toastElement = wait.until(ExpectedConditions.visibilityOfElementLocated(toastLocator));

		// Retrieve and print the toast message text
		String toastMessage = toastElement.getText();
		System.out.println("Toast Message: " + toastMessage);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(toastLocator));
		return toastMessage;
	}
	
	
	
	//-----------------------------Delete Batch Validation---------------------//

	
	By deletelist=By.xpath("//*[@class='p-button-rounded p-button-danger p-button p-component p-button-icon-only']");
	public boolean deleteIconclicked()

	{
		List<WebElement> deleteiconUI = comMethod.visibilityOfAllElementsLocated(deletelist);

		// Check if the list is not empty before interacting
		if (!deleteiconUI.isEmpty()) {
		    deleteiconUI.get(0).click(); // Click the first delete icon in the row
		    return true; // Return true if clicked successfully
		} else {
		    System.out.println("No delete icons found.");
		    return false; // Return false if no delete icons are found
		}
	}
	
	
	By deleteConfirm=By.xpath("//*[@class='p-dialog-header-icons ng-tns-c118-11']//span");
	
	public String confirmDeletePopup() {
		
		
		WebElement popheader = comMethod.presenceOfElementLocated(deleteConfirm);
		String bname = popheader.getText();
		System.out.println(bname);
		return bname;

	}
	By yesdeleteConfirm=By.xpath("//span[@class='p-button-icon p-button-icon-left pi pi-check']");

	public void ConfirmDeleteYes()
	{
		WebElement yesconfirm = comMethod.presenceOfElementLocated(yesdeleteConfirm);
		yesconfirm.click();
		
	}
	By nodeleteConfirm=By.xpath("//span[@class='p-button-icon p-button-icon-left pi pi-times']");

	public void ConfirmDeleteNo()
	{
		WebElement noconfirm = comMethod.presenceOfElementLocated(nodeleteConfirm);
		noconfirm.click();
			
	}
	By deleteClose=By.xpath("//*[@class='p-dialog-header-icons ng-tns-c118-11']//span");

	public void deleteClose()
	{
		WebElement dclose = comMethod.presenceOfElementLocated(deleteClose);
		dclose.click();
		
	}
	
	
	public String Deletedhandlealert() {
		By deletetoastLocator = By.cssSelector("p-toast-message-text ng-tns-c20-25 ng-star-inserted");

		// Wait for the toast to appear
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		WebElement toastElement = wait.until(ExpectedConditions.visibilityOfElementLocated(deletetoastLocator));

		// Retrieve and print the toast message text
		String toastMessage1 = toastElement.getText();
		System.out.println("Toast Message: " + toastMessage1);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(deletetoastLocator));
		return toastMessage1;
	}
	
	
	
}
