package webpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.SeleniumUtility;

public class OrangeHRM_DashboardPage extends SeleniumUtility{
	
	public OrangeHRM_DashboardPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(css=".oxd-userdropdown-tab")
	private WebElement userProfile;
	
	@FindBy(xpath="//a[text()='Logout']")
	private WebElement logoutLink;
	
	//TODO: if you need individual object in your script dn create getter method for your private WebElement
	
	public void logoutFromApplication() {
		clickOnElement(userProfile);
		clickOnElement(logoutLink);
	}
}
