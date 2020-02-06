package Test.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
	
	WebDriver driver;
	WebDriverWait wait;

	private static final By LOGIN_DIV          = By.id("login-form");
	
	private static final By NEW_ACCOUNT_LINK   = By.id("newCustomerLink");
	
	public LoginPage (WebDriver drv) {
		driver = drv;
		wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.visibilityOfElementLocated(LOGIN_DIV));
	}
	
	public LoginPage newUser() {
		WebElement registerLink = wait.until(ExpectedConditions.elementToBeClickable(NEW_ACCOUNT_LINK));
		registerLink.click();
		return this;
	}
	
}
