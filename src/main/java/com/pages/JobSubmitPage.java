package com.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.TestBase;
import com.util.TestUtil;

public class JobSubmitPage extends TestBase{
	
	
	@FindBy(xpath="//div[@data-ph-at-id='jobdescription-text']/ul/li")
	List<WebElement> points;
	
	
	@FindBy(className = "job-title")
	WebElement jobTitle;
	
	@FindBy(xpath="//a[@data-ph-at-id='apply-link']")
	WebElement ApplyBtn;
	
	
	public JobSubmitPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	public boolean IsTitleLoaded(String text) {
		
		return TestUtil.WaitforElement(driver, jobTitle, 30);
		
		
	}
	
	
	public  boolean IsTextavailable(String text) {
		
	
		String before_xpath = "//div[@data-ph-at-id='jobdescription-text']/ul/li[";
	
		
		boolean status= false;
		
		for(int i=1; i<=points.size(); i++) {
		
			if(driver.findElement(By.xpath(before_xpath+i+"]")).getText().contains(text)) {
				status=true;
				break;
			}
			
			
		}
		return status;
		
		
		
	}
	
	
	public void ClickApplyButton() {
		
		TestUtil.ExplicitWaitandClick(driver, ApplyBtn, 30);
		
		TestUtil.SwitchToChildTab();
	}
	
	public void ReturntoJobListing() {
		
		
		TestUtil.SwitchToChildTab();
		
		driver.navigate().back();
		
	}
	

}
