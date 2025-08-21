package pages;
import java.time.Duration;

import org.openqa.selenium.By;
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
    private By smsChannel = By.xpath("/html/body/div[4]/div/div[1]/div/div[1]/div[3]");
    private By emailChannel = By.xpath("//*[text()='Email']");
    private By nextBtn = By.xpath("//span[text()='Customise and Send']");
    private By campaignTitleField = By.xpath("//input[@placeholder='Enter Title']");
    private By submitBtn = By.xpath("//button[@type='submit']");
    private By testCampaignBtn = By.xpath("//span[text()='Test campaign']");

    public CampaignPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    // Helper method to clear and type text
    private void clearAndType(By locator, String text) {
        WebElement field = wait.until(ExpectedConditions.elementToBeClickable(locator));
        field.sendKeys(Keys.CONTROL + "a"); // Select all text
        field.sendKeys(Keys.DELETE);        // Delete
        field.sendKeys(text);
    }

    // Helper method to click submit multiple times (if needed)
    private void clickMultipleSubmits(int count) {
        for (int i = 0; i < count; i++) {
            wait.until(ExpectedConditions.elementToBeClickable(submitBtn)).click();
        }
    }

    public void createCampaign(String campaignTitle) {
        // Navigate to Campaigns
        wait.until(ExpectedConditions.elementToBeClickable(campaignsMenu)).click();

        // Select Template
        WebElement template = wait.until(ExpectedConditions.elementToBeClickable(templateCard));
        new Actions(driver).moveToElement(template).click().perform();

        // Select SMS Channel
        wait.until(ExpectedConditions.visibilityOfElementLocated(smsChannel)).click();

        // Click Next
        wait.until(ExpectedConditions.elementToBeClickable(nextBtn)).click();

        // Select Email (if required)
        wait.until(ExpectedConditions.elementToBeClickable(emailChannel)).click();

        // Submit steps (repeated clicks)
        clickMultipleSubmits(5);

        // Enter Campaign Title
        clearAndType(campaignTitleField, campaignTitle);

        // Final Submit
        wait.until(ExpectedConditions.elementToBeClickable(submitBtn)).click();

        // Click Test Campaign
        wait.until(ExpectedConditions.elementToBeClickable(testCampaignBtn)).click();
    }
}
