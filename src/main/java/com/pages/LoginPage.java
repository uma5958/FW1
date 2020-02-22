package com.pages;

import static com.ExtentReports.ExtentTestManager.log;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

import com.base.BasePage;
import static com.util.ActionUtil.*;

public class LoginPage extends BasePage {

	// Objects Repository(OR):........................................................................
	@FindBy(id="txtLoginName")
	WebElement username;

	@FindBy(name="password")
	WebElement password;

	@FindBy(id="btnLogin")
	WebElement loginBtn;

	//@FindBy(xpath=".//*[@id='lblMainMenuHint']") // Alpha 
	//@FindBy(xpath=".//*[@id='btnMainMenuTitle']//preceding::a[20]") // Local
	@FindBy(xpath="(//i[contains(@style,'color: #FFFFFF;')])[1]") // Test
	WebElement menuBtn;

	@FindBy(xpath="//span[text()='iQapture']")
	static	WebElement newiQaptureBtn;

	@FindBy(xpath="//span[text()='Dashboard']")
	WebElement dashBoardLink;
	
	// Valuechain website navigation
	@FindBy(xpath="//img[contains(@src,'ex.png')]")
	WebElement valuechainLogo;
	

	// Verify login form
	@FindBy(xpath=".//*[@id='info']/span")
	WebElement errorMsg;

	













	// Initializing the Page Objects:................................................................
	public LoginPage(){
		PageFactory.initElements(driver, this);
	}

	// Actions:......................................................................................
	public String validate_LoginPage_Title(){
		log("Title of the Login Page is: "+driver.getTitle());
		return driver.getTitle();
	}

	public DashBoardPage login(String un, String pwd){
		sendKeys("username", username, un);
		sendKeys("password", password, pwd);
		jsClick("loginBtn", loginBtn);
		jsClick("menuBtn", menuBtn);
		click("newiQaptureBtn", newiQaptureBtn);
		Assert.assertTrue(dashBoardLink.isDisplayed());
		log("Dashboard page displayed and login successful");
		return new DashBoardPage();
	}
	
	public void verify_Valuechain_wesite_navigation_on_clicking_Valuechain_logo(String expTitle) throws Exception {
		click("valuechainLogo", valuechainLogo);
		switchToNewWindow();
		Thread.sleep(3000);
		String title = driver.getTitle();
		Reporter.log("Title of the page is: "+title, true);
		Assert.assertTrue(title.equalsIgnoreCase(expTitle), "Unable to navigate valuechain website");
	}

	public void verify_Login_form(String un, String pwd) {
		try {
			waitForElementVisibility("username", username);
			Assert.assertTrue(username.isDisplayed(), "Login NOT opened");
			Reporter.log("Login page opened successfully", true);
			username.sendKeys(un);
			password.sendKeys(pwd);
			jsClick("loginBtn", loginBtn);
			jsClick("menuBtn", menuBtn);
			click("newiQaptureBtn", newiQaptureBtn);
			Assert.assertTrue(dashBoardLink.isDisplayed(), "Login FAIL");
			Reporter.log("Login PASS & DashBoard page opened successfully");

		} catch (NoSuchElementException e) {
			String msg = errorMsg.getText();
			if (msg.equalsIgnoreCase("Please fill email.")) {
				Reporter.log("Invalid EMAIL", true);
				Assert.fail();
			} else if(msg.equalsIgnoreCase("Please fill password.")){
				Reporter.log("Invalid PASSWORD", true);
				Assert.fail();
			} else {
				Reporter.log("Sorry, the username or password is incorrect. Please try again.", true);
				Assert.fail();
			}
		}
	}
	
	
	

}



