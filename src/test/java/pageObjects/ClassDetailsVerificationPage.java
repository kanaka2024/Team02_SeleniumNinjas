package pageObjects;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.commonFunctions;

public class ClassDetailsVerificationPage {
	
private WebDriver driver;
commonFunctions cf;
	
	public ClassDetailsVerificationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		cf=new commonFunctions(driver, 30);
	}
	
	@FindBy(xpath = "//span[starts-with(@id, 'pr_id')]")
	private WebElement classDetails;
	
	@FindBy(xpath="//button[normalize-space()='Add New Class']")
	private WebElement addNewCls;
	
	//private By classDetails = By.id("pr_id_38-label");
	
//	public void AddClassPage() {
//		Alert alert = driver.switchTo().alert();
//		String alertText = alert.getText();
//		alert.accept();
//	}
	
	public void getpopup() {
		addNewCls.click();	
		
	}
	
	public String getCD() throws InterruptedException
	{
		Thread.sleep(2000);
		System.out.println(classDetails.getText());
		return classDetails.getText();
		
		
	}


}
