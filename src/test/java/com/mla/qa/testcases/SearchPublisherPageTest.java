package com.mla.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mla.qa.base.TestBase;
import com.mla.qa.pages.ApprovePublishers;
import com.mla.qa.pages.DashboardPage;
import com.mla.qa.pages.LoginPage;
import com.mla.qa.pages.SearchPublisherPage;
import com.mla.qa.pages.ThesaurusWorkflow;

public class SearchPublisherPageTest extends TestBase{
	LoginPage loginpage;
	DashboardPage dashboardpage;
	SearchPublisherPage searchpub;
	
	public SearchPublisherPageTest() {
		super();
	}
	
	@BeforeMethod
	  public void setUp() {
		  intialization();
		  loginpage = new LoginPage();
		  dashboardpage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		  searchpub=dashboardpage.navigateToSearchPublisherPage();
	  }
	

	  @Test(priority = 1)
	  public void SearchByPublisherName() {
		  searchpub.SearchPublisherfunctionality();
	  }
	 
	  @AfterMethod
	  public void tearDown() {
		  driver.quit();
	  }
}

