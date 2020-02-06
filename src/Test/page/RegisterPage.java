package Test.page;


import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class RegisterPage {

	WebDriver driver;
	WebDriverWait wait;
	
	private static final By LOGIN_DIV          = By.id("login-form");
	
	private static final By REGISTER_DIV           = By.id("registration-form");
	
	private static final String INPUT_TEMPLATE     = "%sControl";
	
	private static final By QUESTION_DROPDON       = By.cssSelector("mat-select[name='securityQuestion']");
	
	private static final String QUESTION_OPTION    = "mat-option-1";
	
	private static final By QUESTION_DIV           = By.id("cdk-overlay-2");
	
	private static final By REGISTER_BTN           = By.id("registerButton");
	
	
	public RegisterPage(WebDriver drv) {
		driver = drv;
		wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.visibilityOfElementLocated(REGISTER_DIV));
	}
	
	public RegisterPage createNewUser() throws InterruptedException {
		String[] user  = userInfo();
		Thread.sleep(5000);
		enterUserInfo(user);
		selectQuestion();
		enterAnswer();
		Thread.sleep(5000);
		return this;
	}
	
	public RegisterPage createFalseUser() throws InterruptedException {
		String[] falseUser  = falseUserInfo();
		Thread.sleep(5000);
		enterUserInfo(falseUser);
		selectQuestion();
		enterAnswer();
		Thread.sleep(5000);
		return this;
	}
	
	private void enterUserInfo(String[] user) {
		String[] field = inputFields();
		
		for(int i = 0; i < field.length; i++) {
			input(field[i]).sendKeys(user[i]);
		}
	}
	
    private void selectQuestion() throws InterruptedException {
    	WebElement questionDropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(QUESTION_DROPDON));
    	questionDropdown.click();
    	questionDropdown.sendKeys(Keys.ENTER);
    }
    
    private void enterAnswer() {
    	input("securityAnswer").sendKeys("Bill");
    }
    
    private WebElement input(String type) {
		return wait.until(ExpectedConditions.elementToBeClickable(By.id(String.format(INPUT_TEMPLATE, type))));
	}
	
    private String[] userInfo() {
        return new String[] { randEmail()+"@gmail.com", "123456", "123456" };
    }
    
    private String[] falseUserInfo() {
    	return new String[] { randEmail(), "23456", "123456" };
    }
    
    private String randEmail() {
    	//For the sake of testing purposes, this random string generator was from
    	//https://www.baeldung.com/java-random-string
    	
    	int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 10;
        Random random = new Random();
     
        return random.ints(leftLimit, rightLimit + 1)
          .limit(targetStringLength)
          .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
          .toString();
    }
    
    private String[] inputFields() {
    	return new String[] { "email" , "password" , "repeatPassword" };
    }
	
	public boolean isSuccessful() {
		try {
			WebElement registerBtn = wait.until(ExpectedConditions.elementToBeClickable(REGISTER_BTN));
			registerBtn.click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(LOGIN_DIV));
			return true;
		} catch(TimeoutException e) {
			return false;
		}
		
	}
	
	
}
