/**
 * @author UmaMaheswararao
 */

package com.Listeners;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.ExtentReports.ExtentManager;
import com.ExtentReports.ExtentTestManager;
import com.base.BasePage;
import com.relevantcodes.extentreports.LogStatus;


public class WebEventListener extends BasePage implements ITestListener {

	private static String getTestMethodName(ITestResult iTestResult) {
		return iTestResult.getMethod().getConstructorOrMethod().getName();
	}

	//Before starting all tests, below method runs.
	public void onStart(ITestContext iTestContext) {
		System.out.println("I am in onStart method => "+iTestContext.getName());
		iTestContext.setAttribute("WebDriver", BasePage.driver);
	}

	//After ending all tests, below method runs.
	public void onFinish(ITestContext iTestContext) {
		System.out.println("I am in onFinish method => "+iTestContext.getName());
		//Do tier down operations for ExtentReports reporting!
		ExtentTestManager.endTest();
		ExtentManager.getReporter().flush();
	}

	public void onTestStart(ITestResult iTestResult) {
		System.out.println("I am in onTestStart method => "+getTestMethodName(iTestResult) + " Start");
		//Start operation for ExtentReports.
		ExtentTestManager.startTest(iTestResult.getMethod().getMethodName(),"");
	}

	public void onTestSuccess(ITestResult iTestResult) {
		System.out.println("I am in onTestSuccess method => "+getTestMethodName(iTestResult) + " Succeed");
		//ExtentReports log operation for passed tests.
		ExtentTestManager.getTest().log(LogStatus.PASS, "Test Passed");
	}

	public void onTestFailure(ITestResult iTestResult) {
		System.out.println("I am in onTestFailure method => "+getTestMethodName(iTestResult) + " Failed");
		ExtentTestManager.getTest().log(LogStatus.FAIL, "EXCEPTION OCCURED IS: " +iTestResult.getThrowable());
		//Take base64Screenshot screenshot.
		String base64Screenshot = "data:image/png;base64,"+((TakesScreenshot)driver).
				getScreenshotAs(OutputType.BASE64);
		//ExtentReports log and screenshot operations for failed tests.
		ExtentTestManager.getTest().log(LogStatus.FAIL,"Test Failed",
				ExtentTestManager.getTest().addBase64ScreenShot(base64Screenshot));
	}

	public void onTestSkipped(ITestResult iTestResult) {
		System.out.println("I am in onTestSkipped method => "+getTestMethodName(iTestResult) + " Skipped");
		//ExtentReports log operation for skipped tests.
		ExtentTestManager.getTest().log(LogStatus.SKIP, "Test Skipped");
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
		System.out.println("Test failed but it is in defined success ratio "+getTestMethodName(iTestResult));
	}




}
