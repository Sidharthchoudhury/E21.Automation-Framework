package genericUtilities;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import ObjectRepository.InventoryPage;
import ObjectRepository.LoginPage;

public class BaseClass 
{
	public FileUtility fu=new FileUtility();
	public JavaUtility ju=new JavaUtility();
	public SeleniumUtility su=new SeleniumUtility();

	public WebDriver driver;
	
	//for listeners
	public static WebDriver sDriver;
	
	@BeforeSuite(alwaysRun=true)
	public void bsConfig()
	{
		System.out.println("------Database connection successful-------");
	}
	//@Parameters("Browser")
	//@BeforeTest
	@BeforeClass(alwaysRun=true)
	public void bcConfig(/*String pValue*/) throws IOException
	{
		String URL = fu.readDataFromPropertyFile("url");
		

	//	driver=new EdgeDriver();
		
		//for cross browser execution
//		if(pValue.equals("edge"))
//		{
//			driver=new EdgeDriver();
//		}
//		else if(pValue.equals("firefox"))
//		{
			driver=new FirefoxDriver();
//		}
//		else
//		{
//			driver=new EdgeDriver();
//		}
		
		su.maximizeWindow(driver);
		su.addImpicitlyWait(driver);

		driver.get(URL);
		
		//for listeners
		sDriver=driver;

		System.out.println("------Browser launch successful-------");
	}
	@BeforeMethod(alwaysRun=true)
	public void bmConfig() throws IOException
	{
		String USERNAME = fu.readDataFromPropertyFile("username");
		String PASSWORD = fu.readDataFromPropertyFile("password");

		LoginPage lp=new LoginPage(driver);
		lp.loginToApp(USERNAME,PASSWORD);
	}
	@AfterMethod(alwaysRun=true)
	public void amConfig()
	{
		InventoryPage ip=new InventoryPage(driver) ; 
		ip.logout();
	}
	//@AfterTest
	@AfterClass(alwaysRun=true)
	public void acConfig()
	{
		driver.quit();
		System.out.println("------Browser closure successful-------");

	}
	@AfterSuite(alwaysRun=true)
	public void asConfig()
	{
		System.out.println("------Database closure successful-------");

	}

}

