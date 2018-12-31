package Runners;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.TestNGCucumberRunner;
import cucumber.api.testng.CucumberFeatureWrapper;
import java.io.File;
import java.net.MalformedURLException;

import Helpers.Hooks;
import Helpers.TakeScreenShot;
import Utils.UtilityMethods;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.sun.jna.platform.win32.Netapi32Util.User;


@CucumberOptions(features = "src/test/features", glue = {"Stepdefinitions"},monochrome = true,plugin = {"html:target/cucumber-html-report", "json:target/cucumber-json-report.json" })

public class TestRunner {
	private TestNGCucumberRunner testNGCucumberRunner;
	public static RemoteWebDriver driver;
	public static String Browser;
	public static ExtentReports extent;
	public static ExtentTest test;
	TakeScreenShot snapshot = new TakeScreenShot();
	
	@BeforeTest(alwaysRun = true)
	@Parameters("browser")
	public void beforeTest(String browser) throws Exception{
		System.out.println("Automation Test Execution Started...!");
		extent = new ExtentReports(System.getProperty("user.dir") + "\\" + browser + "_automationexecution_report.html",true);
		extent.loadConfig(new File(System.getProperty("user.dir") + "\\extentconfig.xml"));
	}
	
	
	@BeforeClass(alwaysRun = true)
	@Parameters("browser")
	public void setUpClass(String browser) throws MalformedURLException
	{
		test = extent.startTest("BB Automation Test Suite");
		Browser = browser;
		driver = Hooks.setup(browser);
		test.log(LogStatus.PASS, "Browser Launched Successfully");
		testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
	}
	
	@Test(groups = "cucumber", description = "Runs Cucumber Feature", dataProvider = "features")
	public void feature(CucumberFeatureWrapper cucumberFeature) {
		try {
			testNGCucumberRunner.runCucumber(cucumberFeature.getCucumberFeature());
		} catch (Exception e) {
			test.log(LogStatus.FAIL, e);
		}
	}
	
	@DataProvider
	public Object[][] features() {
		return testNGCucumberRunner.provideFeatures();
	}
	
	@AfterTest(alwaysRun = true)
	public void afterTest() throws Exception {
		try {
			driver.close();
			driver.quit();
			test.log(LogStatus.PASS, "Browser closed successfully");
		} catch (Exception e) {
			test.log(LogStatus.FAIL, "Error occurs while closing the browser");
		} finally {
			testNGCucumberRunner.finish();
			extent.endTest(test);
		}
		try {
			extent.flush();
			extent.close();
		} catch (Exception e) {
			test.log(LogStatus.FAIL, "Error occurs while generating extent report");
		}
}
	@AfterSuite
	public void aftersuite() {
		try {
			// SendEmail.email();
		} catch (Exception e) {
			test.log(LogStatus.FAIL, "Error occurs while closing the browser");
		}
	}
}
