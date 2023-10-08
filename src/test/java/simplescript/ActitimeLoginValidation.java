package simplescript;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import utilities.SeleniumUtility;

public class ActitimeLoginValidation extends SeleniumUtility{

	@Test
	public void testLoginWithValidData() {
		
		setUp("chrome", "https://demo.actitime.com/login.do");
		
		typeInput(driver.findElement(By.id("username")), "admin");
		
		typeInput(driver.findElement(By.name("pwd")),"manager");
		
		clickOnElement(driver.findElement(By.id("loginButton")));
		
		clickOnElement(driver.findElement(By.id("logoutLink")));
		
		Assert.assertEquals(getCurrentTitleOfApplication("actiTIME - Login"), "actiTIME - Login");
	}
}
