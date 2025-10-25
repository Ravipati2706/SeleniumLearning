package ActionClasses;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CalenderSeleniumPractice {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\reddy\\OneDrive\\Desktop\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://seleniumpractise.blogspot.com/2016/08/how-to-handle-calendar-in-selenium.html");
		driver.findElement(By.id("datepicker")).click();
		boolean b1 = driver.findElement(By.xpath("//*[@id=\"post-body-2633212108852578826\"]/h1")).isDisplayed();
		System.out.print(b1);
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ui-datepicker-calendar")));
		
		//capturing the text for current calender M Y
		String CurrentMonthYearValue = driver.findElement(By.className("ui-datepicker-title")).getText();
		System.out.println(CurrentMonthYearValue);
		
		//Spliting the month and year values 
		 String month = CurrentMonthYearValue.split(" ")[0].trim();
		 String year = CurrentMonthYearValue.split(" ")[1].trim();
		
		// now creating the while loop for selecting reqired month and year val >> ! is compare the values from the calender and it will fallow
		//the true or false 
		while(!(month.equals("June") && year.equals("2022"))) {
			driver.findElement(By.xpath("//a[@title='Next']")).click();
			//Thread.sleep(5000);
			 CurrentMonthYearValue = driver.findElement(By.className("ui-datepicker-title")).getText();
			 System.out.println(CurrentMonthYearValue);
			    month = CurrentMonthYearValue.split(" ")[0].trim();
			    year = CurrentMonthYearValue.split(" ")[1].trim();
		}
		//Selecting date 		
		      driver.findElement(By.xpath("//a[text()='27']")).click();
		

	}

}
