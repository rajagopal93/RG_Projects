package StepDefinitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class steps {

	WebDriver driver;
	
	@Given("^I launch the url in chrome browser$")
	public void i_launch_the_url_in_chrome_browser() throws Throwable {
		System.setProperty("webdriver.chrome.driver","./Driver_Files/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    driver.get("https://www.bankbazaar.com");
	}

	@When("^I navigate to LogIn popup$")
	public void i_navigate_to_LogIn_popup() throws Throwable {
	    
		driver.findElement(By.xpath("//a[@title='Login']")).click();	   
	}

	@When("^I enters the username$")
	public void i_enters_the_username() throws Throwable {
	    
	    driver.findElement(By.id("user.email")).sendKeys("testlogin@gmail.com");
	}

	@When("^I enters the password$")
	public void i_enters_the_password() throws Throwable {
	    
	    driver.findElement(By.id("user.password")).sendKeys("test123!");
	}
	
	@When("^I click on the Login button$")
	public void i_click_on_the_Login_button() throws Throwable {
	    
	    driver.findElement(By.id("signInNative")).click();
	}

	@Then("^I should see successful Login$")
	public void i_should_see_successful_Login() throws Throwable {
		if(driver.findElement(By.xpath("//a[@id='my-account-link']")).isDisplayed()) {
			System.out.println("Successful Login");			
		}
		else
		{
			System.out.println("Login not successful");
		}
	}
	
	@Then("^I logout the session$")
	public void i_logout_the_session() throws Throwable {
	   Actions mouse = new Actions(driver);
	   mouse.moveToElement(driver.findElement(By.id("my-account-link"))).build().perform();
	   driver.findElement(By.xpath("//a[@title='Logout']")).click();
	   
	}
}
