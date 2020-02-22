/**
 * @author UmaMaheswararao
 */

package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BasePage;
import com.util.ActionUtil;

public class DashBoardPage extends BasePage {
	// Objects Repository(OR):........................................................................
	// Home Page Links
	@FindBy(xpath="//span[contains(text(),'Dashboard')]")
	@CacheLookup
	static WebElement dashBoardLink;

	@FindBy(xpath="//span[contains(text(),'Build')]")
	WebElement buildLink;

	@FindBy(xpath="//span[contains(text(),'Capture')]")
	static WebElement captureLink;

	@FindBy(xpath="//span[contains(text(),'Analyse')]")
	static WebElement AnalyseLink;
	
	@FindBy(xpath = "//span[contains(.,'Settings')]")
	WebElement SettingsLink;



	// Initializing the Page Objects:................................................................
	public DashBoardPage() {
		PageFactory.initElements(driver, this);
	}

	// Actions:......................................................................................
	public String verifyHomePageTitle(){
		return driver.getTitle();
	}

	// Navigating DashBoard Link
	public boolean verifyDashboardLink(){
		return dashBoardLink.isDisplayed();
	}

	// Navigating Build Link
	public BuildPage clickOnBuildLink() {
		ActionUtil.jsClick("buildLink", buildLink);
		return new BuildPage();
	}

	// Navigating Capture Link
	public CapturePage clickOnCaptureLink() {
		ActionUtil.click("captureLink", captureLink);
		return new CapturePage();
	}

	// Navigating to Analyse Link
	public AnalysePage clickOnAnalyseLink() {
		ActionUtil.click("AnalyseLink", AnalyseLink);
		return new AnalysePage();
	}
	
	// Navigating to Settings Link
	public SettingsPage clickOnSettingsLink() {
		ActionUtil.click("SettingsLink", SettingsLink);
		return new SettingsPage();
	}


	
	
	

}
