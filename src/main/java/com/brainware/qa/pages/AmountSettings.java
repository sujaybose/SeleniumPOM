package com.brainware.qa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.brainware.qa.base.TestBase;
import com.brainware.qa.util.PopUpHandle;
import com.brainware.qa.util.Xls_Reader;

public class AmountSettings extends TestBase {

	JavascriptExecutor js;
	// Page Factory - OR:
	@FindBy(id = "ctl00_MainContentSection_SettingsViewt1")
	WebElement amountSettings;

	@FindBy(id = "ctl00_MainContentSection_TextDisplay")
	WebElement amountPage;

	// amount fields items
	@FindBy(id = "ctl00_MainContentSection_BRWAMTtxtFormat")
	WebElement format;

	@FindBy(id = "ctl00_MainContentSection_BRWAMTtxtIgnoreCharacters")
	WebElement ignoreChar;

	@FindBy(id = "ctl00_MainContentSection_BRWAMTchkDeactivateCrossValidation")
	WebElement crossVal;

	@FindBy(id = "ctl00_MainContentSection_BRWAMTtxtExportThousandSeparator")
	WebElement thouSep;

	@FindBy(id = "ctl00_MainContentSection_BRWAMTtxtExportDecimalSeparator")
	WebElement decSep;

	@FindBy(id = "ctl00_MainContentSection_Save")
	WebElement saveBtn;

	// Initializing the Page Objects:
	public AmountSettings() {
		PageFactory.initElements(driver, this);
	}

	public boolean verifyAmountPage() {
		// driver.switchTo().frame(amountPage);
		return amountPage.isDisplayed();
	}

	public void readData() {

		Xls_Reader reader = new Xls_Reader(
				"C:\\eclipse\\workspace\\BFISCM\\src\\main\\java\\com\\brainware\\qa\\testdata\\BFI_Config.xlsx");

		int rowCount = reader.getRowCount("BRWAMT");
		int colCount = reader.getColumnCount("BRWAMT");

		for (int colNum = 1; colNum <= colCount; colNum++) {
			String filename = reader.getCellData("BRWAMT", colNum, 2);

			System.out.println("Print values:" + colCount);
		}
	}

	// WebElement format, WebElement ignoreChars, WebElement crossVal, WebElement
	// thouSep, WebElement decSep
	public void setAmountFields() throws InterruptedException, WebDriverException {

		Xls_Reader reader = new Xls_Reader(
				"C:\\eclipse\\workspace\\BFISCM\\src\\main\\java\\com\\brainware\\qa\\testdata\\BFI_Config.xlsx");

		int rowCount = reader.getRowCount("BRWAMT");
		System.out.println("rowcount:" + rowCount);
		int colCount = reader.getColumnCount("BRWAMT");
		System.out.println("colcount:" + colCount);

		// for (int colNum = 1; colNum <= colCount; colNum++)
		String Format = reader.getCellData("BRWAMT", "Format", 2);
		String IgnoreCharacters = reader.getCellData("BRWAMT", "IgnoreCharacters", 2);
		String ExportThousandSeparator = reader.getCellData("BRWAMT", "ExportThousandSeparator", 2);
		String ExportDecimalSeparator = reader.getCellData("BRWAMT", "ExportDecimalSeparator", 2);

		// clear the fields then fill up
		// System.out.println("********"+format.getAttribute("innerHTML"));

		format.clear();
		format.sendKeys(Format);

		ignoreChar.clear();
		ignoreChar.sendKeys(IgnoreCharacters);

		crossVal.click();

		thouSep.clear();
		thouSep.sendKeys(ExportThousandSeparator);

		decSep.clear();
		decSep.sendKeys(ExportDecimalSeparator);

		saveBtn.click();

		// Handle the pop up window for confirmation
		PopUpHandle ph = new PopUpHandle();
		ph.selectPopUpHandle();

		/*
		 * Actions action= new Actions(driver); action.moveToElement(format).perform();
		 * //Thread.sleep(3000);
		 * 
		 * String str= (String) js.executeScript(format.getText());
		 * System.out.println("********"+str);
		 */
		System.out.println("********" + format.getAttribute("title"));
		Assert.assertEquals(format.getAttribute("title"), Format, "Format value matched");

	}
}
