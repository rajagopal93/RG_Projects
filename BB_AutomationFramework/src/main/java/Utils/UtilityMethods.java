package Utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import Helpers.TakeScreenShot;
import Runners.TestRunner;

public class UtilityMethods {
	public static WebDriver driver = TestRunner.driver;
	static Actions action = new Actions(driver);
	static String browser = TestRunner.Browser;
	static TakeScreenShot snapshot = new TakeScreenShot();
	
	
	public static void OpenWebUrl(String url)throws InterruptedException {
		driver.get(url);
		
	}
	
	public static void WindowMaximize() {
		driver.manage().window().maximize();
	}

	public static void WaitForElement(String locator, String element, int timeout) {
		int wait_time=0;
		
		if(locator == "css")
		{		
		try {
			do {
				if (driver.findElement(By.cssSelector(element)) == null) {
					Thread.sleep(1000);
					wait_time += 1;
				} else {
					wait_time = timeout + 1;
				       }
			} while (wait_time <= timeout);
		} catch (Exception e) {
			System.out.println(e);;
		}	
	}
	else if(locator == "xpath"){
		try {
			do {
				if (driver.findElement(By.xpath(element)) == null) {
					Thread.sleep(1000);
					wait_time += 1;
				} else {
					wait_time = timeout + 1;
				       }
			} while (wait_time <= timeout);
		} catch (Exception e) {
			System.out.println(e);;
		}	
	}
	else
	{
		System.out.println("INVALID LOCATOR");
	}
	}

	public static boolean ElementVisible(String locator, String element) {
		Boolean status=false;
		if (locator == "css")
		{		
		status =  driver.findElement(By.cssSelector(element)).isDisplayed();
	    }
		else if(locator == "xpath")
		{
			status =  driver.findElement(By.xpath(element)).isDisplayed();
		}
		else
		{
			System.out.println("INVALID LOCATOR");
		}
		return status;
}

	public static void MouseHoverElement(String locator, String element) {
		if(locator == "css") {
		action.moveToElement(driver.findElement(By.cssSelector(element))).build().perform();
		
	}
		else if(locator == "xpath") {
			action.moveToElement(driver.findElement(By.xpath(element))).build().perform();
		}
		else
		{
			System.out.println("INVALID LOCATOR");
		}
}

	public static void ClickElement(String locator, String element) {		
		if(locator == "css")
		{			
			driver.findElement(By.cssSelector(element)).click();
		}
		else if(locator == "xpath")
		{
			(driver.findElement(By.xpath(element))).click();
		}
		else
		{
			System.out.println("INVALID LOCATOR");
		}
		
	}
}