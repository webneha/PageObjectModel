package com.mla.qa.testcases;

import org.testng.annotations.Test;

import com.mla.qa.base.TestBase;
import com.mla.qa.pages.ApprovePublishers;
import com.mla.qa.pages.DashboardPage;
import com.mla.qa.pages.LoginPage;
import com.mla.qa.pages.SearchPublisherPage;
import com.mla.qa.pages.ThesaurusWorkflow;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;

import org.testng.annotations.BeforeMethod;

public class DashboardTestPage extends TestBase{
	LoginPage loginpage;
	DashboardPage dashboardpage;
	ThesaurusWorkflow thesWFPage;
	ApprovePublishers apppub;
	SearchPublisherPage searchpub;
	
	public DashboardTestPage() {
		super();
	}
	
  @BeforeMethod
  public void setUp() {
	  intialization();
	  loginpage = new LoginPage();
	  dashboardpage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
  }
  
  @Test(priority = 1)
  public void VerifydashboardPagetitleTest() {
	  String dashboardPageTitle =dashboardpage.verifyDashboardPageTitle();
	  Assert.assertEquals(dashboardPageTitle,"Dashboard - Indexer - To Be Indexed", "Dashboard Page Title not matched");
  }
  
  @Test(priority = 2)
  public void verifyDashboardScreenLableTest() {
	  Assert.assertTrue(dashboardpage.verifyDashboardScreenLabel());
  }
  
  @Test(priority = 3)
  public void verifyClickOnThesWorkFlowIconTest() throws InterruptedException {
	  thesWFPage = dashboardpage.clickOnThesWFPage();
  }
  
  @Test(priority = 4)
  public void verifyClickOnAppPublisherIconTest() {
	  apppub = dashboardpage.clickOnAppPublisherPage();
  }
  
  @Test(priority = 5)
  public void verifyClickOnSearchPublisherTabTest() {
	  searchpub=dashboardpage.navigateToSearchPublisherPage();
  }
  
  @AfterMethod
  public void tearDown() {
	  //driver.quit();
  }

}
