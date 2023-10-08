package webpages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.SeleniumUtility;

public class ActitimeHomePage extends SeleniumUtility{
	
	public ActitimeHomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(css=".navItem>a")
	private List<WebElement> navigationTabs;
	
	@FindBy(id="logoutLink")
	private WebElement logoutLink;
	
	public void selectTab(String tabName) {
		for(int i=0;i<navigationTabs.size();i++) {
			WebElement element=navigationTabs.get(i);
			if(getTextFromElement(element).equals(tabName)) {
				clickOnElement(navigationTabs.get(i));
				break;
			}
		}
	}	
	public void clickOnLogout() {
		clickOnElement(logoutLink);
	}
}
