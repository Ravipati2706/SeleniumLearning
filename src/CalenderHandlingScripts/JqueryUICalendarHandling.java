package CalenderHandlingScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class JqueryUICalendarHandling {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://jqueryui.com/datepicker/");
		driver.manage().window().maximize();

		// Switch to iframe (important for jQuery UI site)
		driver.switchTo().frame(0);

		// Method 1: Direct sendKeys (simple but not always reliable)
		// driver.findElement(By.xpath("//input[@id='datepicker']")).sendKeys("04/05/2024");

		// Method 2: Using Date Picker UI
		driver.findElement(By.xpath("//input[@id='datepicker']")).click();

		String year = "2026";
		String month = "May";
		String date = "10";

		// Select future date
		selectFutureDate(driver, year, month, date);

		// Select past date (uncomment to test)
		// selectPastDate(driver, year, month, date);

		driver.quit();
	}

	/**
	 * Method to select future date
	 */
	static void selectFutureDate(WebDriver driver, String year, String month, String date) {

		while (true) {

			String currentMonth = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();

			String currentYear = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();

			// Break when desired month & year match
			if (currentMonth.equals(month) && currentYear.equals(year)) {
				break;
			}

			// Click Next button
			driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();
		}

		selectDay(driver, date);

		System.out.println("[INFO] Future Date Selected");
	}

	/**
	 * Method to select past date
	 */
//    static void selectPastDate(WebDriver driver, String year, String month, String date) {
//
//        while (true) {
//
//            String currentMonth = driver.findElement(
//                    By.xpath("//span[@class='ui-datepicker-month']")
//            ).getText();
//
//            String currentYear = driver.findElement(
//                    By.xpath("//span[@class='ui-datepicker-year']")
//            ).getText();
//
//            // Break when desired month & year match
//            if (currentMonth.equals(month) && currentYear.equals(year)) {
//                break;
//            }
//
//            // Click Previous button
//            driver.findElement(
//                    By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-w']")
//            ).click();
//        }
//
//        selectDay(driver, date);

	// ystem.out.println("[INFO] Past Date Selected");
//    }

	/**
	 * Reusable method to select day
	 */
	static void selectDay(WebDriver driver, String date) {

		List<WebElement> allDates = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//a"));

		for (WebElement dt : allDates) {
			if (dt.getText().equals(date)) {
				dt.click();
				System.out.println("[INFO] Expected Date Selected");
				break;

			}
		}
	}
}