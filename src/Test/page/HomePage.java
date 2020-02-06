package Test.page;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.SkipException;

public class HomePage {

	WebDriver driver;
	WebDriverWait wait;
	
	private static final By CLOSE_POPUP_WINDOW = By.cssSelector("button[aria-label='Close Welcome Banner']");
	private static final By POPUP_WINDOW       = By.id("mat-dialog-0");

	private static final By ACCOUNT_BTN        = By.id("navbarAccount");
	
	private static final By LOGIN_BTN          = By.cssSelector("button[aria-label='Go to login page']");

	
	
	public HomePage(WebDriver drv) {
		driver = drv;
		wait = new WebDriverWait(driver, 15);
	}
	
	public HomePage closePopup() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(POPUP_WINDOW));
		
		try {
			
			WebElement closeButton = wait.until(ExpectedConditions.elementToBeClickable(CLOSE_POPUP_WINDOW));
			closeButton.click();
			wait.until(ExpectedConditions.invisibilityOfElementLocated(POPUP_WINDOW));
		
		} catch (TimeoutException e) {
			
			throw new SkipException("Popup not visible");
			
		}
		
		return this;
	}
	
	public HomePage goToAccount() {
		WebElement accountNavBar = wait.until(ExpectedConditions.visibilityOfElementLocated(ACCOUNT_BTN));
		accountNavBar.click();
		
		return this;
	}
	
	public HomePage login() {
		WebElement loginBtn = wait.until(ExpectedConditions.elementToBeClickable(LOGIN_BTN));
		loginBtn.click();
		
		return this;
	}
	
	
}
