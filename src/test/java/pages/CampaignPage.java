package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CampaignPage {
	WebDriver driver;
	WebDriverWait wait;

	// Locators
	private By campaignsMenu = By.xpath("//span[text()='Campaigns']");
	private By templateCard = By.xpath("//h4[normalize-space()='Celebrate Onam with a Grand Feast']/parent::div");

	private By emailChannel = By.xpath("//*[text()='Email']");
	private By nextBtn = By.xpath("//span[text()='Customise and Send']");
	private By campaignTitleField = By.xpath("//input[@placeholder='Enter Title']");
	private By submitBtn = By.xpath("//button[@type='submit']");
	private By fileUploadInput = By.xpath("//input[@type='file']");
	private By save = By.xpath("(//button[@type='submit'])[2]");
	private By EditMassage = By.xpath("//div[@class='textarea']/span[1]");
	private By testCampaignBtn= By.xpath("//span[text()='Test campaign']");
	public CampaignPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
	}

	// File upload method
	public void uploadFile(String filePath) {
		WebElement uploadElement = wait.until(ExpectedConditions.presenceOfElementLocated(fileUploadInput));

		// Make hidden input visible if necessary
		((JavascriptExecutor) driver).executeScript("arguments[0].style.display='block';", uploadElement);

		uploadElement.sendKeys(filePath);
	}

	// Helper method to clear and type text
	private void clearAndType(By locator, String text) {
		WebElement field = wait.until(ExpectedConditions.elementToBeClickable(locator));
		field.sendKeys(Keys.CONTROL + "a"); // Select all text
		field.sendKeys(Keys.DELETE); // Delete
		field.sendKeys(text);
	}

	// Helper method to click submit multiple times (if needed)
	private void clickMultipleSubmits(int count) {
		for (int i = 0; i < count; i++) {
			wait.until(ExpectedConditions.elementToBeClickable(submitBtn)).click();
		}
	}

	public void createCampaign(String campaignTitle, String filePath, String SMSMassage) throws InterruptedException {
		// Navigate to Campaigns
		wait.until(ExpectedConditions.elementToBeClickable(campaignsMenu)).click();

		// Select Template
		WebElement template = wait.until(ExpectedConditions.elementToBeClickable(templateCard));
		new Actions(driver).moveToElement(template).click().perform();

		// Click Next
		wait.until(ExpectedConditions.elementToBeClickable(nextBtn)).click();

		// Select Email (if required)
		wait.until(ExpectedConditions.elementToBeClickable(emailChannel)).click();

		// Submit steps (repeated clicks)
		clickMultipleSubmits(1);

		// Enter Campaign Title
		clearAndType(campaignTitleField, campaignTitle);
		clickMultipleSubmits(2);

		uploadFile(filePath);
		
		wait.until(ExpectedConditions.elementToBeClickable(save)).click();
		
		clickMultipleSubmits(1);
		Thread.sleep(3000);
		clearAndType(EditMassage, SMSMassage);
		
		clickMultipleSubmits(1);
		
		// Click Test Campaign
		 wait.until(ExpectedConditions.elementToBeClickable(testCampaignBtn)).click();
	}
}
