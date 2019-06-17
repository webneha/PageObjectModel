package com.mla.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.mla.qa.base.TestBase;

import com.mla.qa.pages.AddPublisherPage;
import com.mla.qa.pages.DashboardPage;
import com.mla.qa.pages.LoginPage;
import com.mla.qa.util.TestUtil;


public class AddPublisherPageTest extends TestBase {
	LoginPage loginpage;
	DashboardPage dashboardpage;
	AddPublisherPage addpub;
	
	String sheetName = "Publisher";
	
	public AddPublisherPageTest() {
		super();
	}
	
	@BeforeMethod
	  public void setUp() {
		  intialization();
		  loginpage = new LoginPage();
		  dashboardpage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		  addpub = dashboardpage.navigateToAddPublisherPage();
	  }
	
    @DataProvider
    public Object[][] getMLATestData() {
    	Object data[][]=TestUtil.getTestData(sheetName);
    	return data;
    }
	
	
	  @Test(priority = 1,dataProvider="getMLATestData")
	  public void AddNewPublisherDetails(String name, String poc,String country)
	  {
		 // addpub.createNewPublisher("Canada", "roohi", "Imperial Palace Cultural Center");
		  addpub.createNewPublisher(name,poc,country);
	  }
	  
	 
	  @AfterMethod
	  public void tearDown() {
		 driver.quit();
	  }
}
