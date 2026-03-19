package Webdriver;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class StandardDropdownHandling {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://the-internet.herokuapp.com/dropdown");

		WebElement dropdownElement = driver.findElement(By.id("dropdown"));
		Select select = new Select(dropdownElement);

		// ✅ 3 Ways to Select an Option

		// 1. By Visible Text
		select.selectByVisibleText("Option 1");

		// 2. By Value attribute
		select.selectByValue("1");

		// 3. By Index (0-based)
		select.selectByIndex(1);

		// ✅ Get Selected Option
		System.out.println("Selected: " + select.getFirstSelectedOption().getText());

		// ✅ 1. Traditional for-each Loop (Your Current Way)
		for (WebElement option : select.getOptions()) {
			System.out.println("Option: " + option.getText());
			
			System.out.println("###########################################");

		}

		// 2. Java 8 forEach() with Lambda
		
		select.getOptions().forEach(option -> System.out.println("Option: " + option.getText()));
		
		System.out.println("###########################################");
		

		// 3. Java Stream API — map() + collect() → Convert to List of Strings

		List<String> optionTexts = select.getOptions().stream().map(WebElement::getText).collect(Collectors.toList());

		System.out.println("All Options: " + optionTexts);
		
		System.out.println("###########################################");
		

		// 4. Stream + filter() — Get Options Matching a Condition

		// Print only non-empty options (skips placeholder like "-- Select --")
		select.getOptions()
		.stream()
		.map(WebElement::getText)
		.filter(text -> !text.isEmpty() && !text.startsWith("--"))
		.forEach(System.out::println);
		
		System.out.println("###########################################");

		// 5. Traditional for Loop with Index
		
		List<WebElement> options = select.getOptions();

		for (int i = 0; i < options.size(); i++) {
		    System.out.println("Index " + i + " → " + options.get(i).getText());
		}
		// driver.quit();
	}
}
