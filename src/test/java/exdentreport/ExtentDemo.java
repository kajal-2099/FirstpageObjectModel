package exdentreport;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utilities.SeleniumUtility;
public class ExtentDemo extends SeleniumUtility{
	static ExtentTest test;
	static ExtentReports report;
	@BeforeTest
	public static void startTest() {
		report = new ExtentReports(".\\ExtentReport\\ExtentReportResults.html");
		
	}
	@Test
	public void TestCase1() throws IOException {
		test = report.startTest("GooglePageValidation-Valid");
		WebDriver driver=setUp("chrome", "https://www.google.com");
		if (getCurrentTitleOfApplication().equals("Google")) {
			test.log(LogStatus.PASS,test.addScreenCapture(screenShot(driver)), "Navigated to the specified URL successfully and page tile is also validated");
			//System.out.println("Navigated to the specified URL successfully and page tile is also validated");
		} else {
			test.log(LogStatus.FAIL,test.addScreenCapture(screenShot(driver)), "Google page validation got failed");
			//System.out.println("Google page validation got failed");
			Assert.assertTrue(getCurrentTitleOfApplication().equals("Google"));
		}
		cleanUp();
	}
	@Test
	public void TestCase2() throws IOException {
		test = report.startTest("GooglePageValidation-Negative");
		WebDriver driver=setUp("chrome", "https://www.google.com");
		if (getCurrentTitleOfApplication().equals("Google1")) {
			test.log(LogStatus.PASS,test.addScreenCapture(screenShot(driver)), "Navigated to the specified URL successfully and page tile is also validated");
			System.out.println("Navigated to the specified URL successfully and page tile is also validated");
		} else {
			test.log(LogStatus.FAIL,test.addScreenCapture(screenShot(driver)), "Google page validation got failed");
			//System.out.println("Google page validation got failed");
			Assert.assertTrue(getCurrentTitleOfApplication().equals("Google1"));
		}
		cleanUp();
	}
	@AfterMethod
	public void getResult(ITestResult result){
		if(result.getStatus() == ITestResult.FAILURE){
			test.log(LogStatus.FAIL, "Test Case Failed is "+result.getName());
			test.log(LogStatus.FAIL, "Test Case Failed due to "+result.getThrowable());
		}else if(result.getStatus() == ITestResult.SKIP){
			test.log(LogStatus.SKIP, "Test Case Skipped due to "+result.getName());
		}
		// ending test endTest(logger) : It ends the current test and prepares to create HTML report
		report.endTest(test);
	}
	@AfterTest
	public static void endTest() {
		report.endTest(test);
		report.flush();
	}
	public static String screenShot(WebDriver driver) throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File Dest = new File("src/../Screenshots/" + System.currentTimeMillis()+ ".png");
		String errflpath = Dest.getAbsolutePath();
		FileUtils.copyFile(scrFile, Dest);
		return errflpath;
		}
}