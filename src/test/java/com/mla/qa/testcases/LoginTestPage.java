package com.mla.qa.testcases;


import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.mla.qa.base.TestBase;
import com.mla.qa.pages.DashboardPage;
import com.mla.qa.pages.LoginPage;


public class LoginTestPage extends TestBase {

	LoginPage loginpage;
	DashboardPage dashboardpage;
	public LoginTestPage() {
		super();
	}




	@BeforeTest
	public void setUp() {
		intialization();
		loginpage = new LoginPage();
		
	}
	
	@Test(priority = 1)
	public void loginPageTitleTest() {
		String title = loginpage.validateLoginPageTitle();
		Assert.assertEquals(title,"Login");
		
	}
	@Test(priority = 2)
	public void mlaLogoImageTest() {
		boolean flag = loginpage.validateMLAImage();
		Assert.assertTrue(flag);
		
	}
	@Test(priority = 3)
	public void loginTest() {
		dashboardpage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		
	}
  
	@AfterTest
	public void tearDown() {
		//driver.quit();
		
	}
	
	}



