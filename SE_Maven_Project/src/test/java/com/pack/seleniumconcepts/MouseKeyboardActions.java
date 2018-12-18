package com.pack.seleniumconcepts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseKeyboardActions {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./Driverfiles/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("https://jqueryui.com/droppable/");
		driver.switchTo().frame(driver.findElementByClassName("demo-frame"));
		
	                    	//MOUSE Actions
		//DragandDrop
		WebElement drag = driver.findElementById("draggable");
		WebElement drop = driver.findElementById("droppable");
		
		//Actions Class - Object creation
		Actions builder = new Actions(driver);
		builder.dragAndDrop(drag, drop).build().perform();
		
		//To come out of frame
		driver.switchTo().defaultContent();
		
		//MouseHover the menu and click it's sub-menu.
		WebElement Contribute = driver.findElementByXPath("//a[text()='Contribute']");
		builder.moveToElement(Contribute).build().perform();
		driver.findElementByLinkText("Web Sites").click();
		
		//Right click
		WebElement Search = driver.findElementByTagName("input");
		builder.contextClick(Search).build().perform();
		
		//Double click
		Search.sendKeys("SeleniumLearning");
		builder.doubleClick(Search).build().perform();
		
							//KEYBOARD Actions
		Search.sendKeys(Keys.DELETE);
		Search.sendKeys("window machines");
		Search.sendKeys(Keys.ENTER);
		
		driver.get("http://demo.guru99.com/test/newtours/register.php");
		WebElement Firstname = driver.findElementByName("firstName");
		Firstname.sendKeys("AbdulKalam");
		Firstname.sendKeys(Keys.CONTROL + "a");
		Firstname.sendKeys(Keys.CONTROL + "c");
		WebElement Username = driver.findElementById("email");
		Username.sendKeys(Keys.CONTROL + "v");
		
		
		WebElement Address = driver.findElementByName("address1");
		builder.keyDown(Address, Keys.SHIFT).sendKeys(Address, "seleniumnagar chennai").keyUp(Address, Keys.SHIFT).build().perform();
		
	}

}
