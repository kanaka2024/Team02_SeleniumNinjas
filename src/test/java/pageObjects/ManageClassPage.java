package pageObjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.Constants;

public class ManageClassPage {
	
	private WebDriver driver;
	
	public ManageClassPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@id='username']")
	private WebElement username;

	@FindBy(xpath = "//input[@id='password']")
	private WebElement password;

	@FindBy(xpath = "//button[@id='login']")
	private WebElement login;

	//@FindBy(xpath = "//div[@class='mat-select-arrow-wrapper ng-tns-c161-3']")
	@FindBy(xpath = "//div[@id='mat-select-value-1']")
	private WebElement role;

	@FindBy(xpath = "//span[normalize-space()='Admin']")
	private WebElement admin;

	@FindBy(xpath = "//span[normalize-space()='Class']")
	private WebElement classbtn;

	@FindBy(xpath = "//div[normalize-space()='Manage Class']")
	private WebElement ManageClass;

	@FindBy(xpath = "//thead[@class='p-datatable-thead']//tr[@class='ng-star-inserted']/th")
	private List<WebElement> headerColumns;

	@FindBy(xpath = "//input[@id='filterGlobal']")
	private WebElement searchBtn;
	
	@FindBy(xpath = "//th[normalize-space()='Batch Name']")
	private WebElement classBatchName;
	
	@FindBy(xpath = "//th[normalize-space()='Class Topic']")
	private WebElement classTopic;
	
	@FindBy(xpath = "//th[normalize-space()='Class Description']")
	private WebElement classDescription;
	
	@FindBy(xpath = "//th[normalize-space()='Status']")
	private WebElement status;
	
	@FindBy(xpath = "//th[normalize-space()='Class Date']")
	private WebElement classDate;
	
	@FindBy(xpath = "//th[normalize-space()='Staff Name']")
	private WebElement staffName;
	
	@FindBy(xpath = "//th[normalize-space()='Edit / Delete']")
	private WebElement editDeleteBtn;
	
	//pop up window
	@FindBy(xpath = "//div[@class='p-dialog-header ng-tns-c81-15 ng-star-inserted']")
	private WebElement classDetailsOfEditPopup;
	
	//@FindBy(id = "//span[@id='pr_id_9-label']")
	//private WebElement classDetailsOfEditPopup;
	
	@FindBy(xpath = "//input[@id='classDescription']")
	private WebElement classDescriptionOfEdit;
	
	@FindBy(xpath = "//button[@class='p-datepicker-trigger ng-tns-c92-31 p-ripple p-button p-component p-button-icon-only ng-star-inserted']")
	private WebElement datePickerOfEdit;
	
	@FindBy(xpath = "//input[@id='classNo']")
	private WebElement NumOfClassesOfEdit;
	
	@FindBy(xpath = "//input[@placeholder='Select a Staff Name']")
	private WebElement staffNameOfEdit;
	
	@FindBy(xpath = "//input[@id='classComments']")
	private WebElement commentsOfEdit;
	
	@FindBy(xpath = "//input[@id='classNotes']")
	private WebElement notesOfEdit;
	
	@FindBy(xpath = "//input[@id='classRecordingPath']")
	private WebElement recordingOfEdit;
	
	@FindBy(xpath = "//button[@id='saveClass']")
	private WebElement saveBtnOfEdit;
	
	@FindBy(xpath = "//button[@class='p-button-rounded p-button-danger p-button p-component ng-star-inserted']")
	private WebElement cancelBtnOfEdit;
	
	//pending of active and inactive of edit
	
	
	@FindBy(xpath = "//button[@class='p-button-rounded p-button-success p-button p-component p-button-icon-only']")
	private WebElement classEditBtn;
	
	@FindBy(xpath = "//span[@class='p-button-icon pi pi-trash']")
	private WebElement classDeleteBtn;
	
	//By deletePopup = By.xpath("//span[@class='p-button-icon pi pi-trash']");
	@FindBy(xpath = "//span[@class='p-button-icon pi pi-trash']")
	private WebElement deletePopup;
	
	@FindBy(xpath = "//span[normalize-space()='No']")
	private WebElement deleteNoBtn; 
	
	@FindBy(xpath = "//span[normalize-space()='Yes']")
	private WebElement deleteYesBtn; 
	
	
//	By succesfulMessasge = By.xpath("//*[text()='Successful']");
//	By userDeleteMessage= By.xpath("//*[text()='User Deleted']");
	
	
	@FindBy(xpath = "//button[text()='2']")
	private WebElement nextPage;
	
	@FindBy(xpath = "//span[@class='p-paginator-icon pi pi-angle-double-right']")	
	private WebElement DoubleArrowIcon;
	
	//div[@class='p-datatable-footer ng-star-inserted']
	//div[@class='p-d-flex p-ai-center p-jc-between ng-star-inserted']
	
	@FindBy(xpath = "//div[@class='p-d-flex p-ai-center p-jc-between ng-star-inserted']")	
	private WebElement screenFooterText ;
	
	
	//div[@class='p-paginator-bottom p-paginator p-component ng-star-inserted']
	
	@FindBy(xpath = "//span[@class='p-paginator-icon pi pi-angle-right']")
	private WebElement SingleRightArrowbutton;
	
	@FindBy(xpath = "//div[@class='p-d-flex p-ai-center p-jc-between ng-star-inserted']")
	private WebElement footerTxt;
	
	@FindBy(xpath = "//span[@class='p-paginator-current ng-star-inserted']")
	private WebElement Pgtntxt ;	
	
	
	//By nextPage = By.xpath("//button[text()='2']");
	 //By DoubleArrowIcon = By.xpath("//span[@class='p-paginator-icon pi pi-angle-double-right']") ;

	
	public void getloginUrl() throws InterruptedException {
		driver.get(Constants.baseUrl);
		username.sendKeys("sdetnumpyninja@gmail.com");
		password.sendKeys("Feb@2025");
		role.click();
		admin.click();
		login.click();

	}

	public String getManageClassPageTitle() {
		return ManageClass.getText();
	}

	public void Classbutton() {

		classbtn.click();
	}

	public boolean verifyGridHeaders(List<String> expectedHeaders) {
		for (int i = 1; i < expectedHeaders.size(); i++) {
			
//			System.out.println(headerColumns.get(i).getText());
//			System.out.println(expectedHeaders.get(i));
			
			if (!headerColumns.get(i).getText().equals(expectedHeaders.get(i))) {
				return false;
			}
		}
		return true;
	}
	
	//Searchbox validation
		public boolean srchBox() throws InterruptedException
		{
			Thread.sleep(2000);
			boolean issearch =  searchBtn.isDisplayed();	
			return issearch;	
			
		}
		
		public String srchtxt()
		{
			return searchBtn.getAttribute("placeholder");	
		}
		
		public boolean getPaginationtxt()
		{
			return Pgtntxt.isDisplayed();	
		}
		public boolean getFootertxt()
		{
			return footerTxt.isDisplayed();		
		}

	

}
