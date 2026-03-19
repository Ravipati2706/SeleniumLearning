package Webdriver;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AlertHandlingPractice {

    public static void main(String[] args) {

        // Setup ChromeDriver
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        // Explicit wait
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Open website
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        driver.manage().window().maximize();

        // ================================
        // 1️⃣ Handle Simple Alert
        // ================================

        driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();

        Alert simpleAlert = wait.until(ExpectedConditions.alertIsPresent());

        System.out.println("Simple Alert Text: " + simpleAlert.getText());

        simpleAlert.accept();  // Click OK


        // ================================
        // 2️⃣ Handle Confirmation Alert
        // ================================

        driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();

        Alert confirmAlert = wait.until(ExpectedConditions.alertIsPresent());

        System.out.println("Confirmation Alert Text: " + confirmAlert.getText());

        confirmAlert.dismiss(); // Click Cancel


        // ================================
        // 3️⃣ Handle Prompt Alert
        // ================================

        driver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();

        Alert promptAlert = wait.until(ExpectedConditions.alertIsPresent());

        System.out.println("Prompt Alert Text: " + promptAlert.getText());

        promptAlert.sendKeys("Selenium Practice");

        promptAlert.accept();


        // Close browser
        driver.quit();
    }
}
