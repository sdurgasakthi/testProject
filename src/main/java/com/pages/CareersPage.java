package com.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.TestBase;
import com.util.TestUtil;

public class CareersPage extends TestBase{
	
	
	
	
	TestUtil util;
	

	
	@FindBy(id = "typehead")
	WebElement SearchBox;
	
	
	
	
	
	
	public CareersPage() {
		
		PageFactory.initElements(driver, this);
	}
	
	
	//methods 
	
	public boolean IsSearchBoxVisible() {
		
		return TestUtil.WaitforElement(driver, SearchBox, 30);
	}
	
	public void SearchJob(String text) {
		SearchBox.sendKeys(text);
		SearchBox.sendKeys(Keys.ENTER);

		
	}
	
	

}
