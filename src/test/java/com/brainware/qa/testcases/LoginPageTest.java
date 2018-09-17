package com.brainware.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.brainware.qa.base.TestBase;
import com.brainware.qa.pages.ConfigurePage;
import com.brainware.qa.pages.LoginPage;

public class LoginPageTest extends TestBase {
	LoginPage loginPage;
	ConfigurePage configurePage;

	
	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
	}

	@Test(priority = 1)
	public void loginPageTitleTest() {
		String title = loginPage.validateLoginPageTitle();
		Assert.assertEquals(title, "Log in");
	}

	@Test(priority = 1)
	public void crmLogoImageTest() {
		boolean flag = loginPage.validateBrainwareImage();
		Assert.assertTrue(flag);
	}

	@Test(priority = 3)
	public void loginTest() {
		configurePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
