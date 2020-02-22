/**
 * @author UmaMaheswararao
 */

package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BasePage;

public class BuildPage extends BasePage {

	// Objects Repository(OR):........................................................................
	@FindBy(xpath=".//*[@id='btnNew']")
	WebElement AddBtn;




	// Initializing the Page Objects:................................................................
	public BuildPage() {
		PageFactory.initElements(driver, this);
	}


	// Actions:......................................................................................
	public boolean verify_IQuapturePage() {
		return AddBtn.isDisplayed();
	}





}

