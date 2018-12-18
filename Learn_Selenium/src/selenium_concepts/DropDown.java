package selenium_concepts;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropDown {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./Driverfiles/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("http://demo.guru99.com/test/newtours/register.php");
		
		Select S = new Select(driver.findElementByName("country"));
		
		//Index starts from '0'.
		S.selectByIndex(1);
		S.selectByValue("BHUTAN");
		S.selectByVisibleText("BURMA");
		
		
		//To Get all the values of Dropdown.
		List<WebElement> alloptions = S.getOptions();
		int length=alloptions.size();
		for(int i=0;i<length-1;i++)
		{
			System.out.println(alloptions.get(i).getText());
		}
	}

}
