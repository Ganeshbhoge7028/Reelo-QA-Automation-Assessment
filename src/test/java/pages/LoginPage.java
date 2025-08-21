package pages;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class LoginPage {
	 WebDriver driver;
	    WebDriverWait wait;

	    By signUpLink = By.xpath("//*[text()='Sign up' or text()='Sign Up']");
	    By nameField = By.id("name");
	    By emailField = By.id("email");
	    By mobileField = By.id("number");
	    By passwordField = By.id("password");
	    By signUpBtn = By.xpath("//button[@type='submit']");
	    By Usernamefield =By.id("email");
	    By passwordfield = By.id("password");
	    By loginbutton = By.xpath("//button[@type='submit']");

	    public LoginPage(WebDriver driver) {
	        this.driver = driver;
	        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	    }

	    public void createAccount(String name, String email, String password, String mobileno) {
	        wait.until(ExpectedConditions.elementToBeClickable(signUpLink)).click();
	        wait.until(ExpectedConditions.visibilityOfElementLocated(nameField)).sendKeys(name);
	        driver.findElement(emailField).sendKeys(email);
	       
	        driver.findElement(mobileField).sendKeys(mobileno);
	        driver.findElement(passwordField).sendKeys(password);
	       // driver.findElement(signUpBtn).click();
	        //wait.until(ExpectedConditions.elementToBeClickable(signUpBtn)).click();
	        try {
	            wait.until(ExpectedConditions.elementToBeClickable(signUpBtn)).click();
	        } catch (Exception e) {
	            // If normal click fails, use JS click
	            WebElement button = driver.findElement(signUpBtn);
	            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", button);
	        }
	        
	    }
	    public void LoginAccount(String username, String password) {
	    	driver.findElement(Usernamefield).sendKeys(username);
	    	driver.findElement(passwordfield).sendKeys(password);
	    	driver.findElement(loginbutton).click();
	    	
	    }
	    
}
