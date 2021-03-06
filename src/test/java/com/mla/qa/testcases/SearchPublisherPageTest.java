package com.mla.qa.testcases;



import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.mla.qa.base.TestBase;

import com.mla.qa.pages.DashboardPage;
import com.mla.qa.pages.LoginPage;
import com.mla.qa.pages.SearchPublisherPage;


public class SearchPublisherPageTest extends TestBase{
	LoginPage loginpage;
	DashboardPage dashboardpage;
	SearchPublisherPage searchpub;
	
	public SearchPublisherPageTest() {
		super();
	}
	
	@BeforeTest
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
	  
	  @Test(priority = 2, dependsOnMethods={"SearchByPublisherName"})
	  public void SelectAndDeletePubTest() {
		  searchpub.SelectAndDeletePublisher("5012");
	  }
	 
	  @AfterTest
	  public void tearDown() {
		//  driver.quit();
	  }
}

