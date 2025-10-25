package Webdriver;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseMovementConcept {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\reddy\\Desktop\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("http://mrbool.com/introducing-javascript-6-arrow-functions/36854");
		//Thread.sleep(3000);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		Actions ac = new Actions(driver);
		ac.moveToElement(driver.findElement(By.className("menulink"))).build().perform();
		Thread.sleep(5000);
		//driver.findElement(By.xpath("//ul[@class='submenu']//li//a[text()='Articles']")).click();
		//driver.findElement(By.xpath("//ul[@class='submenu']//li//a[text()='Courses']")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Single Videos')]")).click();
		

	}

}
