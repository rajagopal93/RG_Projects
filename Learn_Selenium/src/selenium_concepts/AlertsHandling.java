package selenium_concepts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertsHandling {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./Driverfiles/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("https://www.w3schools.com/js/tryit.asp?filename=tryjs_prompt");
		driver.switchTo().frame("iframeResult");
		driver.findElementByXPath("//button[text()='Try it']").click();
		
		//To Accept and Dismiss.
		Alert Alt = driver.switchTo().alert();
		Alt.accept();
		driver.findElementByXPath("//button[text()='Try it']").click();
		Alt.dismiss();
		
		//To Get text
		driver.findElementByXPath("//button[text()='Try it']").click();
		String Alerttext = driver.switchTo().alert().getText();
		System.out.println(Alerttext);
		
		//To Edit text
		driver.switchTo().alert().sendKeys("SPIDERMAN");
		driver.switchTo().alert().accept();
		
		

	}

}
