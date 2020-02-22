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
import com.pages.BuildPage;
import com.pages.DashBoardPage;
import com.pages.LoginPage;
import com.util.ExcelUtility;

public class BuildPageTest extends BasePage {
	
	LoginPage loginPage;
	DashBoardPage dashBoardPage;
	BuildPage buildPage;
	ExcelUtility reader;
	
	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
		dashBoardPage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		buildPage = dashBoardPage.clickOnBuildLink();
		reader = new ExcelUtility("./src/main/java/com/testdata/NewiQaptureData.xlsx");
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	@Test
	public void Verify_BuidPage_Test() {
		Assert.assertTrue(buildPage.verify_IQuapturePage(), "New IQapture Button is Missing on the Page");
		Reporter.log("New IQapture Button Present - Test PASS", true);
	}

	
	
	
	
	
}
