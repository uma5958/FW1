/**

 * @author UmaMaheswararao
 */

package com.testcases;

import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.base.BasePage;
import com.pages.AnalysePage;
import com.pages.DashBoardPage;
import com.pages.LoginPage;
import com.util.ExcelUtility;

public class AnalysePageTest extends BasePage {
	
	LoginPage loginPage;
	DashBoardPage dashBoardPage;
	AnalysePage analysePage;
	ExcelUtility reader;
	
	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
		dashBoardPage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		analysePage = dashBoardPage.clickOnAnalyseLink();
		reader = new ExcelUtility("./src/main/java/com/testdata/NewiQaptureData.xlsx");
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	@Test
	public void AnalysePage_Test() throws Exception {
		analysePage.verify_AnalysePage();
		Reporter.log("Analyse Page Verified Successfully",true);
	}
	
	
	
	
	
	
	
	
}
