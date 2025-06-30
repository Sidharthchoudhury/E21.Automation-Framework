package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage 
{
	@FindBy(className="inventory_item_name")
	private WebElement itemInfo;
	
	@FindBy(xpath="//*[text()='Remove']")
	private WebElement removeBtn;
	
	public CartPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getItemInfo() {
		return itemInfo;
	}

	public WebElement getRemoveBtn() {
		return removeBtn;
	}
	//business library
	/**
	 * This method will click on remove button
	 */
	public void clickOnRemoveBtn()
	{
		removeBtn.click();
	}
	/**
	 * This method will capture the product name and return to caler
	 * @return product name
	 */
	public String captureItemName()
	{
		return itemInfo.getText();
	}
}
