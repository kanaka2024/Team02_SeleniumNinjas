package utils;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonFunctions {

	private WebDriver driver;
	private WebDriverWait wait;

	public CommonFunctions(WebDriver driver, int timeoutInSeconds) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
	}
	
	
	
	
	//-------------------------Common Methods---------------------//

	// Wait for element to be clickable
	public WebElement elementToBeClickable(By locator) {
		return wait.until(ExpectedConditions.elementToBeClickable(locator));
	}

	// Wait for element to be visibility in element locator
	public WebElement visibilityOfElementLocated(By locator) {

		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

	}

	// Wait for element to be invisibility in element locator
	public boolean invisibilityOfElementLocated(By locator) {

		return wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));

	}

	// Wait for element to be visibility in element locator
	public List<WebElement> visibilityOfAllElementsLocated(By locator) {

		return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));

	}

	// Wait for element to be enabled
	public WebElement waitForElementToBeEnabled(By locator) {
		WebElement e = visibilityOfElementLocated(locator);
		wait.until(driver -> e.isEnabled());
		return e;
	}

	// Wait for element to be displayed
	public WebElement ElementToBeDisplayed(By locator) {
		WebElement e = visibilityOfElementLocated(locator);
		wait.until(driver -> e.isDisplayed());
		return e;
	}

	// Wait for element to be displayed
	public WebElement ElementToBeSelected(By locator) {
		WebElement e = visibilityOfElementLocated(locator);
		wait.until(driver -> e.isSelected());
		return e;
	}
	
	
	// Wait for element to be present in the DOM
    public WebElement presenceOfElementLocated(By locator) {
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }
    public List<WebElement> presenceOfElementsLocated(By locator) {
        return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
    }
	
	//------------------tableUI Validation------------------------//
	
	// Validation of headers in the table
    public boolean tableHeaders(List<WebElement> e,List<String> headerName) {
        if(e!=null) {
        for (int i = 1; i < e.size()-1; i++) {
            String actualHeader = e.get(i).getText().trim();
            if (!actualHeader.equals(headerName.get(i-1))) {
                System.out.println("Header mismatch in " + (i) + ". Expected Header : " 
                                   + headerName.get(i) + ", Actual Header : " + actualHeader);
                return false;
            }
        }}
        else
        {
        	System.out.println("No Elements found");
        }
        return true; // All headers match
    }

    // Validate presence of UI elements in each row (e.g., edit icon, checkbox)
    public boolean tableRowUIElements(List<WebElement> icons) {

        boolean alliconsValid = true;
       // Check if the edit icon is present
        for(int i=0;i<=icons.size()-1;i++)
		{
        	if(!icons.get(i).isDisplayed()) {
        	    System.out.println("Icon  is not visible in row No: " +i);
        	    alliconsValid = false;
            }
		}
         return alliconsValid;
    }

    public void waitForPageToLoad(WebDriver driver) {
      //  WebDriverWait wait = new WebDriverWait(driver, 20); // 20 seconds timeout

        // Wait for JavaScript to finish loading
        wait.until(webDriver -> ((JavascriptExecutor) webDriver)
                .executeScript("return document.readyState").equals("complete"));

        // Wait for jQuery AJAX calls to complete (if applicable)
        wait.until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return (Boolean) ((JavascriptExecutor) driver)
                        .executeScript("return (window.jQuery != null) && (jQuery.active === 0);");
            }
        });

        System.out.println("Page loaded completely!");
    }

    
    
    
}
