package Webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FrameHandlingPractice {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml_iframe");

        // Switch to first frame
        driver.switchTo().frame("iframeResult");

        // Find second iframe inside
        WebElement innerFrame = driver.findElement(By.xpath("//iframe[@title='W3Schools Free Online Web Tutorials']"));

        driver.switchTo().frame(innerFrame);

        // Capture heading text
        String text = driver.findElement(By.xpath("//h1")).getText();

        System.out.println("Inner Frame Heading: " + text);

        driver.quit();
    }
}