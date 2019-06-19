package com.mla.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.mla.qa.base.TestBase;
import com.mla.qa.pages.AddMediaPage;

import com.mla.qa.pages.DashboardPage;
import com.mla.qa.pages.LoginPage;
import com.mla.qa.util.TestUtil;

public class AddMediaPageTest extends TestBase {
	LoginPage loginpage;
	DashboardPage dashboardpage;
	AddMediaPage addMedia;
	
	String sheetName = "Media";

	public AddMediaPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		intialization();
		loginpage = new LoginPage();
		dashboardpage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		addMedia = dashboardpage.navigateToAddMediaPage();
	}

	@DataProvider
	public Object[][] getMLATestData() {
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}

	@Test(priority = 1, dataProvider = "getMLATestData")
	public void AddNewMediaDetails(String name,String pub,String indexer) {
		addMedia.createNewMedia(name, pub, indexer);
	}
	
	
    @AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
