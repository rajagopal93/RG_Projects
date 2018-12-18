package com.pack.seleniumconcepts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
//import org.openqa.selenium.NoSuchElementException;
//import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Waits {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "./Driverfiles/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		//Java Wait
		driver.get("https://www.bankbazaar.com");
		Thread.sleep(20000);
		driver.findElementByLinkText("Login").click();
		
		//Implicit wait
		driver.get("https://www.bankbazaar.com");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElementByLinkText("Login").click();
		
		//Explicit Wait
		driver.get("https://www.bankbazaar.com");
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement Login_icon = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Login")));
		Login_icon.click();
		
		//Fluent Wait
//		driver.get("https://www.bankbazaar.com");
//		FluentWait<WebDriver> w = new FluentWait<WebDriver>(driver);
//		w.withTimeout(50, TimeUnit.SECONDS);
//		w.pollingEvery(3, TimeUnit.SECONDS);
//		w.ignoring(NoSuchElementException.class);
//		driver.findElementByLinkText("Login").click();
			
	}

}
