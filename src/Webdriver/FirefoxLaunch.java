package Webdriver;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirefoxLaunch {

	public static void main(String[] args) {
		
		//System.setProperty("webdriver.gecko.driver","C:\\Users\\bravindra\\geckodriver.exe");
		WebDriver driver = new  FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://www.google.com");
		String title = driver.getTitle();
		System.out.println("page title is:" + title);
		
		

	}

}
