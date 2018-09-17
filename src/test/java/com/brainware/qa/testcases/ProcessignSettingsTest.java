package com.brainware.qa.testcases;

import org.testng.annotations.Test;

import com.brainware.qa.base.TestBase;
import com.brainware.qa.pages.AmountSettings;
import com.brainware.qa.pages.ConfigurePage;
import com.brainware.qa.pages.LoginPage;
import com.brainware.qa.pages.ProcessingSettings;
import com.brainware.qa.util.TestUtil;

import net.sourceforge.htmlunit.cyberneko.HTMLElements.Element;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;

public class ProcessignSettingsTest extends TestBase {
	
	
	LoginPage loginPage;
	// HomePage homePage;
	TestUtil testUtil;
	ConfigurePage configurePage;
	ProcessingSettings processingSettings;
	
	  @BeforeTest
		public void setUp() throws InterruptedException {

			initialization();
			testUtil = new TestUtil();
			loginPage = new LoginPage();
			configurePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
			processingSettings= configurePage.selectProfileDropdown(prop.getProperty("project"), prop.getProperty("settings"), prop.getProperty("profile"));
			// driver.wait(6000);
		}
	
		@Test(priority = 1)
		public void confirmProcessingPage() throws InterruptedException {
			Thread.sleep(3000);
			//processingSettigns.amountSettings.click();
			boolean value= processingSettings.verifyProcessingPage();
			Assert.assertTrue(value);
		}
		
	/*	@Test(priority = 2)
		public void confirmAmountPage() throws InterruptedException {
			boolean value= processingSettings.selectAmountSettings();
			Assert.assertTrue(value);
		}*/
		
		
/*
		@Test(priority = 2)
		public void confirmAmountPage() throws InterruptedException {
			boolean value= pprocessingSettings.selectFieldSettings();
			Assert.assertTrue(value);
		}
*/
		

  @AfterTest
	public void tearDown() {
		driver.quit();
	}

}
