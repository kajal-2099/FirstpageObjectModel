package webpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.SeleniumUtility;

public class ActitimeLoginPage extends SeleniumUtility{
	
	public ActitimeLoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id="username")
	private WebElement userNameInputField;
	
	@FindBy(name="pwd")
	private WebElement passwordInputField;
	
	@FindBy(css="#loginButton")
	private WebElement loginButton;
		
	public void enterUserName(String username) {
		typeInput(userNameInputField, username);
	}
	public void enterPassword(String password) {
		typeInput(passwordInputField, password);
	}
	public void clickOnLoginButton() {
		clickOnElement(loginButton);
	}
	
	public void loginIntoActiTimeApplication(String username,String password) {
		typeInput(userNameInputField, username);
		typeInput(passwordInputField, password);
		clickOnElement(loginButton);
	}
}
