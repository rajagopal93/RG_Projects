package selenium_concepts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandles {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./Driverfiles/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("https://legacy.crystalcruises.com");
		System.out.println(driver.getSessionId());
		System.out.println(driver.getWindowHandle());
		
		//Before writing the code for switch to window: Both titles will be same
		System.out.println(driver.getTitle());
		driver.findElementByLinkText("GUEST CHECK-IN").click();
		System.out.println(driver.getTitle());
		String parentwindow = driver.getWindowHandle();
		
		//After Code written: Titles will be different
		for(String eachwin : driver.getWindowHandles()) {
			driver.switchTo().window(eachwin);
		}
		System.out.println(driver.getTitle());
		
		//Switch to default Parent window
		driver.switchTo().window(parentwindow);
		System.out.println(driver.getTitle());
		
//		driver.getWindowHandle() method basically returns the window handle (String value). The window/browser tab you are currently on.
//		drvier.getWindowHandles() returns list of window handles string
		
// BROWSER NAVIGATION
		driver.get("https://www.bankbazaar.com/");
		driver.findElementByXPath("//a[@title='Apply Loan Online']").click();
		driver.navigate().back();
		driver.navigate().forward();
	}

}
