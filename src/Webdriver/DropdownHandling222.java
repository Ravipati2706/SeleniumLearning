package Webdriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropdownHandling222 {
	
	static WebDriver driver;

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\reddy\\Desktop\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.facebook.com/");

		//Create a webElement for day and month and year dropdowns
		WebElement day =driver.findElement(By.id("day"));
		WebElement month =driver.findElement(By.id("month"));
		WebElement year =driver.findElement(By.id("year"));
		
		//create object for select class to call dropdown value
		Select select = new Select(day);
		select.selectByIndex(10);
		
		Select select1 = new Select(month);
		select1.selectByVisibleText("Aug");
		

		Select select2 = new Select(year);
		select2.selectByVisibleText("2020");
		
		
		
		// The bellow method is used to select the multiple dropdown values and it will return one boolean value
		System.out.print(select.isMultiple());
		
		// get options method it will give the list of all options from the particular dropdown and it will return list of webelements
		List<WebElement> listdays = select.getOptions();
		System.out.println(listdays.size());
		int TotalDays = listdays.size()-1;
		System.out.println("total days are:" +TotalDays);
		
		
		
		// now we have to print the all the total number of values from the particular dropdown we have to use forloop
		for(int i=0; i<listdays.size(); i++) {
			String dayval = listdays.get(i).getText();
			System.out.println(dayval);
			
			}
		System.out.println("************************");
		
		List<WebElement> listofmonths = select1.getOptions();
		System.out.println(listofmonths.size());
		int Totalmonths = listofmonths.size()-1;
		System.out.println("total days are:" +Totalmonths);
		
		for(int j=0; j<listofmonths.size(); j++) {
			String monthval = listofmonths.get(j).getText();
			System.out.println(monthval);
		}
		
		System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$");
		
		
		List<WebElement> listofyear = select2.getOptions();
		System.out.println(listofyear.size());
		int Totalyear = listofyear.size()-1;
		System.out.println("total days are:" +Totalmonths);
		
		for(int j=0; j<listofyear.size(); j++) {
			String yearval = listofyear.get(j).getText();
			System.out.println(yearval);
		}
		
		System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&");
		
		//how will you select the specific value from the dropdown using get options method
		
	}

}
