package com.pack.seleniumconcepts;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;

public class Screenshot {

	public static void main(String[] args) throws IOException {
		System.setProperty("webdriver.chrome.driver", "./Driverfiles/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("https://www.bankbazaar.com");
		driver.findElementByLinkText("Login").click();
		
		File Srcefile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File Destfile = new File("./Snapshot/photo"+".jpeg");
		FileUtils.copyFile(Srcefile, Destfile);

	}

}
