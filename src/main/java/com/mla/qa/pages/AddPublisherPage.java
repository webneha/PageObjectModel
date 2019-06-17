package com.mla.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.mla.qa.base.TestBase;

public class AddPublisherPage extends TestBase {
 
	@FindBy(xpath = "//input[@name='publisher.publisherName']")
	WebElement pubname;
	
	@FindBy(xpath = "//input[@name='publisher.placeOfPublication']")
	WebElement POP;
	
	@FindBy(xpath = "//button[contains(text(),'Create publisher')]")
	WebElement CreatePub;
	
	public AddPublisherPage(){
		PageFactory.initElements(driver, this);
		
		}
	
	public void createNewPublisher(String name,String poc,String country)
	{
		pubname.sendKeys(name);
		POP.sendKeys(poc);
		Select select = new Select(driver.findElement(By.id("country")));
		select.selectByVisibleText(country);
		CreatePub.click();
		
	}
}
