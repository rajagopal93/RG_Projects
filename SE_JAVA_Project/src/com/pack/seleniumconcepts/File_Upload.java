package com.pack.seleniumconcepts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class File_Upload {

	public static void main(String[] args) {
	
		System.setProperty("webdriver.chrome.driver", "./Driverfiles/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_fileupload_get");
		driver.switchTo().frame("iframeResult");
		WebElement Fileupload = driver.findElementById("myFile");
		Fileupload.sendKeys("D:\\YT-4687 LI\\LI Offers page.png");
		
	}

}
