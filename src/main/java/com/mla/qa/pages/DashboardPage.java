package com.mla.qa.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mla.qa.base.TestBase;
import com.mla.qa.util.TestUtil;

public class DashboardPage extends TestBase {
     
	@FindBy(xpath ="//span[contains(text(),'Dashboard - To Be Indexed')]")
	WebElement ScreenNameLabel;
	
	@FindBy(xpath ="//aside[@class='sidebar-panel']//li[7]//a[1]")
	WebElement AppPublisher;
	
	@FindBy(xpath ="//aside[@class='sidebar-panel']//li[4]//a[1]")
	WebElement thesWorkflow;
	
	@FindBy(xpath ="//a[@href='#Publisher']")
	WebElement Pub;
	
	@FindBy(xpath ="//a[@href ='/mla-webapp/publisher/search']")
	WebElement SearchPub;
	
	
	public DashboardPage(){
		PageFactory.initElements(driver, this);
		
		}
	
	public boolean verifyDashboardScreenLabel() {
		return ScreenNameLabel.isDisplayed();
	}
	
	public String verifyDashboardPageTitle() {
		return driver.getTitle();
	}
	
	public ThesaurusWorkflow clickOnThesWFPage() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		thesWorkflow.click();
		return new ThesaurusWorkflow();
	}
	
	public ApprovePublishers clickOnAppPublisherPage() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		AppPublisher.click();
		return new ApprovePublishers();
	}
	
	public SearchPublisherPage navigateToSearchPublisherPage() {
		Actions action = new Actions(driver);
		action.moveToElement(Pub).clickAndHold().build().perform();
		SearchPub.click();
		return new SearchPublisherPage();
	}
	
}
