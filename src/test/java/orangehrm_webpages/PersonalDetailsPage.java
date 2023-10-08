 package orangehrm_webpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.SeleniumUtility;

public class PersonalDetailsPage extends SeleniumUtility {

	public PersonalDetailsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}	
	
	
	//Job Link
	@FindBy(xpath="//a[text()='Job']")
	private WebElement jobTab;
	
	//Job Title Dropdown
	
	//Job Title Dropdown Elements
	
	//Save Button
	
	//Function: Update PIM
	
	//Job Title Dropdown
	//@FindBy(xpath="//div[text()='Account Assistant']")
	//private WebElement selectjob;
	
	//Job Title Dropdown Elements
	
	//Save Button
	//xpath="//button[@type='submit']
	
	@FindBy(xpath="//form/div[1]/div/div[2]/div/div[2]/div/div/div[2]/i")
	private WebElement selectdropdown;
	
	@FindBy(xpath="//div[div[label[text()='Employee Id']]]/div[2]/input")
	private WebElement employeeIdInputField;
	
	@FindBy(xpath="//button[@type='submit']")
	private WebElement searchButtonOnPimPage;
	
	@FindBy(xpath="//button[@type='submit']")
	private WebElement savebtn;
	
	// div > div:nth-child(2) > div > div:nth-child(2) > div > div > div.oxd-select-text-input for chief executive
	@FindBy(css="div > div:nth-child(2) > div > div:nth-child(2) > div > div > div.oxd-select-text-input")
	private WebElement drop;
	
	public void clickOnJob() {
		setSleepTime(2000);
		clickOnElement(jobTab);
	}

	public void selectdrop()
	  {
		clickOnElement(selectdropdown);
	  }
    public void clickOndrop()
    {
    	setSleepTime(500);
    	clickOnElement(drop);
    }
	public void savebtn()
	{
		setSleepTime(2000);
		clickOnElement(savebtn);
	}
	
	 
	
	
	
		
}