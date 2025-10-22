package Webdriver;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class GmailLogin {

	//@SuppressWarnings("deprecation")
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Reddybabu\\eclipse-workspace\\SeleniumLearning\\drivers\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		String url = "https://www.gmail.com";
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//input[@type='email']")).sendKeys("ravindra.bolleddupati@gmail.com");
		driver.findElement(By.xpath("//span[contains(text(),'Next')]")).click();
		//driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div/c-wiz/div[2]/div[2]/div/div[2]/div/div/div/div/div/a]")).click();
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Ravi@8137");
		driver.findElement(By.xpath("//span[contains(text(),'Next')]")).click();
		
		driver.findElement(By.xpath("//div[contains(text(),'Compose')]")).click();
		Thread.sleep(5000);
		
		driver.findElement(By.xpath("(//textarea[@name='to'])[1]")).sendKeys("ravipati2706@gmail.com");
		
		driver.findElement(By.xpath("(//input[@name='subjectbox'])[1]")).sendKeys("Hi this is selenium script for gmail login page");
		
		Thread.sleep(5000);
    
		driver.findElement(By.xpath("(//div[contains(text(),'Send')])[2]")).click();
		Thread.sleep(3000);
		driver.quit();
	}

}
