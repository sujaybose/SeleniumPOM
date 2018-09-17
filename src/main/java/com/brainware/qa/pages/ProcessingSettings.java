package com.brainware.qa.pages;

import org.testng.annotations.Test;

import com.brainware.qa.base.TestBase;

import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;

public class ProcessingSettings extends TestBase {

	@FindBy(xpath = "//div[@id='ctl00_MainContentSection_TreePanel']")
	WebElement processingSettings;

	// OR- For different settings page
	@FindBy(xpath = "//a[@id='ctl00_MainContentSection_SettingsViewt1']")
	WebElement amountSettings;

	@FindBy(xpath = "//div[@id='ctl00_MainContentSection_SettingsViewt5']")
	WebElement comCodeSettings;

	// OR- for target elements

	@FindBy(id = "ctl00_MainContentSection_BRWAMTtxtFormat")
	WebElement format;

	public ProcessingSettings() {
		PageFactory.initElements(driver, this);
	}

	/*
	 * public ProcessingSettings selectTable() throws InterruptedException {
	 * Thread.sleep(3000); processingSettings.click(); return new
	 * ProcessingSettings(); // select.selectByVisibleText(table);
	 * 
	 * }
	 */

	public boolean verifyProcessingPage() throws InterruptedException {
		//Thread.sleep(6000);
		processingSettings.click();
		
		//driver.switchTo().frame(processingSettings);
		return true;
	}
/*
	public boolean selectFieldSettings(WebElement element, WebElement targetElement) {
		element.click();

		return targetElement.isDisplayed();
	}*/
	

	public AmountSettings selectAmountSettings() {
		amountSettings.click();
		
		return new AmountSettings();
	}

}
