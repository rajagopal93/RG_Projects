package Helpers;

import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
public class Hooks {
	public static RemoteWebDriver driver;
	
	public static RemoteWebDriver setup(String name) throws MalformedURLException
	{
		if(name.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "./Driver_Files/chromedriver.exe");
			driver  =  new ChromeDriver();
		}
		else {
		System.out.println("Enter Valid Browser Name");
	}
		return driver;
	}
}
	
