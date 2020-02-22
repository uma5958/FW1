/**
 * @author UmaMaheswararao
 */

package com.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BasePage;

public class CapturePage extends BasePage {

	// Objects Repository(OR):........................................................................
	//Page Title Verification
	@FindBy(xpath="//a[text()='Capture']")
	WebElement captureText;
	




	// Initializing the Page Objects:................................................................
	public CapturePage() {
		PageFactory.initElements(driver, this);
	}

	// Actions:......................................................................................
	public String verifyPageTitle() {
		return captureText.getText();
	}












}
