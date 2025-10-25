package Webdriver;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;

public class DropDrownHandling {
	static WebDriver driver;

	public static void main(String[] args) throws IOException {
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\reddy\\Desktop\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.facebook.com/");
		
		//process:1 direct using select  class
//		Select select = new Select(driver.findElement(By.id("day")));
//		select.selectByVisibleText("15");
		
		//process2:Create a webElement for day and month and year dropdowns
		WebElement day =driver.findElement(By.id("day"));
		WebElement month =driver.findElement(By.id("month"));
		WebElement year =driver.findElement(By.id("year"));
		
		// Process2:create object for select class to call dropdown value
//		Select select = new Select(day);
//		select.selectByVisibleText("15");
//		Select select1 = new Select(month);
//		select1.selectByVisibleText("Aug");
//		Select select2 = new Select(year);
//		select2.selectByVisibleText("1945");
		
		//Process3:
//		selectValueFromDropdown(day,"15");
//		selectValueFromDropdown(month,"Aug");
//		selectValueFromDropdown(year,"1945");
		
		//process4:Instead of hot coded values from process4 we have to use split function 
		String independent = "15-Aug-1945";
		String independentArr[] = independent.split("-");
		//Process4:
		selectValueFromDropdown(day, independentArr[0]);
		selectValueFromDropdown(month, independentArr[1]);
		selectValueFromDropdown(year, independentArr[2]);
		
		takeScreenshot("facebook_Loginpage");
	}
		
//NOTE: So insted of writing repitative code like above for dropdown we have to do one thing let say we have 100's of dropdowns to automate
// no need to write 100 lines of code, in that case we have to create one utility function and then we have to call them under main method  		
		//process:3
	public  static void selectValueFromDropdown(WebElement element, String value) {
		Select select = new Select(element);
		select.selectByVisibleText(value);
		
	}
		
		public static void takeScreenshot(String filename) throws IOException {
			//1.Take screen shot and store it as a file format
			File src =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			//2.Copy the screenshot to desired location using copyfile method:
			
			//FileUtils.copyFile(src, new File("C:\\Users\\reddy\\eclipse-workspace\\SeleniumLearning"+"\\src\\Webdriver"+filename+".png"));
			
			FileHandler.copy(src, new File("C:\\Users\\reddy\\eclipse-workspace\\SeleniumLearning"+"\\src\\Webdriver/"+filename+".png"));
		
		   //driver.quit();
		
	}
		

	}


