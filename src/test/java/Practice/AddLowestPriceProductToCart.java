package Practice;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import genericUtilities.FileUtility;
import genericUtilities.SeleniumUtility;

public class AddLowestPriceProductToCart
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
		String PRODUCTNAME=fut.readDataFromExcelFile("Product", 4, 3);
		String SORTOPTION = fut.readDataFromExcelFile("Product",4 ,2);

		//lunch the browser	
		WebDriver driver=new EdgeDriver();
		sut.maximizeWindow(driver);
		sut.addImpicitlyWait(driver);
		
		//load the URL
		driver.get(URL);

		//login to application
		driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys(USERNAME);
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys(PASSWORD);
		driver.findElement(By.xpath("//input[@id='login-button']")).click();

		//choose sort option from drop down
		WebElement dropdownFilter = driver.findElement(By.className("product_sort_container"));
		sut.handleDropdownByVisibleText(dropdownFilter, SORTOPTION);
		
		//click on the product and add to cart
        driver.findElement(By.xpath("//div[text()='"+PRODUCTNAME+"']"));
		driver.findElement(By.id("add-to-cart-sauce-labs-onesie")).click();

		//navigate to cart
		driver.findElement(By.className("shopping_cart_link"));

		//validate for the product in cart
		String productInCart = driver.findElement(By.className("inventory_item_name")).getText();

		if (productInCart.equals(PRODUCTNAME))
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

