package selenium_concepts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Launch_Browser {
	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "./Driverfiles/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.google.com");	
	}

}
