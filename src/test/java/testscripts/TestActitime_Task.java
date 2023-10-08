package testscripts;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import utilities.SeleniumUtility;
import webpages.ActitimeHomePage;
import webpages.ActitimeLoginPage;

public class TestActitime_Task  extends SeleniumUtility {
	
	ActitimeLoginPage getActitimeLoginPage;
	ActitimeHomePage getActitimeHomePage;
	WebDriver driver;
	@BeforeMethod
	public void precondition() {
		driver=setUp(getValueFromPropertyFile("browserName"),
				getValueFromPropertyFile("appUrl"));
		getActitimeLoginPage=new ActitimeLoginPage(driver);
		getActitimeHomePage=new ActitimeHomePage(driver);		
		getActitimeLoginPage.loginIntoActiTimeApplication(getValueFromPropertyFile("username"), getValueFromPropertyFile("password"));
		getActitimeHomePage.selectTab("Tasks");
	}
	@Test
	public void testTaskCreation() {
		
	}
	@Test
	public void testTaskStatusUpdate() {
		
	}
	@Test
	public void testTaskDeletion() {
		
	}
	@AfterMethod
	public void postcondition() {
		getActitimeHomePage.clickOnLogout();
		cleanUp();
	}
}
