package com.brainware.qa.util;

import org.testng.annotations.Test;

import com.brainware.qa.base.TestBase;

import junit.framework.Assert;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PopUpHandle extends TestBase {
	// WebDriver driver;

	@FindBy(xpath = "//input[@id='rdblPacketSelection_1']")
	WebElement selectPacket;

	@FindBy(xpath = "//input[@id='grdExtPackets_ctl02_rdbSelectPacket']")
	WebElement selectExtPac;

	@FindBy(xpath = "//button[@class='form_button' and span='Save']")
	WebElement saveBtn;

	@FindBy(css = "#dialog-alert p")
	WebElement dialog;

	@FindBy(xpath = "//button[@class='form_button' and span='Close']")
	WebElement closeBtn;

	public PopUpHandle() {
		PageFactory.initElements(driver, this);
	}

	@SuppressWarnings("deprecation")
	public void selectPopUpHandle() throws InterruptedException {

		System.out.println("***********************************************************************");
		if (selectPacket.isDisplayed()) {
			selectPacket.click();
			System.out.println("packet selected");
			selectExtPac.click();
			System.out.println("packet choosed");
			saveBtn.click();
			String str = dialog.getText();
			System.out.println(str);
			Assert.assertEquals("Records saved successfully", str);
			closeBtn.click();
		} else {
			closeBtn.click();

		}

	}

}
