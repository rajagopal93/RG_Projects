package TestNGPack;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;

public class Launchclass {
	
	public WebDriver driver;
	
@BeforeClass
public void beforeClass() {
	System.setProperty("webdriver.chrome.driver", "./Driver_Files/chromedriver.exe");
	driver = new ChromeDriver();
	
 }
	
  @Test
  public void launchurl() {
	  driver.get("http://www.amazon.co.in");
  }
  

  @AfterClass
  public void afterClass() {
	  driver.close();
  }

}
