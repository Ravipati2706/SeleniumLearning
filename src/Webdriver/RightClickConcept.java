package Webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class RightClickConcept {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();

        try {
            // Open the right-click demo page
            driver.manage().window().maximize();
            driver.get("https://swisnl.github.io/jQuery-contextMenu/demo.html");

            // Locate the right-click button
            WebElement rightClickButton =
                    driver.findElement(By.xpath("//span[text()='right click me']"));

            // Perform right-click
            Actions actions = new Actions(driver);
            actions.contextClick(rightClickButton).perform();

            // Locate and click the Copy option
            WebElement copyOption =
                    driver.findElement(By.cssSelector(".context-menu-icon-copy"));

            copyOption.click();

            System.out.println("Right-click performed successfully.");
            System.out.println("Copy option selected.");

        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            // Close the browser
            driver.quit();
        }
    }
}
