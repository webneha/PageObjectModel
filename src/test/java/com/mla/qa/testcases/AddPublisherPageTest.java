package com.mla.qa.testcases;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.mla.qa.base.TestBase;

import com.mla.qa.pages.AddPublisherPage;
import com.mla.qa.pages.DashboardPage;
import com.mla.qa.pages.LoginPage;


public class AddPublisherPageTest extends TestBase {
	LoginPage loginpage;
	DashboardPage dashboardpage;
	AddPublisherPage addpub;
	
	public AddPublisherPageTest() {
		super();
	}
	
	@BeforeTest
	  public void setUp() {
		  intialization();
		  loginpage = new LoginPage();
		  dashboardpage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		  addpub = dashboardpage.navigateToAddPublisherPage();
	  }
	

	  @Test(priority = 1)
	  public void AddNewPublisherDetails()
	  {
		  addpub.createNewPublisher("Canada", "roohi", "Imperial Palace Cultural Center");
	  }
	  
	 
	  @AfterTest
	  public void tearDown() {
		//  driver.quit();
	  }
}
