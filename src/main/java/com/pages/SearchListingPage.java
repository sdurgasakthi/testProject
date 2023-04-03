package com.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.TestBase;
import com.util.TestUtil;

import dev.failsafe.internal.util.Assert;

public class SearchListingPage extends TestBase{
	
	TestUtil util;
	
	
	@FindBy(xpath="//ul[@data-ph-at-id='jobs-list']/li")
	List<WebElement> joblist;
	
	
	public SearchListingPage() {
		
		PageFactory.initElements(driver, this);
		
	}
	
	
	String before_xpath= "//ul[@data-ph-at-id='jobs-list']/li[";
	
	String jobTitle_endpath= "]/div/span/a";
	
	String jobCategory_endpath= "]/div/p/span[2]/span";
	
	String jobLocation_endpath= "]/div/p/span[3]/span";
	
	String jobID_endpath= "]/div/p/span[5]/span/span[2]";
	
	
	public void ClickJobnnn(int index) {
		
		driver.findElement(By.xpath(before_xpath+index+ jobTitle_endpath)).click();		
		
	}
	
	
	

	public  String getJobTitle(int index) {
		
		
		String jobTitle= driver.findElement(By.xpath(before_xpath+index+jobTitle_endpath)).getText();
		
		return jobTitle;		

}
	
	
	public  String getJobCategory(int index) {
		
		String s= driver.findElement(By.xpath(before_xpath+index+jobCategory_endpath)).getText();
		
		String jobCategory= s.substring(9, s.length());
		
		return jobCategory;
		

}
	

	
	public  String getJobLocation(int index) {
		
		String s= driver.findElement(By.xpath(before_xpath+index+jobLocation_endpath)).getText();
		
		String jobLocation= s.substring(9, s.length());
		
		return jobLocation;
		

}
	

	
	
	public  String getJobID(int index) {
		
		String jobID= driver.findElement(By.xpath(before_xpath+index+jobID_endpath)).getText();
		
		return jobID;		

}
	
	
	public void ClickJobggg(String jobTitle, String jobCategory, String location, String jobId) {
		
		
		for(int i=1; i<=joblist.size(); i++) {
			
			if(getJobTitle(i).contains(jobTitle) && getJobCategory(i).contains(jobCategory) && getJobID(i).contains(jobId) && getJobLocation(i).contains(location)) {

				driver.findElement(By.xpath(before_xpath+i+ jobTitle_endpath)).click();
				
				break;
				
			}
	
		}
		
	}	
	
	
	public int GetJobIndex(String jobTitle, String jobCategory, String location, String jobId) {
		
		int index=0;
		
		for(int i=1; i<=joblist.size(); i++) {
			
			if(getJobTitle(i).contains(jobTitle) && getJobCategory(i).contains(jobCategory) && getJobID(i).contains(jobId) && getJobLocation(i).contains(location)) {
				
				index=i;
			}

		}

return index;
		
	}
	
	
	public void ClickJob(int index) {
		
				driver.findElement(By.xpath(before_xpath+index+ jobTitle_endpath)).click();
				
	
	}	
	
	
	
	
	
	
	

}
