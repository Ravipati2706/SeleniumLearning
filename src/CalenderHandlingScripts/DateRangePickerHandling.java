package CalenderHandlingScripts;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class DateRangePickerHandling {

    static WebDriver driver;
    static WebDriverWait wait;

    public static void main(String[] args) {

        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://testautomationpractice.blogspot.com/");
        driver.manage().window().maximize();

        // Input dates (dynamic)
        String startDate = "15-August-2024";
        String endDate = "10-September-2026";

        // Select date range
        selectDateRange(driver, startDate, endDate);

        //driver.quit();
    }

    /**
     * Main reusable method
     */
    public static void selectDateRange(WebDriver driver, String start, String end) {

        LocalDate startDate = parseDate(start);
        LocalDate endDate = parseDate(end);

        // Ensure correct order (important)
        if (endDate.isBefore(startDate)) {
            LocalDate temp = startDate;
            startDate = endDate;
            endDate = temp;
        }

        // Locate elements (stable locators)
        WebElement startInput = driver.findElement(By.id("start-date"));
        WebElement endInput = driver.findElement(By.id("end-date"));

        // Format for HTML5 input → yyyy-MM-dd
        String startFormatted = startDate.toString();
        String endFormatted = endDate.toString();

        // Use JavaScript (most reliable for type="date")
        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript("arguments[0].value=arguments[1]", startInput, startFormatted);
        js.executeScript("arguments[0].value=arguments[1]", endInput, endFormatted);

        // Optional: trigger change event (important in some apps)
        js.executeScript("arguments[0].dispatchEvent(new Event('change'))", startInput);
        js.executeScript("arguments[0].dispatchEvent(new Event('change'))", endInput);
    }

    /**
     * Convert input string → LocalDate
     */
    public static LocalDate parseDate(String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d-MMMM-yyyy");
        return LocalDate.parse(date, formatter);
    }
}