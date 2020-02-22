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
import com.pages.DashBoardPage;
import com.pages.LoginPage;
import com.util.ExcelUtility;

public class DashBoardPageTest extends BasePage {
	
	LoginPage loginPage;
	DashBoardPage dashBoardPage;
	ExcelUtility reader;
	
	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
		dashBoardPage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		reader = new ExcelUtility("./src/main/java/com/testdata/NewiQaptureData.xlsx");
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	@Test
	public void Verify_HomePage_Title_Test(){
		String dashBoardTitle = dashBoardPage.verifyHomePageTitle();
		Assert.assertTrue(dashBoardTitle.contains("Valuechain.com"),"Home page title not matched");
		Reporter.log("Title Verified - Test PASS", true);
	}
	
	@Test
	public void Verify_DashBoardLink_Test(){
		Assert.assertTrue(dashBoardPage.verifyDashboardLink(), "Dashboard Link Not Present - Test FAIL");
		Reporter.log("DashBoardLink Verified - Test PASS", true);
	}
	
	
	
	
	
	
	

}
