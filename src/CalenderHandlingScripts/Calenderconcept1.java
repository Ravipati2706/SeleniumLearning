package CalenderHandlingScripts;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Calenderconcept1 {

	public static void main(String[] args) throws InterruptedException {
		
		
//initializing the date and month values or storing the day and month values in a string variable 
		
	//String month = "March, 2021";
	//String day = "20";
	
//setting browser property and launching browser 	
	System.setProperty("webdriver.chrome.driver","C:\\Users\\Reddybabu\\eclipse-workspace\\SeleniumLearning\\drivers\\chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	//driver.manage().deleteAllCookies();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.get("http://www.phptravels.net/");
	
	driver.findElement(By.xpath("//a[@class='text-center flights '][contains(text(),'Flights')]")).click();
	Thread.sleep(2000);
	
	driver.findElement(By.xpath("//div[@class='custom-control custom-radio  custom-control-inline'][2]")).click();
	Thread.sleep(8000);
	
	
	
   WebElement element = driver.findElement(By.xpath("//span[text()='Economy']"));
   element.click();
   
   List<WebElement> list = driver.findElements(By.xpath("//ul[contains(@class,'chosen-results')]//li"));
   System.out.println(list.size());
   
   for(int i=0; i<list.size(); i++) {
	   System.out.println(list.get(i).getText());
	   Thread.sleep(4000);
	   if(list.get(i).getText().contains("Business")) {
		   list.get(i).click();
	   }
   }
   
   
     WebElement From =  driver.findElement(By.xpath("//div[@id='s2id_location_from']"));
     From.click();
     Thread.sleep(3000);
     
    WebElement From1 = driver.findElement(By.xpath("//*[@id=\"select2-drop\"]/div/input"));
    From1.sendKeys("Hyderabad");
    Thread.sleep(5000);
    From1.sendKeys(Keys.ARROW_DOWN);
    From1.sendKeys(Keys.ENTER);
    Thread.sleep(3000);
    
    driver.findElement(By.xpath("//div[@id='s2id_location_to']")).click();
    Thread.sleep(2000);
    WebElement Destination = driver.findElement(By.xpath("//*[@id=\"select2-drop\"]/div/input"));
    Destination.sendKeys("Mumbai");
    Thread.sleep(2000);
    Destination.sendKeys(Keys.ARROW_DOWN);	
    Destination.sendKeys(Keys.ENTER);
    
    Thread.sleep(2000);
    driver.findElement(By.xpath("//input[@id='FlightsDateStart']")).click();
    
    String flag = "False";
	 
	 while(flag=="False") {
		 
		 if( driver.findElements(By.xpath("//*[@id=\"datepickers-container\"]/div[9]/div/div/div[2]/div[32]")).size()>0) {
				
				driver.findElement(By.xpath("//*[@id=\"datepickers-container\"]/div[9]/div/div/div[2]/div[32]")).click();
				
			}	 
		 else {
			 driver.findElement(By.xpath("//*[@id=\"datepickers-container\"]/div[9]/nav/div[3]")).click();
		 }
	 }

	
	
	
	
	}
	
	
 }






