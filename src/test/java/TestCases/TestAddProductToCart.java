package TestCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import ObjectRepository.CartPage;
import ObjectRepository.InventoryItemPage;
import ObjectRepository.InventoryPage;
import genericUtilities.BaseClass;

@Listeners(genericUtilities.ListnerImplementationUtility.class)
public class TestAddProductToCart extends BaseClass 
{
	@Test(groups ="SmokeSuite")
	public void TC_02_AddProductToCart() throws IOException 
	{

        //read test data from excel file
		String PRODUCTNAME=fu.readDataFromExcelFile("Product", 1, 2);


		//validate the inventory page
		if(driver.getCurrentUrl().equals("https://www.saucedemo.com/inventory.html"))
			System.out.println("navigated to inventory page");
		else
			System.out.println("not navigated to inventory page");

		//click on product
		InventoryPage ip=new InventoryPage(driver);
		ip.clickOnAProduct(driver,PRODUCTNAME);

		//validate the inventory item page
		if(driver.getCurrentUrl().equals("https://www.saucedemo.com/inventory-item.html?id=0"))
			System.out.println("navigated to inventory item page");
		else
			System.out.println("not navigated to inventory item page");

		//add product to cart
		InventoryItemPage iip=new InventoryItemPage(driver);
		iip.clickOnAdToCartBtn();

		//navigate to cart 
		ip.clickOnCartContainerBtn();

		//validate the cart page
		if(driver.getCurrentUrl().equals("https://www.saucedemo.com/cart.html"))
			System.out.println("navigated to cart page");
		else
			System.out.println("not navigated to cart page");
		
		//validate for the product in cart
		CartPage cp=new CartPage(driver);
		String productInCart=cp.captureItemName();
		//Assert.assertEquals(productInCart,PRODUCTNAME);
		Assert.assertTrue(productInCart.equals(PRODUCTNAME));
		System.out.println("product successfully added to cart");
    }
	@Test
	public void sample()
	{   
		System.out.println("demo");
	}
	@Test(groups ="RegressionSuite")
	public void regression()
	{ 
		System.out.println("regression");
	}
	
		
}
