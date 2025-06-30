package Practice;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import ObjectRepository.LoginPage;
import genericUtilities.FileUtility;
import genericUtilities.SeleniumUtility;

public class AddProductToCartUsingDDT 
{

	public static void main(String[] args) throws IOException 
	{
		//create object of utilities
		FileUtility fut=new FileUtility();
		SeleniumUtility sut=new SeleniumUtility();
		
		//read common data from common file
		String URL=fut.readDataFromPropertyFile("url");
		String USERNAME=fut.readDataFromPropertyFile("username");
		String PASSWORD=fut.readDataFromPropertyFile("password");

		//read test data from excel file
		String PRODUCTNAME=fut.readDataFromExcelFile("Product", 1, 2);

		//lunch the browser	
		WebDriver driver=new EdgeDriver();
		sut.maximizeWindow(driver);
        sut.addImpicitlyWait(driver);
		//load the URL
		driver.get(URL);

		//login to application
//		driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys(USERNAME);
//		driver.findElement(By.xpath("//input[@id='password']")).sendKeys(PASSWORD);
//		driver.findElement(By.xpath("//input[@id='login-button']")).click();
		LoginPage lp=new LoginPage(driver);
//		lp.getUsernameTxtFld().sendKeys(USERNAME);
//		lp.getPasswordTxtFld().sendKeys(PASSWORD);
//		lp.getLoginBtn().click();
		lp.loginToApp(USERNAME, PASSWORD);
        //validate the page
		if(driver.getCurrentUrl().equals("https://www.saucedemo.com/inventory.html"))
		System.out.println("navigated to inventory page");
		else
			System.out.println("not navigated to inventory page");
		//click on product and add to cart
		driver.findElement(By.xpath("//*[text()='"+PRODUCTNAME+"']")).click();
		driver.findElement(By.xpath("//*[text()='Add to cart']")).click();

		//navigate to cart
		driver.findElement(By.xpath("//*[@id='shopping_cart_container']")).click();

		//validate the product in cart
		String productInCart=driver.findElement(By.xpath("//*[text()='"+PRODUCTNAME+"']")).getText();

		if(productInCart.equals(PRODUCTNAME))
		{
			System.out.println(productInCart);
			System.out.println("PASS");
		}
		else
		{
			System.out.println("FAIL");
		}

		//logout of application
		driver.findElement(By.id("react-burger-menu-btn")).click();
		driver.findElement(By.linkText("Logout")).click();


	}
}
