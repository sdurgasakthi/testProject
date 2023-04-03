package com.util;

import java.time.Duration;
import java.util.ArrayList;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



import com.base.TestBase;


public class TestUtil extends TestBase{
	

	
	public static long PAGE_LOAD_TIMEOUT= 20;
	public static long IMPLICITLY_WAIT_TIMEOUT = 10;
	
	public static void ExplicitWaitandClick(WebDriver driver, WebElement locator, int timeout) {
		
		new WebDriverWait(driver, Duration.ofSeconds(timeout)).ignoring(StaleElementReferenceException.class).until(ExpectedConditions.elementToBeClickable(locator));
		
		locator.click();
		
	}
	
	public static boolean WaitforElement(WebDriver driver, WebElement locator, int timeout) {
		
		new WebDriverWait(driver, Duration.ofSeconds(timeout)).ignoring(StaleElementReferenceException.class).until(ExpectedConditions.elementToBeClickable(locator));
		return locator.isDisplayed();
		
	}
	
	public static void SwitchtoFrame(WebDriver driver, WebElement locator, int timeout) {
		
		new WebDriverWait(driver, Duration.ofSeconds(timeout)).ignoring(StaleElementReferenceException.class).until(ExpectedConditions.elementToBeClickable(locator));
		driver.switchTo().frame(locator);
		
		
	}
	
	public static void ExplicitWaitandSend(WebDriver driver, WebElement locator, String LocatorValue,int timeout) {
		
		new WebDriverWait(driver, Duration.ofSeconds(timeout)).ignoring(StaleElementReferenceException.class).until(ExpectedConditions.elementToBeClickable(locator));
		
		locator.sendKeys(LocatorValue);
		
	}
	
	//switching window-- switch to new window
	
	
 public static void SwitchToParentTab() {
	 ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
	 driver.switchTo().window(tabs.get(0));
 }
 
 
 public static void SwitchToChildTab() {
	 ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
	 
	 int n= tabs.size();
	 driver.switchTo().window(tabs.get(n-1));
	 
 }
 

 
 
 public static String getWindowTitle() {
	 
	 return driver.getTitle();
 }

	

	

	
	

	
	

	

}
