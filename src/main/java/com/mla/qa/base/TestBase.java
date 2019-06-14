package com.mla.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.mla.qa.util.TestUtil;

public class TestBase {
	public static WebDriver driver;
	public static Properties prop;
	public WebDriverWait wait;
	
	public TestBase() {
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream("/Users/psb/eclipse-workspace/PageObjectPratice/src/main/java/com/mla/qa/config/config.properties");
			prop.load(ip);
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void intialization() {
	String browsername	= prop.getProperty("browser");
	if(browsername.equals("chrome")) {
		System.setProperty("webdriver.chrome.driver", "D:/selenium setup/chromedriver.exe");
		driver = new ChromeDriver();
	 }
	else if(browsername.equals("FF")){
		System.setProperty("webdriver.gecko.driver", "D:/selenium setup/Firefox.exe");	
		driver = new FirefoxDriver(); 
	}
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOADT_TIMEOUT,TimeUnit.SECONDS);
	driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
	
	driver.get(prop.getProperty("url"));
	}

}
