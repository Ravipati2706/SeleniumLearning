package ActionClasses;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNGAnnotationsBasics {

//  @BeforeSuite set System property for chrome browser
//	@BeforeTest Launch the browser
//	@BeforeClass Login to the application

//	@BeforeMethod------EnterUrl
//	@Test-----GmailLink
//	@AfterMethod-----LogoutfromtheApp

//	@BeforeMethod------EnterUrl
//	@Test--GoogleLogoTest
//	@AfterMethod-----LogoutfromtheApp

//	@BeforeMethod------EnterUrl
//	@Test----TitleOfPageTest
//	@AfterMethod-----LogoutfromtheApp

//	@Afterclass--- CloseBrowser
//	@AfterTest----delete all coockies

//Precondition Annotations starting with @Before

	@BeforeSuite
	public void setup() {
		System.out.println("@BeforeSuite set System property for chrome browser");
	}

	@BeforeTest
	public void LaunchBrowser() {
		System.out.println("@BeforeTest Launch the browser");
	}

	@BeforeClass
	public void LoginApp() {
		System.out.println("@BeforeClass Login to the application");
	}

	@BeforeMethod
	public void EnterUrl() {
		System.out.println("@BeforeMethod------EnterUrl");
	}

	// TestCases
	@Test
	public void GoogleLogotet() {
		System.out.println("@Test--GoogleLogoTest");
	}

	@Test
	public void TitleOfPageTest() {
		System.out.println("@Test----TitleOfPageTest");
	}

	@Test
	public void GmailLink() {
		System.out.println("@Test-----GmailLink");
	}

	// PostConditions---Startin with @After
	@AfterMethod
	public void LogoutfromtheApp() {
		System.out.println("@AfterMethod-----LogoutfromtheApp");
	}

	@AfterClass
	public void CloseBrowser() {
		System.out.println("@Afterclass--- CloseBrowser");

	}

	@AfterTest
	public void deleteAllCoockies() {
		System.out.println("@AfterTest----delete all coockies");
	}

}
