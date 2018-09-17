package com.brainware.qa.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.brainware.qa.base.TestBase;
import com.brainware.qa.util.ExplicitWait;
import com.brainware.qa.util.TestUtil;

public class ConfigurePage extends TestBase {

	@FindBy(xpath = "//span[contains(text(),'Configure Project')]")
	WebElement configureLabel;

	@FindBy(xpath = "//select[@name='ctl00$MainContentSection$ProjectList']")
	WebElement Project;

	@FindBy(xpath = "//select[@name='ctl00$MainContentSection$SettingsList']")
	WebElement Settings;

	@FindBy(xpath = "//select[@name='ctl00$MainContentSection$ProfileList']")
	WebElement Profile;
	
	@FindBy(xpath="//div[@id='ctl00_MainContentSection_SettingsView']")
	WebElement processingSettings;

	// Initializing the Page Objects:
	public ConfigurePage() {
		PageFactory.initElements(driver, this);
	}

	public String verifyConfigurePageTitle() throws InterruptedException {
		Thread.sleep(3000);
		return driver.getTitle();
	}

	public boolean verifyConfigureLabel() {
		return configureLabel.isDisplayed();
	}

	public ProcessingSettings selectProfileDropdown(String projectName, String settingsName, String profileName)
			throws InterruptedException {

		// ExplicitWait expWait= new ExplicitWait();
		// expWait.waitForElement("Configure Project");
		Thread.sleep(3000);
		Select select = new Select(Project);
		select.selectByVisibleText(projectName);
		Select select2 = new Select(Settings);
		select2.selectByVisibleText(settingsName);
		Select select3 = new Select(Profile);
		select3.selectByVisibleText(profileName);
		
		return new ProcessingSettings();
	}



}
