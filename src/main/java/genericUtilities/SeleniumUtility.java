package genericUtilities;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * This class consists of generic methods related to selenium
 * @author sidharth
 */
public class SeleniumUtility 

{
	/**
	 * This method will maximize the window
	 * @param driver
	 */
	public void maximizeWindow(WebDriver driver)
	{
		driver.manage().window().maximize();

	}
	/**
	 * This method will maximize the window
	 * @param driver
	 */
	public void minimizeWindow(WebDriver driver)
	{
		driver.manage().window().minimize();

	}
	/**
	 * This method will full screen the window
	 * @param driver
	 */
	public void fullScreenWindow(WebDriver driver)
	{
		driver.manage().window().fullscreen();

	}
	/**
	 * This method will add implicitly wait for 10 seconds
	 * @param driver
	 */
	public void addImpicitlyWait(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	/**
	 * This method will wait for 10 seconds for element to be visible
	 * @param driver
	 * @param elememt
	 */
	public void waitForElementToBeVisible(WebDriver driver,WebElement elememt)
	{
		 WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		 wait.until(ExpectedConditions.visibilityOf(elememt));
	}
	/**
	 * This method will wait for 10 seconds for element to be Clickable
	 * @param driver
	 * @param elememt
	 */
	public void waitForElementToBeClickable(WebDriver driver,WebElement elememt)
	{
		 WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		 wait.until(ExpectedConditions.elementToBeClickable(elememt));
	}
	/**
	 * This method will handle drop down by index
	 * @param element
	 * @param index
	 */
	public void handleDropdown(WebElement element,int index)
	{
		Select s=new Select(element);
		s.selectByIndex(index);
	}
	/**
	 * This method will handle drop down by visible text
	 * @param element
	 * @param visible text
	 */
	public void handleDropdownByVisibleText(WebElement element,String visibleText)
	{
		Select s=new Select(element);
		s.selectByVisibleText(visibleText);
	}
	/**
	 * This method will handle drop down by value
	 * @param element
	 * @param value
	 */
	public void handleDropdown(String value,WebElement element)
	{
		Select s=new Select(element);
		s.selectByValue(value);
	}
	/**
	 * This method will perform mouse hovering action on web element
	 * @param driver
	 * @param element
	 */
	public void mouseHoverAction(WebDriver driver,WebElement element)
	{
		Actions act=new Actions(driver);
		act.moveToElement(element).perform();
	}
	/**
	 * This method will perform drag and drop action on web element
	 * @param driver
	 * @param srcEle
	 * @param trgEle
	 */
	public void dragAndDropAction(WebDriver driver,WebElement srcEle,WebElement trgEle)
	{
		Actions act=new Actions(driver);
		act.dragAndDrop(srcEle,trgEle).perform();
	}
	/**
	 * This method will perform double click action on web element
	 * @param driver
	 * @param source element
	 */
	public void doubleClickAction(WebDriver driver,WebElement element)
	{
		Actions act=new Actions(driver);
		act.doubleClick(element).perform();
	}
	/**
	 * This method will perform context click action on web element
	 * @param driver
	 * @param element
	 */
	public void rightClickAction(WebDriver driver,WebElement element)
	{
		Actions act=new Actions(driver);
		act.contextClick(element).perform();
	}
	/**
	 * This method will perform click and hold on web element
	 * @param driver
	 * @param element
	 */
	public void clickAndHoldAction(WebDriver driver,WebElement element)
	{
		Actions act=new Actions(driver);
		act.clickAndHold(element).perform();
	}
	/**
	 * This method will perform release on web element
	 * @param driver
	 * @param element
	 */
	public void releaseAction(WebDriver driver,WebElement element)
	{
		Actions act=new Actions(driver);
		act.release(element).perform();
	}
	/**
	 * This method will perform scroll action on web element
	 * @param driver
	 * @param element
	 */
	public void scrollAction(WebDriver driver,WebElement element)
	{
		Actions act=new Actions(driver);
		act.scrollToElement(element).perform();
	}
	/**
	 * This method will switch to frame based on index
	 * @param frameIndex
	 * @param driver
	 */
	public void switchToFrame(int frameIndex,WebDriver driver)
	{
		driver.switchTo().frame(frameIndex);
	}
	/**
	 * This method will switch to frame based on name or ID
	 * @param frameNameOrID
	 * @param driver
	 */
	public void switchToFrame(String frameNameOrID,WebDriver driver)
	{
		driver.switchTo().frame(frameNameOrID);
	}
	/**
	 * This method will switch to frame based on Web element
	 * @param element
	 * @param driver
	 */
	public void switchToFrame(WebElement element,WebDriver driver)
	{
		driver.switchTo().frame(element);
	}
	/**
	 * This method will switch the control to immediate parent frame
	 * @param driver
	 */
	public void switchToParentFrame(WebDriver driver)
	{
		driver.switchTo().parentFrame();
	}
	/**
	 * This method will switch the control to main page
	 * @param driver
	 */
	public void switchToDefaultContent(WebDriver driver)
	{
		driver.switchTo().defaultContent();
	}
	/**
	 * This method will accept alert pop-up 
	 * @param driver
	 */
	public void acceptAlert(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
	/**
	 * This method will dismiss alert pop-up
	 * @param driver
	 */
	public void dismisstAlert(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}
	/**
	 * This method will capture text from alert pop-up and return to caller 
	 * @param driver
	 * @return alert text
	 */
	public String getAlertText(WebDriver driver)
	{
		return driver.switchTo().alert().getText();
	}
	/**
	 * This method will enter data into alert pop-up 
	 * @param driver
	 * @param data
	 */
	public void EnterAlertData(WebDriver driver,String data)
	{
		driver.switchTo().alert().sendKeys(data);
	}
	/**
	 * This method will scroll down by 500 units
	 * @param driver
	 */
	public void scrollDown(WebDriver driver)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeAsyncScript("window.scrollBy(0,500);", "");
	}
	public String captureScreenShot(WebDriver driver,String screenshotName) throws IOException
	{
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		File dst=new File(".\\Screenshots\\"+screenshotName+".png");
		FileHandler.copy(src, dst);
		
		return dst.getAbsolutePath();//For extent report
	}
			
	
	
}
