package Webdriver;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BackwardAndForwardSimulation {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\reddy\\OneDrive\\Desktop\\chromedriver.exe");
		WebDriver driver  = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.google.com/");
		System.out.println(driver.getTitle());
		
		//1.navigate to
		driver.navigate().to("https://www.facebook.com/");
		System.out.println(driver.getTitle());
		//2.navigate back
		driver.navigate().back();
		System.out.println(driver.getTitle());
		//3.navigate forward
		driver.navigate().forward();
		System.out.println(driver.getTitle());
		//4.navigate back
		driver.navigate().back();
		System.out.println(driver.getTitle());
		//5.Refresh
     	driver.navigate().refresh();
		
		
		

	}

}
