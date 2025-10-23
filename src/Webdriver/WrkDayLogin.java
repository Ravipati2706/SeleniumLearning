package Webdriver;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class WrkDayLogin {

	//@SuppressWarnings("deprecation")
	public static void main(String[] args) throws InterruptedException {
		//System.setProperty("webdriver.chrome.driver","C:\\Users\\Reddybabu\\eclipse-workspace\\SeleniumLearning\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		String url = "https://www.myworkday.com/wday/authgwy/cnx/login.html";
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.findElement(By.xpath("//div[@class='gwt-Label GDPVGE1BH1'][1]")).click();
		
		driver.findElement(By.xpath("//button[contains (text(), 'Username')]")).click();
		
		driver.findElement(By.cssSelector("#username")).sendKeys("ravindra.bolleddupati@concentrix.com");
		
		driver.findElement(By.xpath("//button[contains (text(), 'Next')]")).click();
		
		//driver.findElement(By.xpath("//div[@class='jss147 MuiBox-root css-0'][1]")).click();
		
		//driver.findElement(By.cssSelector("#password")).sendKeys("Ravi@catalyst2509");
		
		
		//driver.findElement(By.xpath("//span[contains(text(),'Next')]")).click();
		//driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div/c-wiz/div[2]/div[2]/div/div[2]/div/div/div/div/div/a]")).click();
		//Thread.sleep(3000);
		
//		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Ravi@8137");
//		driver.findElement(By.xpath("//span[contains(text(),'Next')]")).click();
//		
//		driver.findElement(By.xpath("//div[contains(text(),'Compose')]")).click();
//		Thread.sleep(5000);
//		
//		driver.findElement(By.xpath("(//textarea[@name='to'])[1]")).sendKeys("ravipati2706@gmail.com");
//		
//		driver.findElement(By.xpath("(//input[@name='subjectbox'])[1]")).sendKeys("Hi this is selenium script for gmail login page");
//		
//		Thread.sleep(5000);
//    
//		driver.findElement(By.xpath("(//div[contains(text(),'Send')])[2]")).click();
//		Thread.sleep(3000);
		//driver.quit();
	}

}
