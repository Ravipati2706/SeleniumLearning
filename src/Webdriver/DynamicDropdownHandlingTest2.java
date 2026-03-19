package Webdriver;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DynamicDropdownHandlingTest2 {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demo.guru99.com/test/newtours/register.php");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		 // ✅ Step 1: Select Country — triggers mailing/phone code update
        WebElement countryEl = wait.until(
            ExpectedConditions.elementToBeClickable(By.name("country"))
        );
        
        Select countrySelect = new Select(countryEl);
        countrySelect.selectByVisibleText("INDIA");
        System.out.println("✅ Country: " + countrySelect.getFirstSelectedOption().getText());


     // ✅ Step 2: Fill dependent fields that change based on country
        driver.findElement(By.name("firstName")).sendKeys("Test");
        driver.findElement(By.name("lastName")).sendKeys("User");
        driver.findElement(By.name("email")).sendKeys("test@test.com");
        driver.findElement(By.name("phone")).sendKeys("9999999999");
        driver.findElement(By.name("address1")).sendKeys("123 Street");
        driver.findElement(By.name("city")).sendKeys("Hyderabad");
        driver.findElement(By.name("state")).sendKeys("Telangana");
        driver.findElement(By.name("postalCode")).sendKeys("500001");

        // ✅ Step 3: Select Username & Password
        driver.findElement(By.name("userName")).sendKeys("testuser123");
        driver.findElement(By.name("password")).sendKeys("Pass@123");
        driver.findElement(By.name("confirmPassword")).sendKeys("Pass@123");

        System.out.println("✅ Form filled successfully based on Country selection!");

        //driver.quit();
	}

}
