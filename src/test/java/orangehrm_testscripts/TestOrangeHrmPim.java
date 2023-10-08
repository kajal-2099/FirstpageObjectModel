package orangehrm_testscripts;

	import org.openqa.selenium.WebDriver;
	import org.testng.Assert;
	import org.testng.annotations.AfterMethod;
	import org.testng.annotations.BeforeMethod;
	import org.testng.annotations.Test;

import orangehrm_webpages.AddEmployeePage;
import orangehrm_webpages.HomePage;
import orangehrm_webpages.LoginPage;
import orangehrm_webpages.PersonalDetailsPage;
import orangehrm_webpages.PimHomePage;
import utilities.SeleniumUtility;

	
public class TestOrangeHrmPim extends SeleniumUtility{
	LoginPage getLoginPage;
	HomePage getHomePage;
	PimHomePage getPimHomePage;
	AddEmployeePage getAddEmployeePage;
	@BeforeMethod
	public void precondition() {
		WebDriver driver=setUp("chrome", "https://opensource-demo.orangehrmlive.com/");
		getLoginPage=new LoginPage(driver);
		getHomePage=new HomePage(driver);
		getPimHomePage=new PimHomePage(driver);
		getAddEmployeePage=new AddEmployeePage(driver);
		getLoginPage.loginIntoOrangeHrm("Admin", "admin123");
		getHomePage.clickOnPIM();
	}
	@Test
	public void testPimCreation() {
		getPimHomePage.clickOnAddButton();
		getAddEmployeePage.createEmployee("Mobile", "Lead", 12345);
		getHomePage.clickOnPIM();
		getPimHomePage.searchCreatedEmployee(12345);
		String acutalMsg=getPimHomePage.getSearchResultMsg();
		String expectedMsg="(1) Record Found";
		Assert.assertEquals(acutalMsg, expectedMsg);
	}
//	@Test(dependsOnMethods="testPimCreation")
//	public void testPimEdit() {
//		//TODO: 
//	}
	
	@Test(dependsOnMethods="testPimCreation")
	public void testPimDeletion() {
		getHomePage.clickOnPIM();
		getPimHomePage=new PimHomePage(driver);
		getPimHomePage.searchCreatedEmployee(12345);
		getPimHomePage.deleteCreatedEmployee();
		String acutalMsg=getPimHomePage.getSearchResultMsg();
		String expectedMsg="No Records Found";
		Assert.assertEquals(acutalMsg, expectedMsg);
	}
	@AfterMethod
	public void postcondition() {
		getHomePage.logoutFromHrm();
		//tearDown();
	}
}