package com.mla.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.mla.qa.base.TestBase;

public class AddMediaPage extends TestBase {

	@FindBy(xpath = "//textarea[@name='journal.sourceMeta.sourceName.value']")
	WebElement journalName;
	
	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/section[1]/div[1]/div[1]/form[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[6]/div[1]/div[1]/div[1]/input[3]")
	WebElement pubName;
	
	@FindBy(xpath = "//button[contains(text(),'Create Journal Media')]")
	WebElement CreateJournalMedia;
	
	@FindBy(id = "mediaView")
	WebElement later;
	
	public AddMediaPage(){
		PageFactory.initElements(driver, this);
		}
	
	public void createNewMedia(String name,String pub,String indexer) 
	{
		journalName.sendKeys(name);
		pubName.sendKeys(pub);
		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//select[@name='journal.mediaRecordinfo.bibliographer']"))));
		Select select = new Select(driver.findElement(By.xpath("//select[@name='journal.mediaRecordinfo.bibliographer']")));
	    select.selectByVisibleText(indexer);
	    wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(CreateJournalMedia));
	    CreateJournalMedia.click();
		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(later));
		later.click();
		
		
	}
	 
	
}
