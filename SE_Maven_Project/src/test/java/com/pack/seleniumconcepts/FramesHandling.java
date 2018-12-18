package com.pack.seleniumconcepts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FramesHandling {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./Driverfiles/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//Switcch using Frame name
		driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml_select");
		driver.switchTo().frame("iframeResult");
		driver.findElementByTagName("select").click();
		
		//Switch using Frame Locator
		driver.get("http://jqueryui.com/selectable/");
		WebElement frameclass = driver.findElementByClassName("demo-frame");
		driver.switchTo().frame(frameclass);
		driver.findElementByXPath("//li[text()='Item 2']").click();
		
		//Switch using Frame Index
		driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml_select");
		driver.switchTo().frame(1);
		driver.findElementByTagName("select").click();
		
		//To come out of Frame.
		driver.switchTo().defaultContent();

	}

}
