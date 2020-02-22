/**
 * @author UmaMaheswararao
 */

package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.base.BasePage;
import com.util.ActionUtil;

public class AnalysePage extends BasePage {
	// Objects Repository(OR):........................................................................
	// Page verification
	@FindBy(xpath=".//*[@id='searchAnalyses']")
	WebElement analysesSearchBox;

		


	// Initializing the Page Objects:................................................................
	public AnalysePage() {
		PageFactory.initElements(driver, this);
	}

	// Actions:......................................................................................

	public void verify_AnalysePage() throws Exception {
		ActionUtil.waitForElementVisibility("analysesSearchBox", analysesSearchBox);
		Assert.assertTrue(analysesSearchBox.isDisplayed(), "Unable to Navigate Analyse Page");
		driver.findElement(By.xpath("//a[contains(@title,'Return to parent folder')]")).click();
		ActionUtil.waitForAjax(driver);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[contains(@title,'Return to parent folder')]")).click();
		ActionUtil.waitForAjax(driver);
	}


}
