package CalenderHandlingScripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CalenderHandlingUsingJS {

	public static void main(String[] args) throws InterruptedException {
	
		System.setProperty("webdriver.chrome.driver","C:\\Users\\reddy\\Desktop\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		//dynamic wait
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("https://www.makemytrip.com/");
		Thread.sleep(8000);
		
		//driver.findElement(By.xpath("//li[@class='menu_Flights']")).click();
		//Thread.sleep(3000);
		driver.findElement(By.xpath("//body/div[@id='root']/div[1]/div[2]/div[1]/div[1]/div[1]/ul[1]/li[2]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//body/div[@id='root']/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/label[1]/span[1]")).click();
		Thread.sleep(2000);
		WebElement From = driver.findElement(By.xpath("//input[@placeholder='From']"));
		From.sendKeys("Mumbai");
		From.sendKeys(Keys.ARROW_DOWN);
		From.sendKeys(Keys.ENTER);
		
		driver.findElement(By.xpath("//body/div[@id='root']/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[2]/label[1]/span[1]")).click();
		WebElement To = driver.findElement(By.xpath("//input[@placeholder='To']"));
		To.sendKeys("Bangalore");
		To.sendKeys(Keys.ARROW_DOWN);
		To.sendKeys(Keys.ENTER);
		
		
		
		 driver.findElement(By.xpath("//span[contains(text(),'DEPARTURE')]")).click();
		
		Thread.sleep(3000);
	
		
	WebElement date = driver.findElement(By.xpath("//span[contains(text(),'DEPARTURE')]"));
	Thread.sleep(3000);
    String dateVal = "26-01-2021";
	selectDateByJS(driver,date,dateVal);
	}
	
	public static void selectDateByJS(WebDriver driver, WebElement element, String dateVal){
    	JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].setAttribute('value','"+dateVal+"');", element);

}
	
}
