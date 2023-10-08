package stepDefitnitions;

import org.openqa.selenium.By;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utilities.SeleniumUtility;

public class TestOrangeHRMLogin extends SeleniumUtility{
	@Given("^user has already opened a browser and enters the required application (.+)$")
	public void user_has_already_opened_a_browser(String url) {
		setUp("chrome", url);
	}

	@When("^user enters a valid username(.+)$")
	public void user_enters_a_valid_username(String username) {
		typeInput(driver.findElement(By.name("username")), username);
	}

	@Then("^user should be able to reach home page of OrangeHRM(.+)$")
	public void user_should_be_able_to_reach_home_page_of_orangehrm(String homepageurl) {
		Assert.assertTrue(getCurrentUrlOfApplication().contains(homepageurl));
	}

	@And("^enter valida password(.+)$")
	public void enter_valida_password(String password) {
		typeInput(driver.findElement(By.name("password")), password);
	}

	@And("^click on login button$")
	public void click_on_login_button() {
		clickOnElement(driver.findElement(By.cssSelector(".orangehrm-login-button")));
	}

	@And("^close the browser$")
	public void close_the_browser() {
		cleanUp();
	}
	
	@And("^click on user profile$")
	public void click_on_use_profile() {
		clickOnElement(driver.findElement(By.cssSelector(".oxd-userdropdown")));
	}
	@And("click on logout")
	public void click_on_logout() {
		clickOnElement(driver.findElement(By.xpath("//a[text()='Logout']")));
	}
	@Then("^validate after logout user navigated back to login page(.+)$")
	public void validate_after_logout_user_navigated_back_to_login_page(String loginUrl) {
		Assert.assertTrue(getCurrentUrlOfApplication().contains(loginUrl));
	}
	
}
