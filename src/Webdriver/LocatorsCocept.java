package Webdriver;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorsCocept {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\reddy\\Desktop\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://accounts.google.com/");
		Thread.sleep(3000);
		
		//Locators
		
		//1.Id: it is a unique locator
		//WebElement username = driver.findElement(By.id("identifierId")); // here the return type of driver.findelement is WebElement
		//username.sendKeys("ravipati2706@gmail.com");                       // By is a class
        //Thread.sleep(3000);
		//WebElement Nxt = driver.findElement(By.id("identifierNext"));
        //Nxt.click();
        
        //2.name: it is unique locator
       // driver.findElement(By.name("identifier")).sendKeys("ravipati2706@gmail.com");
        
        //3.Xpath
       // driver.findElement(By.xpath("//span[contains(text(),'Next')]")).click(); // Xpath is extended html path or xpath i address of any specific element
        
       // driver.findElement(By.xpath("//span[@id=\'identifierNext'\"]/span/span")).click();
	
        //4.cssSelector
        
//        driver.findElement(By.cssSelector("#identifierId")).sendKeys("ravipati2706@gmail.com");
//        Thread.sleep(3000);
//        driver.findElement(By.cssSelector("#identifierNext > span > span")).click();
        
        //5.Linktext>>>>>>>it ownly for links note:all the links are represented by a tag a means angular tag
		//driver.findElement(By.linkText("Learn more")).click();
		
		//6.partial lintext this ia also only for links but not recmmended
		//driver.findElement(By.partialLinkText("Learn")).click(); // it is used to take some partial part of the link in html tag
		                                                         // no need to take entair text of the particular link/
		
		//7.className:its not unique it can be changed like it can be same for different elements
		
		driver.findElement(By.className("whsOnd zHQkBf")).sendKeys("ravipati2706@gmail.com");
		
        
	}

}
