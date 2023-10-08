package webpages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.SeleniumUtility;

public class GooglePage extends SeleniumUtility{
	public GooglePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="q")
	private WebElement searchInputField;
	
	@FindBy(xpath="//input[@name='btnK']")
	private WebElement searchButton;
	
	@FindBy(css="ul.G43f7e>li>div>*:nth-child(2)>*:first-child>*:first-child>span")
	private List<WebElement> suggestionList;
	
	public WebElement getSearchInputField() {
		return searchInputField;
	}
	public WebElement getSearchButton() {
		return searchButton;
	}
	public List<WebElement> getSuggestionList() {
		return suggestionList;
	}
	public void enterText(String text) {
		typeInput(searchInputField, text);
	}
	public void clickOnSearchButton() {
		clickOnElement(searchButton);
	}
}
