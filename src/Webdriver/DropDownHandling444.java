package Webdriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

      public class DropDownHandling444 {
	
	   static WebDriver driver;

	   public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\reddy\\Desktop\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.facebook.com/");
		
		// Without using select class how we will get values from any dropdown >>>> we can use driver.findelements it will return list of webelements
		 List<WebElement> yearlist = driver.findElements(By.xpath("//select[@id='year']//option"));
		 System.out.println(yearlist.size());
		// now we have to print the all the total number of values from the particular dropdown we have to use forloop
		for(int i=0; i<yearlist.size(); i++) {
		System.out.println(yearlist.get(i).getText());
		// To select particular value from dropdown we have to use if condition
		if(yearlist.get(i).getText().equals("2020")) {
			yearlist.get(i).click();
			break;
		}
		
		 }
		 
	}

}
