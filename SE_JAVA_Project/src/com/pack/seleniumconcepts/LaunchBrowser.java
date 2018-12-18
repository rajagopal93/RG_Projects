package com.pack.seleniumconcepts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LaunchBrowser {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./Driver_Files/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.amazon.co.in");
		driver.close();
	}

}
