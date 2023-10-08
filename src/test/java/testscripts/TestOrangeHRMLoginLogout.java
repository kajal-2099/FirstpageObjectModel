package testscripts;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import utilities.SeleniumUtility;
import webpages.OrangeHRM_DashboardPage;
import webpages.OrangeHRM_LoginPage;

public class TestOrangeHRMLoginLogout extends SeleniumUtility {
	WebDriver driver;
	OrangeHRM_LoginPage getOrangeHRM_LoginPage;
	OrangeHRM_DashboardPage getOrangeHRM_DashboardPage;

	@BeforeTest
	public void precondition() {
		driver = setUp("chrome", "https://opensource-demo.orangehrmlive.com/");
		// initialize your required WebPage class
		getOrangeHRM_LoginPage = new OrangeHRM_LoginPage(driver);
		getOrangeHRM_DashboardPage = new OrangeHRM_DashboardPage(driver);
	}

	@Test
	public void testLoginLogout() {
		getOrangeHRM_LoginPage.loginInOrangeHrmApplication("Admin", "admin123");
		String expectedHomeUrl="dashboard";
		String actualHomeUrl=getCurrentUrlOfApplication();
		Assert.assertTrue(actualHomeUrl.contains(expectedHomeUrl),"Home page not opened");
	}
	
	@AfterTest
	public void postCondition() {
		getOrangeHRM_DashboardPage.logoutFromApplication();
		cleanUp();
	}
}
