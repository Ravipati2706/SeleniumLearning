package CalenderHandlingScripts;

import java.awt.AWTException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CalenderConcept2MakeMyTrp {
static WebDriver driver;
	public static void main(String[] args) throws InterruptedException, AWTException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\reddy\\OneDrive\\Desktop\\chromedriver.exe");
	    driver = new ChromeDriver();
		driver.manage().window().maximize();
//		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
//		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://www.makemytrip.com");
		
		//driver.switchTo().alert().accept();
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'DEPARTURE')]"))).click();
		//driver.findElement(By.xpath("//span[contains(text(),'DEPARTURE')]")).click();
		
        String CurrentCalHeading = driver.findElement(By.className("dayPickerHeader dayToFromCont blackText")).getText();
		System.out.println(CurrentCalHeading);

	}
}

