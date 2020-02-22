/**
 * @author UmaMaheswararao
 */

package com.testcases;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.base.BasePage;
import com.pages.CapturePage;
import com.pages.DashBoardPage;
import com.pages.LoginPage;
import com.util.ExcelUtility;

public class CapturePageTest extends BasePage {
	
	LoginPage loginPage;
	DashBoardPage dashBoardPage;
	CapturePage capturePage;
	ExcelUtility reader;
	
	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
		dashBoardPage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		capturePage = dashBoardPage.clickOnCaptureLink();
		reader = new ExcelUtility("./src/main/java/com/testdata/NewiQaptureData.xlsx");
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

	@Test
	public void CapturePage_Title_Test() {
		String actual = capturePage.verifyPageTitle();
		String expected = "Capture";
		Assert.assertEquals(actual, expected, "Capture Page Not Opened");
		Reporter.log("Capture Page Opened Successfully", true);
	}

	
	
	
	

	
	
}
