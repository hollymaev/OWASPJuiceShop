package Test.tests;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import Test.page.HomePage;
import Test.page.LoginPage;
import Test.page.RegisterPage;

public class InitialTest extends BaseTest{

	@Test
	public void canRegisterNewUser() throws InterruptedException {
		open();
		
		HomePage home = new HomePage(driver).closePopup();
		home.goToAccount().login();
		
		new LoginPage(driver).newUser();
		RegisterPage register = new RegisterPage(driver).createNewUser();
		
		assertTrue(register.isSuccessful(), "Submission was not completed");
	} 
	
	@Test
	public void cannotRegisterNewUserValidation() throws InterruptedException {
		open();
		HomePage home = new HomePage(driver).closePopup();
		home.goToAccount().login();
		
		new LoginPage(driver).newUser();
		
		RegisterPage register = new RegisterPage(driver).createFalseUser();
		
		assertFalse(register.isSuccessful(), "Submission was validated incorrectly");
	}
	
}
