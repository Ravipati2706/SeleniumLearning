package CalenderHandlingScripts;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DatepickerNormal {

	public static void main(String[] args) throws InterruptedException {

		// URL: https://jqueryui.com/datepicker/
		// Calendar opens on click, navigate months, click a day

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://jqueryui.com/datepicker/");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		// Switch to iframe (this site has an iframe)
		driver.switchTo().frame(driver.findElement(By.className("demo-frame")));

		// Click date input to open calendar
		driver.findElement(By.id("datepicker")).click();

		// Current displayed month/year
		String displayedMonth = driver.findElement(By.className("ui-datepicker-month")).getText();
		String displayedYear = driver.findElement(By.className("ui-datepicker-year")).getText();
		System.out.println("Displayed: " + displayedMonth + " " + displayedYear);

		// Navigate to target month (click Next arrow)
		String targetMonth = "June";
		String targetYear = "2026";

		while (true) {
			String month = driver.findElement(By.className("ui-datepicker-month")).getText();
			String year = driver.findElement(By.className("ui-datepicker-year")).getText();

			if (month.equals(targetMonth) && year.equals(targetYear))
				break;

			driver.findElement(By.cssSelector(".ui-icon.ui-icon-circle-triangle-e")).click();
		}

		// Click the target day
		List<WebElement> days = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//a"));

		for (WebElement day : days) {
			if (day.getText().equals("15")) {
				day.click();
				break;
			}
		}

		System.out.println("Date selected successfully!");
		driver.quit();

	}

}
