package utils;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class commonFunctions {

	private WebDriver driver;
	private WebDriverWait wait;

	// Constructor initializes WebDriver and WebDriverWait
	public commonFunctions(WebDriver driver, int timeoutInSeconds) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
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

	// Wait for element to be clickable
	public WebElement elementToBeClickable(By locator) {
		return wait.until(ExpectedConditions.elementToBeClickable(locator));
	}

	// Wait for element to be present in the DOM
	public WebElement presenceOfElementLocated(By locator) {
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}

	public List<WebElement> presenceOfElementsLocated(By locator) {
		return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
	}

	// get URL
	public String currentUrl() {
		return driver.getCurrentUrl();
	}

	// Get Title
	public String title() {
		return driver.getTitle();
	}

	// Wait for text to be present in element
	public boolean TextToBePresentInElement(By locator, String text) {
		return wait.until(ExpectedConditions.textToBePresentInElementLocated(locator, text));
	}

	// Wait for an element to be invisible
	public boolean ElementToBeInvisible(By locator) {
		return wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
	}

}
