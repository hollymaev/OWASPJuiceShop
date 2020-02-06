package Test.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

	WebDriver driver;
    WebDriverWait wait;
	
	private static final String URL            = "https://qa-test-simpli.herokuapp.com/";

	
	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "/Users/hollymae/selenium/drivers/chromedriver");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
//	@DataProvider(name = "singleQuery")
//	public String singleQuery() {
//		return "philosophy";
//	}
//	
//    @DataProvider(name = "multiQuery")
//    public Object[][] dataProviderMethod() {
//        return new Object[][] { { "Dinosaurs" }, { "The Big Bang Theory" } };
//    }
	
	public void open() {
		driver.get(URL);
	}
	

}
