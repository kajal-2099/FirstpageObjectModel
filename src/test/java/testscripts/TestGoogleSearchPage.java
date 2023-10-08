package testscripts;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import utilities.SeleniumUtility;
import webpages.GooglePage;
import webpages.GoogleSearchPage;

public class TestGoogleSearchPage extends SeleniumUtility {

	WebDriver driver;
	GooglePage getGooglePage;
	GoogleSearchPage getGoogleSearchPage;
	
	@BeforeTest
	public void precondition() {
		driver=setUp("chrome", "https://www.google.com");
		getGooglePage=new GooglePage(driver);
		getGoogleSearchPage=new GoogleSearchPage(driver);
	}
	@Test(priority=1)
	public void testGoogleHomePage() {
		Assert.assertEquals(getCurrentTitleOfApplication(), "Google");
	}
	
	@Test(priority=2)
	public void testSuggestionCount() {
		getGooglePage.enterText("Selenium");
		List<WebElement> suggestionList=getGooglePage.getSuggestionList();
		Assert.assertTrue(suggestionList.size()==10);
	}
	
	@Test(priority=3)
	public void testGoogleSearchPage() {

		getGooglePage.clickOnSearchButton();
		String actualTitle=getGoogleSearchPage.searchedPageTitle();
		Assert.assertTrue(actualTitle.contains("Selenium"));
	}
	
	@AfterTest
	public void postCondition() {
		cleanUp();
	}
}
