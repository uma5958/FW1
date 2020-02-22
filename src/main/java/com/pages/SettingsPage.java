/**
 * @author UmaMaheswararao
 */

package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.base.BasePage;

public class SettingsPage extends BasePage {
	// Objects Repository(OR):........................................................................
	// Page verification
	@FindBy(xpath = "//span[contains(.,'Setup')]")
	WebElement setUpText;
	
	
	
	
	// Initializing the Page Objects:................................................................
	public SettingsPage() {
		PageFactory.initElements(driver, this);
	}

	// Actions:......................................................................................
	public void verify_Navigate_to_Settings_page() {
		Assert.assertTrue(setUpText.isDisplayed(), "Settings pagfe not opened");
	}
	
	
	
	
	
	

}
