package selenium_concepts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Testngsample {
	
	
	
	@BeforeMethod
	public void login_click() {
		System.setProperty("webdriver.chrome.driver", "./Driverfiles/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("https://www.bankbazaar.com");
		driver.findElementByLinkText("Login").click();
		
	}
	
	
	//Testcase1
	@Test
	public void Login_Valid(){
		//System.out.println("Running test1");
		ChromeDriver driver = new ChromeDriver();
		
		driver.findElementById("user.email").sendKeys("rajtest@gmail.com");
		driver.findElementById("user.password").sendKeys("test123!");
		driver.findElementById("signInNative").click();
		
		driver.findElementByXPath("//span[text()='Hi rajtest']").click();
		driver.close();
	}
	
	//Testcase2
		@Test
		public void Login_InValid(){
			//System.out.println("Running test1");
			ChromeDriver driver = new ChromeDriver();
			
			driver.findElementById("user.email").sendKeys("rajtest@gmail.com");
			driver.findElementById("user.password").sendKeys("oiuidjh");
			driver.findElementById("signInNative").click();
			
			driver.findElementByXPath("//span[text()='Hi rajtest']").click();
			driver.close();
		}
		
		@AfterMethod
		public void loginclickafter()
		{
			System.out.println("After method");
		}
}
