/**
 * @author UmaMaheswararao
 */

package com.testcases;

import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.base.BasePage;
import com.pages.DashBoardPage;
import com.pages.LoginPage;
import com.pages.SettingsPage;
import com.util.ExcelUtility;

public class SettingsPageTest extends BasePage {
	
	LoginPage loginPage;
	DashBoardPage dashBoardPage;
	SettingsPage settingsPage;
	ExcelUtility reader;
	
	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
		dashBoardPage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		settingsPage = dashBoardPage.clickOnSettingsLink();
		reader = new ExcelUtility("./src/main/java/com/testdata/NewiQaptureData.xlsx");
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

	@Test
	public void verify_Navigate_to_Settings_page_Test() {
		settingsPage.verify_Navigate_to_Settings_page();
		Reporter.log("Settings Page Opened Successfully", true);
	}

	
	
	
	
}
