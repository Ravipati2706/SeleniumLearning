package Webdriver;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTableHandlingReadAllTableData {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://the-internet.herokuapp.com/tables");
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		WebElement table = driver.findElement(By.id("table1"));

		// Print header columns
		List<WebElement> headers = table.findElements(By.xpath(".//thead/tr/th"));
		System.out.print("HEADERS: ");
		for (WebElement header : headers) {
			System.out.print(header.getText() + " | ");
		}
		System.out.println();

		// Print all rows and cells
		List<WebElement> rows = table.findElements(By.xpath(".//tbody/tr"));
		System.out.println("Total Data Rows: " + rows.size());

		for (int i = 0; i < rows.size(); i++) {
			List<WebElement> cells = rows.get(i).findElements(By.tagName("td"));
			System.out.print("Row " + (i + 1) + ": ");
			for (WebElement cell : cells) {
				System.out.print(cell.getText() + " | ");
			}
			System.out.println();
		}

		driver.quit();
	}

}
