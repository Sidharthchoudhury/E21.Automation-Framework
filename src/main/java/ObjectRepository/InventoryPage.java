package ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtilities.SeleniumUtility;

public class InventoryPage extends SeleniumUtility
{
	@FindBy(xpath="//*[@data-test='product-sort-container']")
	private WebElement sortBtn;

	@FindBy(xpath="//*[@data-test='shopping-cart-link']")
	private WebElement cartBtn;

	@FindBy(id="react-burger-menu-btn")
	private WebElement menuBtn;

	@FindBy(id="logout_sidebar_link")
	private WebElement logoutLink;

	//initialization
	public InventoryPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//utiization
	public WebElement getSortBtn() {
		return sortBtn;
	}


	public WebElement getCartBtn() {
		return cartBtn;
	}


	public WebElement getMenuBtn() {
		return menuBtn;
	}


	public WebElement getLogoutLink() {
		return logoutLink;
	}
	//business library
	/**
	 * This method will perform logout operation
	 */
	public void logout()
	{
		menuBtn.click();
		logoutLink.click();;
	}
	/**
	 * This method will click on cart container button
	 */
	public void clickOnCartContainerBtn()
	{
		cartBtn.click();
	}
	/**
	 * This method will click on a product
	 * @param driver
	 * @param product name
	 */
	public void clickOnAProduct(WebDriver driver,String productName)
	{
		driver.findElement(By.xpath("//*[text()='"+productName+"']")).click();
	}
	/**
	 * This method will sort the product for lowest price then click on it
	 * @param driver
	 * @param sortOption
	 * @param productName
	 */
	public void clickOnLowestPriceProduct(WebDriver driver,String sortOption,String productName)
	{
		handleDropdownByVisibleText(sortBtn,sortOption);
		driver.findElement(By.xpath("//*[text()='"+productName+"']")).click();
	}
}
