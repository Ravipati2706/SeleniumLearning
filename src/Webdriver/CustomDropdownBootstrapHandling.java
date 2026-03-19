package Webdriver;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CustomDropdownBootstrapHandling {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		Actions actions = new Actions(driver);
        driver.get("https://www.jquery-az.com/boots/demo.php?5.2-1");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        // Step 1: Click the dropdown toggle button
        WebElement toggle = driver.findElement(By.cssSelector(".dropdown-menu-toggle"));
        actions.moveToElement(toggle).perform();
        
        
        // Step 2: Wait for options to appear
        wait.until(ExpectedConditions.visibilityOfElementLocated(
           By.cssSelector(".dropdown-menu-toggle")
       ));
        
        // Step 3: Find all options and click "Java"  ✅ correct selector
        List<WebElement> options = driver.findElements(
            By.cssSelector("ul.sub-menu li a")   // ✅ sub-menu NOT dropdown-menu-toggle
        );

        // Step 3: Select option by text
        
        for (WebElement option : options) {
            System.out.println("Found option: " + option.getText()); // debug print
            if (option.getText().trim().equals("Java")) {
                option.click();
                System.out.println("✅ Clicked Java!");
                break;
            }
        }

        driver.quit();
    }
}

