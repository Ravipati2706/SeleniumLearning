package Webdriver;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GmailComposeMail {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\reddy\\OneDrive\\Desktop\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.gmail.com");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.findElement(By.id("identifierId")).sendKeys("ravindratarun87@gmail.com");
		driver.findElement(By.xpath("//span[contains(text(),'Next')]")).click();
		Thread.sleep(5000);
		
		driver.findElement(By.name("password")).sendKeys("123!@#qwe");
		driver.findElement(By.xpath("//span[contains(text(),'Next')]")).click();
		Thread.sleep(10000);
	
		//driver.findElement(By.className("T-I T-I-KE L3")).click();
		
		driver.findElement(By.xpath("//div[contains(text(),'Compose')]")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("(//textarea[@name='to'])[1]")).sendKeys("Tarun.dosapalli@gmail.com");
		driver.findElement(By.xpath("(//input[@name='subjectbox'])[1]")).sendKeys("Hi this is selenium script for gmail login page");
		Thread.sleep(5000);
    
		driver.findElement(By.xpath("(//div[contains(text(),'Send')])[2]")).click();
		Thread.sleep(3000);
		driver.close();
	}
	
}
