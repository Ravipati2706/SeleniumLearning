package ActionClasses;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GoibiboCalender {
	static WebDriver driver;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\reddy\\OneDrive\\Desktop\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.goibibo.com/flights/");
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//		String Logoname = driver.findElement(By.xpath("//span[@class='header-sprite logo']")).getText();
//		System.out.println(Logoname);
		driver.findElement(By.id("departureCalendar")).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("DayPicker-wrapper")));
		
		String yearmonthval = driver.findElement(By.xpath("//div[@class='DayPicker-Caption']")).getText();
		System.out.println(yearmonthval);
		
		String month = yearmonthval.split(" ")[0].trim();
		String Year  = yearmonthval.split(" ")[1].trim();
		
		 while(!(month.equals("December")) && (Year.equals("2021"))){
			 driver.findElement(By.xpath("//span[@aria-label='Next Month']")).click();
			 
			  yearmonthval = driver.findElement(By.xpath("//div[@class='DayPicker-Caption']")).getText();
			  System.out.println(yearmonthval);
			  month = yearmonthval.split(" ")[0].trim();
			  Year  = yearmonthval.split(" ")[1].trim();
			  
			 }
		
		  driver.findElement(By.id("")).click();
		
		

	}

}
