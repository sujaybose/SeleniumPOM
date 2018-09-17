package com.brainware.qa.testcases;

import org.testng.annotations.Test;

import com.brainware.qa.base.TestBase;
import com.brainware.qa.pages.AmountSettings;
import com.brainware.qa.pages.ConfigurePage;
import com.brainware.qa.pages.LoginPage;
import com.brainware.qa.pages.ProcessingSettings;
import com.brainware.qa.util.TestUtil;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class AmountSettingsTest extends TestBase {
	ProcessingSettings proSet;
	TestUtil testUtil;
	LoginPage loginPage;
	ConfigurePage configurePage;
	AmountSettings amtSet;
	// WebDriver driver;

	@BeforeMethod
	public void setUp() throws InterruptedException {
		initialization();
		testUtil = new TestUtil();
		loginPage = new LoginPage();
		configurePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		proSet = configurePage.selectProfileDropdown(prop.getProperty("project"), prop.getProperty("settings"),
				prop.getProperty("profile"));
		amtSet = proSet.selectAmountSettings();
		// amountSet = configurePage.selectTable(configurePage);
		// return configurePage;
	}

	/*
	 * @Test(priority = 1) public void processingPageTest() throws
	 * InterruptedException { proSet.selectTable();
	 * 
	 * }
	 */
	

/*
	@Test(priority = 2)
	public void ProcessingPageVerify() throws InterruptedException {
		boolean flag = proSet.verifyProcessingPage();
		Assert.assertTrue(flag);

	}*/

	@Test(priority = 3)
	public void settingAmountFields() throws InterruptedException {

		amtSet.setAmountFields();
		// Assert.assertTrue(flag);

	}

/*	@Test(priority = 4)
	public void gettingAmountFields() throws InterruptedException {

		driver.navigate().refresh();

		System.out.println("page refreshed");
		// Assert.assertTrue(flag);

	}*/

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
