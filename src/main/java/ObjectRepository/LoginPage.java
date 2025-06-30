package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage 
{//rule1

	//rule2
	//declaration
	@FindBy(id="user-name")  //identify single element with single locator
	private WebElement usernameTxtFld;

	//@FindAll--identify single element with multiple locator
	//OR operator
	//Auto healing process
	//@FindAll({@FindBy(id="user-name"),@FindBy(name="user-name")})
	//private WebElement usernameTxtFld;

	//@FindBys--identify single element with multiple locator
	//AND operator
	//@FindBys({@FindBy(id="user-name"),@FindBy(name="user-name")})
	//private WebElement usernameTxtFld;


	@FindBy(id="password")
	private WebElement passwordTxtFld;

	@FindBy(id="login-button")
	private WebElement loginBtn;

	//rule3
	//initialization
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//rule4
	//utilization
	public WebElement getUsernameTxtFld() {
		return usernameTxtFld;
	}

	public WebElement getPasswordTxtFld() {
		return passwordTxtFld;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}

	//business-generic method-project specific
	/**
	 * This method will perform login operation
	 * @param un
	 * @param pwd
	 */
	public void loginToApp(String un,String pwd)
	{
		usernameTxtFld.sendKeys(un);
		passwordTxtFld.sendKeys(pwd);
		loginBtn.click();
	}




}
