package Webdriver;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DropDownselectionGenericMethod {
	
	static WebDriver driver;

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\reddy\\Desktop\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.facebook.com/");
		
		String dayxpath = "//select[@id='day']//option";
		String monthxpath = "//select[@id='month']//option";
		String yearxpath = "//select[@id='year']//option";
	
//		selectDropDownValue(dayxpath,"27");
//     	selectDropDownValue(monthxpath,"Jun");
//		selectDropDownValue(yearxpath,"2020");
		
	// instead of hot coding values we have to store the values in one string variable and split it will return one array 	
		String hotcode = "27-Jun-2006";
		String hotcodeArr[] = hotcode.split("-");
		
		selectDropDownValue(dayxpath,hotcodeArr[0]);
		selectDropDownValue(monthxpath,hotcodeArr[1]);
		selectDropDownValue(yearxpath,hotcodeArr[2]);
		
	}

	
	public static void selectDropDownValue(String xpathvalue, String value) {
		List<WebElement> yearlist =driver.findElements(By.xpath(xpathvalue));
		System.out.println(yearlist.size());
		
		for(int i=0; i<yearlist.size(); i++) {
			System.out.println(yearlist.get(i).getText());
		
			
			if(yearlist.get(i).getText().equals(value)) {
				yearlist.get(i).click();
				break;
				
			}
		
		
			}
	}
}



		
	
