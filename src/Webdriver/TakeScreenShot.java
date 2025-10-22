package Webdriver;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

public class TakeScreenShot {
	
	static WebDriver driver;

	public static void main(String[] args) throws IOException, InterruptedException {
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\reddy\\OneDrive\\Desktop\\chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
//		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Thread.sleep(3000);
//     	takeScreenshot("facebook_Loginpage");
		
//	}
	
	
//     	public static void takeScreenshot(String filename) throws IOException {
		//1.Take screen shot and store it as a file format
		File f=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		//2.Copy the screenshot to desired location using copyfile method:
		
		//FileUtils.copyFile(src, new File("C:\\Users\\reddy\\eclipse-workspace\\SeleniumLearning"+"\\src\\Webdriver"+filename+".png"));
		
//		FileHandler.copy(src, new File("C:\\Users\\reddy\\eclipse-workspace\\SeleniumLearning"+"\\src\\Webdriver/"+filename+".png"));
		FileHandler.copy(f,new File("C:\\Users\\reddy\\eclipse-workspace\\SeleniumLearning\\tarun\\facebookloginpage.jpg"));
	
	   driver.quit();
	}
	
}
