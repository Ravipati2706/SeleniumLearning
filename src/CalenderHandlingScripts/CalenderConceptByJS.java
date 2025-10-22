package CalenderHandlingScripts;

import java.util.List;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CalenderConceptByJS {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\reddy\\Desktop\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		//dynamic wait
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("https://www.spicejet.com/");
		
		driver.findElement(By.xpath("//input[@id='ctl00_mainContent_rbtnl_Trip_1']")).click();
		WebElement From = driver.findElement(By.xpath("//span[@id='ctl00_mainContent_ddl_originStation1_CTXTaction']"));
		From.click();
		driver.findElement(By.xpath("//input[@id='ctl00_mainContent_ddl_originStation1_CTXT']")).sendKeys("Hyderabad");
		//From.sendKeys("Hyderabad");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id='ctl00_mainContent_ddl_destinationStation1_CTXT']")).sendKeys("Bangalore");
	    Thread.sleep(3000);
	    
//		WebElement date = driver.findElement(By.id("ctl00_mainContent_txt_Fromdate"));
//		String dateVal = "30-01-2021";
//		
//		selectDateByJS(driver, date, dateVal);
//		
//	}
//	
//	
//	public static void selectDateByJS(WebDriver driver, WebElement element, String dateVal){
//    	JavascriptExecutor js = ((JavascriptExecutor) driver);
//		js.executeScript("arguments[0].setAttribute('value','"+dateVal+"');", element);
		
		
		//driver.findElement(By.id("ctl00_mainContent_view_date1")).click();
		
		List<WebElement> dates = driver.findElements(By.xpath("//div[@class='ui-datepicker-group ui-datepicker-group-first']/table[1]//td"));
		
		int total_nodes = dates.size();
		
		for(int i=0; i<total_nodes; i++) {
			
			String cal = dates.get(i).getText();
			System.out.println( cal);
			if(cal.equals("30"))
			{
				dates.get(i).click();
				break;
			}
		}
		
		System.out.println("**********************");
		
		
	Thread.sleep(3000);
	
	driver.findElement(By.id("ctl00_mainContent_view_date2")).click();
	Thread.sleep(3000);
    List<WebElement> dates2 = driver.findElements(By.xpath("//div[@class='ui-datepicker-group ui-datepicker-group-first']//table[1]//td"));
		
		int total_nodes2 = dates2.size();
		
		for(int j=0; j<total_nodes2; j++) {
			
			String cal2 = dates.get(j).getText();
			System.out.println( cal2);
			if(cal2.equals("14"))
			{
				dates.get(j).click();
				break;
			}
		}
		
	
		
		
	
	
	}
	
	}