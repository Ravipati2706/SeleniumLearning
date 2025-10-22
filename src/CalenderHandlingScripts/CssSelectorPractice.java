package CalenderHandlingScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CssSelectorPractice {
	static WebDriver driver;

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\reddy\\OneDrive\\Desktop\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://seleniumpractise.blogspot.com/2016/08/how-to-handle-calendar-in-selenium.html");
		driver.findElement(By.cssSelector("input#datepicker")).click();
		
	}

}
	
//Css selector is very robust and fast compare to xpath we have some rules based on that we  have to wright Css selector for elements
		
//1.Using id-----> htmltag#id it meanss ex: input#username or #username 
		
//2.class------> htmaltag.classname or .classname  or .class1.class2.class3.....cn (it means if we have multiple class names)
//input.class1.clas2.class3... or input.class3  or .class1.class2.class3	
		
//3.parent>childtag ex:ul#categerioes	
		
//4.we can write like css like xpath patren
//ex: htmltag[attribute='value'] 
//-----> input[id='username'] ---this is css 
//---->//input[@id='username']---this is xpath
 
//----->input[id='username'][type='email']  -----> css with two attributes 
//--->//input[@id='username' and @type='email'] ---->xpath
		
//5.contans with text
//input[id*user] or input[id*name]	
		
//6.starting with text
//input[id^='user']
		
//7.ending with text
//input[id$='name']
		
//8.First of type
//ul#categories>li:first-of-type		

//8.Last of type
//ul#categories>li:last-of-type	
		
// nth of type
//ul#categories>li:nth-of-type	[3]	it will select required element
		
	
		
		
		


