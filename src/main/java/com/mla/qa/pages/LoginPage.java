package com.mla.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mla.qa.base.TestBase;

public class LoginPage extends TestBase {
//page factory or object repository
	@FindBy(name="username")
	WebElement username;
	
	@FindBy(id ="password")
	WebElement password;
	
	@FindBy(id ="btn-login")
	WebElement SignIn;
	
	@FindBy(id ="forgotPassword")
	WebElement ForgotPassword;
	
	@FindBy(xpath ="//img[contains(@class,'loginLogo')]")
	WebElement mlalogo;
	
	//Initializing the Page Object
	public LoginPage(){
		PageFactory.initElements(driver, this);
		
		}
	
	//Actions
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}
	
	public boolean validateMLAImage() {
		return mlalogo.isDisplayed();
	}
	
	public DashboardPage login(String un, String pwd) {
		username.sendKeys(un);
		password.sendKeys(pwd);
		SignIn.click();
		
		return new DashboardPage();
	}
	}
	




