package CalenderHandlingScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class GenericCalendarHandler {

	static WebDriver driver;

	public static void main(String[] args) {

		driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("http://seleniumpractise.blogspot.com/2016/08/how-to-handle-calendar-in-selenium.html");

		// Click on date picker input
		driver.findElement(By.id("datepicker")).click();

		// Wait for calendar to be visible
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ui-datepicker-calendar")));

		// Call reusable method
		selectDate("16", "June", "2021");

		driver.quit();
	}

	/**
	 * Utility method to split Month & Year
	 */
	public static String[] getMonthYear(String monthYearVal) {
		return monthYearVal.split(" ");
	}

	/**
	 * Generic reusable method to select date
	 */
	public static void selectDate(String exDay, String exMonth, String exYear) {

		// Convert day to integer
		int day = Integer.parseInt(exDay);

		// ❌ Validation for February
		if (exMonth.equalsIgnoreCase("February") && day > 29) {
			System.out.println("Invalid date: " + exMonth + " " + exDay);
			return;
		}

		// ❌ Validation for max days
		if (day > 31) {
			System.out.println("Invalid date: " + exMonth + " " + exDay);
			return;
		}

		// Get current month & year from calendar
		String monthYearVal = driver.findElement(By.className("ui-datepicker-title")).getText();

		System.out.println("Current Month-Year: " + monthYearVal);

		// Navigate until expected month & year
		while (!(getMonthYear(monthYearVal)[0].equals(exMonth) && getMonthYear(monthYearVal)[1].equals(exYear))) {

			//driver.findElement(By.xpath("//a[@title='Next']")).click();

			driver.findElement(By.xpath("//a[@title='Prev']")).click();

			monthYearVal = driver.findElement(By.className("ui-datepicker-title")).getText();
		}

		// Select date with exception handling
		try {
			driver.findElement(By.xpath("//a[text()='" + exDay + "']")).click();
		} catch (Exception e) {
			System.out.println("Invalid date selection: " + exMonth + " " + exDay);
		}

	}
}