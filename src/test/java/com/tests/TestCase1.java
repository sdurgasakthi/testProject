package com.tests;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.util.ArrayList;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.base.TestBase;
import com.pages.CareersPage;
import com.pages.Homepage;
import com.pages.JobSubmitPage;
import com.pages.SearchListingPage;
import com.util.TestUtil;

public class TestCase1 extends TestBase{
	
	Homepage homepage;
	
	SearchListingPage searchpage;
	
	CareersPage careerspage;
	
	JobSubmitPage submitpage;
	
	
	public TestCase1() {
		
		super();
		
	}
	
	
	@BeforeMethod
	public void SetUp() {
		
		initialization();
		
		homepage= new Homepage();
		
		searchpage= new SearchListingPage();
		
		careerspage= new CareersPage();
		
		submitpage=new JobSubmitPage();
		

	}
	
	@AfterMethod
	public void TearDown() {
		driver.quit();
		
	}
	
	
	@Test
	public void validateJob() throws InterruptedException {
		
	homepage.CloseCookie();
	
	AssertJUnit.assertTrue(homepage.IsCareerLinkVisible());
	
	homepage.ClickCareerLink();
		
	AssertJUnit.assertTrue(careerspage.IsSearchBoxVisible());
	
	careerspage.SearchJob("SDET");
	
	int i=searchpage.GetJobIndex(prop.getProperty("title"), prop.getProperty("category"), prop.getProperty("location"), prop.getProperty("jobid"));
	
	AssertJUnit.assertEquals(searchpage.getJobTitle(i), prop.getProperty("title"));
	
	AssertJUnit.assertEquals(searchpage.getJobCategory(i), prop.getProperty("category"));
	
	AssertJUnit.assertEquals(searchpage.getJobID(i), prop.getProperty("jobid"));
	
	AssertJUnit.assertEquals(searchpage.getJobLocation(i), prop.getProperty("location"));
	
	searchpage.ClickJob(i);
	
	AssertJUnit.assertTrue(submitpage.IsTitleLoaded(prop.getProperty("title")));
	
	AssertJUnit.assertTrue(submitpage.IsTextavailable(prop.getProperty("text1")));
	
	AssertJUnit.assertTrue(submitpage.IsTextavailable(prop.getProperty("text2")));
	
	AssertJUnit.assertTrue(submitpage.IsTextavailable(prop.getProperty("text3")));
	
	submitpage.ClickApplyButton();
	
	System.out.println(driver.getTitle());
	
	AssertJUnit.assertEquals(TestUtil.getWindowTitle(), prop.getProperty("submittedPagetitle"));
	
	driver.close();
	
	submitpage.ReturntoJobListing();
	
	System.out.println(driver.getTitle());
	
	AssertJUnit.assertEquals(TestUtil.getWindowTitle(), prop.getProperty("searchWindowTitle"));
	
		
		
	}
	

}
