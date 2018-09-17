package com.brainware.qa.pages;

import java.util.concurrent.TimeUnit;

import org.eclipse.jetty.util.annotation.Name;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.brainware.qa.base.TestBase;
//import com.brainware.qa.testcases.ConfigurePage;
import com.brainware.qa.util.TestUtil;

public class LoginPage extends TestBase {

	// Page Factory - OR:
	@FindBy(id = "ctl00_MainContentSection_loginCtl_UserName")
	WebElement username;

	@FindBy(id = "ctl00_MainContentSection_loginCtl_Password")
	WebElement password;

	@FindBy(xpath = "//input[@type='submit']")
	WebElement loginBtn;

	@FindBy(xpath = "//img[contains(@class,'logo')]")
	WebElement brainwareLogo;

	/*
	 * @FindBy(xpath = "//span[contains(text(),'Configure Project')]") WebElement
	 * configureLabel;
	 * 
	 * @FindBy(xpath="//select[@name='ctl00_MainContentSection_ProjectList']")
	 * //select[@name='ctl00$MainContentSection$ProjectList'] WebElement Project;
	 * 
	 * @FindBy(xpath="//select[@id='ctl00_MainContentSection_SettingsList']")
	 * WebElement Settings;
	 * 
	 * @FindBy(xpath="//select[@id='ctl00_MainContentSection_ProfileList']")
	 * WebElement Profile;
	 */

	// Initializing the Page Objects:
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	// Actions:
	public String validateLoginPageTitle() {
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		return driver.getTitle();
	}

	public boolean validateBrainwareImage() {
		return brainwareLogo.isDisplayed();
	}

	public ConfigurePage login(String un, String pwd) {
		username.sendKeys(un);
		password.sendKeys(pwd);
		loginBtn.click();

		/*
		 * JavascriptExecutor js = (JavascriptExecutor)driver;
		 * js.executeScript("arguments[0].click();", loginBtn);
		 * 
		 */

		return new ConfigurePage();
	}

}
