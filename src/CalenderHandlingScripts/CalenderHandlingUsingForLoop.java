package CalenderHandlingScripts;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CalenderHandlingUsingForLoop {

	public static void main(String[] args) throws InterruptedException {
		// browser launching with expected APP URl
		System.setProperty("webdriver.chrome.driver","C:\\Users\\reddy\\Desktop\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		//dynamic wait
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.abhibus.com/");
		
		//Enter and selectinng the data in source and destination
        WebElement SLF = driver.findElement(By.xpath("//input[@id='source']"));
        SLF.click();
	    SLF.sendKeys("vijayawada");
	    Thread.sleep(5000);
	   //LF.sendKeys(Keys.ARROW_DOWN);
	    SLF.sendKeys(Keys.ENTER);
		
	    WebElement DGT = driver.findElement(By.xpath("//input[@id='destination']"));
	    DGT.click();
	    DGT.sendKeys("hyderabad");
	    Thread.sleep(5000);
	    DGT.sendKeys(Keys.ENTER);
	    
	    driver.findElement(By.xpath("//input[@id='datepicker1']")).click();
	    //selecting a date from calender using for loop logic
	    String date = "31-January-2021";
	    String dateArr[] = date.split("-");
	    String day = dateArr[0];
	    String month = dateArr[1];
	    String year = dateArr[2];
	    
	  //*[@id="ui-datepicker-div"]/div[1]/table/tbody/tr[1]
	 //*[@id="ui-datepicker-div"]/div[1]/table/tbody/tr[1]/td[2]
    //*[@id="ui-datepicker-div"]/div[1]/table/tbody/tr[1]/td[4]
	    
	    String beforexpath = "//*[@id=\"ui-datepicker-div\"]/div[1]/table/tbody/tr[";
	    String afterxpath = "]/td[";
	    
        final int totalWeekDays = 7;
		
		//2-1 2-2 2-3 2-4 2-5 2-6 2-7
		//3-2 3-2 3-3 3-4 3-5 3-6 3-7
        boolean flag = false;
        String dayVal = null;
        for(int rowNum=1; rowNum<=5; rowNum++) {
        	
        	for(int colNum=1; colNum<=totalWeekDays; colNum++) {
        		
        		try {
        		dayVal = driver.findElement(By.xpath(beforexpath+rowNum+afterxpath+colNum+"]")).getText();
            	}catch(NoSuchElementException e){
            		System.out.println("Please enter the correct date");
        			flag=false;
        			break;
            		
            	}
        			
        		System.out.println(dayVal);
        		if(dayVal.equals(day)) {
        		driver.findElement(By.xpath(beforexpath+rowNum+afterxpath+colNum+"]")).click();	
        		flag=true;
        		break;
        			
        		}
        	}
        	if(flag) {
        		break;
        	}
        	
        	
        }
        
        
	

		
	}

}
