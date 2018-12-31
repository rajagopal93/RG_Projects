package Helpers;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import Runners.TestRunner;

public class TakeScreenShot {
	WebDriver driver = TestRunner.driver;
    String browser = TestRunner.Browser;
    public void screenShot(String name) throws IOException, InterruptedException {
        Thread.sleep(1000);
        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File(System.getProperty("user.dir")+"\\src\\test\\resources\\Screenshots\\"+browser+"\\"+name+".png"));
    }
}
