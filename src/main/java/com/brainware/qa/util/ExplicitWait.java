package com.brainware.qa.util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;


@Test

public class ExplicitWait {
 
  WebDriver driver;
  
  public String waitForElement(String item) {
	    WebDriverWait wait = new WebDriverWait(driver,30);
	    WebElement element = wait.until(
	                        ExpectedConditions.elementToBeClickable(By.id(item)));
	   return item;
	}
}
