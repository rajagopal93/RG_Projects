package selenium_concepts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;

public class Tooltip {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./Driverfiles/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("https://www.bankbazaar.com");
		String LogoTooltip = driver.findElementByXPath("//img[@alt='BankBazaar']").getAttribute("title");
		System.out.println(LogoTooltip);
	}

}
