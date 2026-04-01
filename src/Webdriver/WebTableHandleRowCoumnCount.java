package Webdriver;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTableHandleRowCoumnCount {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/tables");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Locate the table
        WebElement table = driver.findElement(By.id("table1"));

        // Get all rows (including header row)
        List<WebElement> allRows = table.findElements(By.tagName("tr"));
        System.out.println("Total Rows (including header): " + allRows.size());

        // Get column count from header
        List<WebElement> headerCells = table.findElements(By.tagName("th"));
        System.out.println("Total Columns: " + headerCells.size());

        // Get only data rows (tbody rows)
        List<WebElement> dataRows = table.findElements(By.xpath(".//tbody/tr"));
        System.out.println("Total Data Rows: " + dataRows.size());

        //driver.quit();
    }
}


