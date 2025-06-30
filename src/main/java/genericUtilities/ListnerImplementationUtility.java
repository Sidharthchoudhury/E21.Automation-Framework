package genericUtilities;

import java.io.IOException;



import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;



/**
 * This method provide implementation to ITestListener Interface of TestNG
 * @author sidharth
 */

public class ListnerImplementationUtility implements ITestListener
{
	ExtentReports er;

	ExtentTest et;

	@Override
	public void onTestStart(ITestResult result)
	{
		//capture method name
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName+" -test execution started");

		//create test in extent reports
		et=er.createTest(methodName);


	}

	@Override
	public void onTestSuccess(ITestResult result) 
	{
		//capture method name
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName+" -test execution PASS");

		//log the test status as PASS in extent report
		et.log(Status.PASS,methodName+" -test execution PASS");
	}

	@Override
	public void onTestFailure(ITestResult result) 
	{
		//capture method name
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName+" -test execution FAIL");

		//log the test status as FAIL in extent report
		et.log(Status.FAIL,methodName+" -test execution PASS");

		//capture the exception
		System.out.println(result.getThrowable());

		//log the exception in extent reports
		et.log(Status.WARNING,result.getThrowable());

		//capture the screenshot
		SeleniumUtility s=new SeleniumUtility();
		JavaUtility j=new JavaUtility();

		//configure screenshot name
		String screenshotName=methodName+"-"+j.getSystemDate();
		try {
			String path = s.captureScreenShot(BaseClass.sDriver, screenshotName);

			//attach the screenshot to extent report
			et.addScreenCaptureFromBase64String(path,screenshotName);
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) 
	{
		//capture method name
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName+" -test execution SKIP");	

		//log the test status as SKIP in extent report
		et.log(Status.SKIP,methodName+" -test execution SKIP");

		//capture the exception
		System.out.println(result.getThrowable());

		//log the exception in extent reports
		et.log(Status.WARNING,result.getThrowable());
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) 
	{

	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) 
	{

	}

	@Override
	public void onStart(ITestContext context) 
	{
		System.out.println("suite execution started");
		//basic settings of extent reports
		ExtentSparkReporter esr=new ExtentSparkReporter(".\\ExtendReports\\Report-"+new JavaUtility().getSystemDate()+".html");
		esr.config().setDocumentTitle("swag labs execution report");
		esr.config().setTheme(Theme.DARK);
		esr.config().setReportName("swag labs automation framework execution");

		//configure extend reports
		er=new ExtentReports();
		er.attachReporter(esr);
		er.setSystemInfo("Base Platform","Windows");
		er.setSystemInfo("Base Browser","Microsoft Edge");
		er.setSystemInfo("Base env","Test Env");
		er.setSystemInfo("Reporter Name","Sidharth");

	}

	@Override
	public void onFinish(ITestContext context) 
	{
		System.out.println("suite execution finished");
		//generate extent reports
		er.flush();


	}

}
