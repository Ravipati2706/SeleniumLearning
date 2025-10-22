package Webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class RightClickConcept {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\reddy\\Desktop\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://swisnl.github.io/jQuery-contextMenu/demo.html");
		//Create Action class 
		Actions ac = new Actions(driver);
		//create webelement for right click button
		WebElement rightclickButton = driver.findElement(By.xpath("//span[contains(text(),'right click me')]"));
		//click on right click button
		ac.contextClick(rightclickButton).build().perform();
		//create WebElement for Copy 
		WebElement copy = driver.findElement(By.cssSelector(".context-menu-icon-copy"));
		String st=copy.getText(); // to get the text for particular webelement
		System.out.println(copy);
		copy.click();
		

	}

}
