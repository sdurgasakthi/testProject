package com.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.TestBase;
import com.util.TestUtil;

public class Homepage extends TestBase{
	

	
	
	@FindBy(xpath="//button[contains(@class, 'onetrust-close-btn-ui')]")
	WebElement CloseCookie;
	
	@FindBy(linkText = "Careers")
	WebElement Careers;
	
	
		
	
	public Homepage() {
		
		PageFactory.initElements(driver, this);
	}
	
	
	//methods 
	
 public void CloseCookie() {
	 
	 TestUtil.ExplicitWaitandClick(driver, CloseCookie, 30);
	 
 }
 
 public boolean IsCareerLinkVisible() {
	 
	 return Careers.isDisplayed();
 }
 
 public void ClickCareerLink() throws InterruptedException {
	 
	 Careers.click();
	 
		Thread.sleep(3000);
		
		TestUtil.SwitchToChildTab();
	 
 }
	
	
	

}
