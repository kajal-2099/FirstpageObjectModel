package webpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.SeleniumUtility;

public class OrangeHRM_LoginPage extends SeleniumUtility{
	
	public OrangeHRM_LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	/**
	 * WebElements required
	 * username inputfield
	 * password inputfield
	 * login button
	 */
	@FindBy(name="username")
	private WebElement usernameInputField;
	
	@FindBy(xpath="//input[@placeholder='Password']")
	private WebElement passwordInputField;
	
	@FindBy(css=".orangehrm-login-button")
	private WebElement loginButton;
	
	//TODO: if you need individual object in your script dn create getter method for your private WebElement
	
	public void loginInOrangeHrmApplication(String username,String password) {
		typeInput(usernameInputField, username);
		typeInput(passwordInputField, password);
		clickOnElement(loginButton);
	}
}
