//package orangehrm_testscripts;
//
//import org.openqa.selenium.WebDriver;
//import org.testng.Assert;
//import org.testng.annotations.AfterTest;
//import org.testng.annotations.BeforeTest;
//import org.testng.annotations.Test;
//
//import orangehrm_webpages.HomePage;
//import orangehrm_webpages.LoginPage;
//import utilities.SeleniumUtility;
//
//public class TestOrangeHrmLogin extends SeleniumUtility {
//	WebDriver driver;
//	LoginPage getLoginPage;
//	HomePage getHomePage;
//	@BeforeTest
//	public void preCondition() {
//		driver=setUp("chrome", "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
//		getLoginPage=new LoginPage(driver);
//		getHomePage=new HomePage(driver);
//	}
//
//	@Test
//	public void testWithValidData() {
//		getLoginPage.enterUsername("Admin");
//		getLoginPage.enterPassword("admin123");
//		getLoginPage.clickOnLoginButton();
//				//or
//		//getLoginPage.loginIntoOrangeHrm("Admin", "admin123");
//		Assert.assertTrue(isElementExist(getHomePage.getUserProfileLink()),"Either login failed or user profile changed");
//	}
//	
//	@Test
//	public void testWithInvalidData() {
//		typeInput(getLoginPage.getUsernameInputField(), "dummy");
//		typeInput(getLoginPage.getPasswordInputField(), "admin123");
//		clickOnElement(getLoginPage.getLoginButton());
//				//or
//		//getLoginPage.loginIntoOrangeHrm("Admin", "admin123");
//		Assert.assertTrue(isElementExist(getLoginPage.getLoginButton()),"Even after entering invalid data, user is able to login");
//		
//	}
//	@AfterTest
//	public void postCondition() {
//		getHomePage.logoutFromOrangeHrm();
//		cleanUp();
//	}
//}
