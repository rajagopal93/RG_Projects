package selenium_concepts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;

public class Locators_Selenium {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "./Driverfiles/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("https://www.bankbazaar.com/");
		driver.findElementById("notification-bubble").click();
		driver.findElementByClassName("logo").click();
		
		driver.get("https://jqueryui.com/");
		driver.findElementByTagName("input").click();
		driver.findElementByLinkText("Draggable").click();
		driver.findElementByPartialLinkText("API").click();
		
		driver.get("https://www.bankbazaar.com/");
		driver.findElementByXPath("//a[@title='Apply Loan Online']").click();
		
		//Browser Navigation
		driver.navigate().back();
		driver.navigate().forward();
		driver.close();
		

	}

}
