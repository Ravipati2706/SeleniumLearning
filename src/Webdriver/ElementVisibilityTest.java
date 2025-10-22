package Webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ElementVisibilityTest {
	static WebDriver driver;

	public static void main(String[] args) {
		
			System.setProperty("webdriver.chrome.driver","C:\\Users\\reddy\\OneDrive\\Desktop\\ChromeDriver.exe ");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver.get("https://register.freecrm.com/register/");
			
//1.IsDisplayed:It is used to check  if a particular element is displayed in the webpage or not it will return one boolean value
			//It is applicable for all elements if the element is available in the page it is return true
			boolean b1 =driver.findElement(By.cssSelector("body > div.ui.middle.aligned.center.aligned.grid > div > div.ui.raised.segment > div.row > form > div:nth-child(7) > button")).isDisplayed();
			System.out.println(b1);
			
			//2.Is Enabled:It is also applicable for button and any element it is enabled it will return true or it disable it will return false
			boolean b2 =driver.findElement(By.cssSelector("body > div.ui.middle.aligned.center.aligned.grid > div > div.ui.raised.segment > div.row > form > div:nth-child(7) > button")).isEnabled();
			System.out.println(b2);
			
			//3.IsSelected: method is applicable for checkboxes radioutons and dropdowns
			//driver.findElement(By.id("terms")).click();
			boolean b3 = driver.findElement(By.id("terms")).isSelected();
			System.out.println(b3);

	}

}
