package Stepdefinitions;

import org.openqa.selenium.WebDriver;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import Pageobjects.CreditCardPage;
import Helpers.TakeScreenShot;
import Runners.TestRunner;
import Utils.UtilityMethods;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Creditcardsteps {
	
	
	static WebDriver driver = TestRunner.driver;
	TakeScreenShot snapshot = new TakeScreenShot();
	ExtentTest logger = TestRunner.test;
	
	@Given("^I Launch the BB Gateway page$")
	public void i_launch_the_bb_gateway_page() throws Throwable{
		CreditCardPage.LoadWebUrl(CreditCardPage.GetPageElement("BB_LANDING_PAGE_URL"));
		UtilityMethods.WindowMaximize();
		logger.log(LogStatus.PASS, "BB_Gateway page gets loaded");
	}
	
	@And("^I launch the \"([^\"]*)\" from \"([^\"]*)\" section$")
	public void i_launch_the_something_page(String element, String keyword) throws Throwable {
		CreditCardPage.MouseHoverElementPage("css", CreditCardPage.GetPageElement(keyword));
		Thread.sleep(1000);
		CreditCardPage.ClickElementPage("xpath",CreditCardPage.GetPageElement(element));
	}
	
	@Then("^I should verify the \"([^\"]*)\" load$")
	public void i_should_verify_the_page_load(String element)  throws Throwable{
		CreditCardPage.WaitForPageElement("xpath", CreditCardPage.GetPageElement(element), 5);
		if(CreditCardPage.PageElementIsVisible("xpath", CreditCardPage.GetPageElement(element))) {
			logger.log(LogStatus.PASS, element + "page gets loaded successfully");
		}
		else
		{
			logger.log(LogStatus.FAIL, element + "failed to load");
		}
		
	}
	
	   @And("^I take screenshot as \"([^\"]*)\"$")
	    public void i_take_screenshot_as_something(String name) throws Throwable {
			Thread.sleep(2000);
			snapshot.screenShot(name);
			Thread.sleep(3000);
			logger.log(LogStatus.PASS, "Taken screenshot as : " + name);
		}
}
