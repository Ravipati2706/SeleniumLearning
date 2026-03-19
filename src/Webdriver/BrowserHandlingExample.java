package Webdriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserHandlingExample {

    public static void main(String[] args) {

        WebDriver driver;

        String browser = "chrome";   // change to firefox / edge

        // Launch browser
        if(browser.equalsIgnoreCase("chrome")) {

            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();

        } else if(browser.equalsIgnoreCase("firefox")) {

            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();

        } else {

            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        }

        // Maximize browser
        driver.manage().window().maximize();

        // Open URL
        driver.get("https://www.google.com");

        // Get Page Title
        String title = driver.getTitle();
        System.out.println("Page Title: " + title);

        // Get Current URL
        String url = driver.getCurrentUrl();
        System.out.println("Current URL: " + url);

        // Navigate to another site
        driver.navigate().to("https://www.selenium.dev");

        // Back navigation
        driver.navigate().back();

        // Forward navigation
        driver.navigate().forward();

        // Refresh page
        driver.navigate().refresh();

        // Minimize browser (Selenium 4 feature)
        driver.manage().window().minimize();

        // Close browser
        driver.quit();
    }
}
