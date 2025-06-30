package Practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class AddProductToCart 
{
	public static void main(String[] args) 
	{
		//lunch the browser	
		WebDriver driver=new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		//load the URL
		driver.get("https://www.saucedemo.com/");

		//login to application
		driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("standard_user");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");
		driver.findElement(By.xpath("//input[@id='login-button']")).click();

		//click on product and add to cart
		driver.findElement(By.xpath("//*[text()='Sauce Labs Bike Light']")).click();
		driver.findElement(By.xpath("//*[text()='Add to cart']")).click();

		//navigate to cart
		driver.findElement(By.xpath("//*[@id='shopping_cart_container']")).click();

		//validate the product in cart
		String productCart=driver.findElement(By.xpath("//*[text()='Sauce Labs Bike Light']")).getText();

		if(productCart.equals("Sauce Labs Bike Light"))
		{
			System.out.println(productCart);
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
