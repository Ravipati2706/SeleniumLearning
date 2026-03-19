package Webdriver;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DynamicDropdownHandling {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://testautomationpractice.blogspot.com/");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		// ✅ Step 1: Select Country
		WebElement country = driver.findElement(By.id("country"));
		Select countrySelect = new Select(country);
		countrySelect.selectByVisibleText("India");
		System.out.println("✅ Country Selected: " + countrySelect.getFirstSelectedOption().getText());
		

		// Print all available countries first
		List<String> allCountries = countrySelect.getOptions().stream().map(WebElement::getText)
				.collect(java.util.stream.Collectors.toList());
		System.out.println("All Countries: " + allCountries);

		driver.quit();
	}

}
