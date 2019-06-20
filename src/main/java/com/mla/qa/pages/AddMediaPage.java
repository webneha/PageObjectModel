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
	
	@FindBy(id = "createTracking")
	WebElement createTrack;
	
	@FindBy(xpath = "//input[@name='publicationDate']")
	WebElement pubDate;
	
	@FindBy(xpath = "//input[@name='volume']")
	WebElement vol;
	
	@FindBy(xpath = "//input[@name='issue']")
	WebElement iss;
	
	@FindBy(xpath = "//button[@class='btn btn-primary tracking_form_save']")
	WebElement create;
	
	@FindBy(xpath = "//a[@class='btn btn-primary dropdown-toggle sd-btn']")
	WebElement act;
	
	@FindBy(xpath = "//a[contains(text(),'Create Journal Article (JA)')]")
	WebElement createja;
	
	@FindBy(xpath = "//textarea[@name='journalArticleRecord.articleMeta.articleTitle.value']")
	WebElement arttitle;
	
	@FindBy(xpath = "//button[contains(text(),'Create Journal Article')]")
	WebElement createJAarticle;
	
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
	
	public void createNewMediaWithTracking(String name,String pub,String indexer, String pdate, String volume , String issue, String format, String articleTitle) 
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
		wait.until(ExpectedConditions.visibilityOf(createTrack));
		createTrack.click();
		pubDate.sendKeys(pdate);
		vol.sendKeys(volume);
		iss.sendKeys(issue);
		driver.findElement(By.xpath("//button[contains(text(),'"+format+"')]")).click();
		create.click();
		createbib(articleTitle);
	}
	
	public void createbib(String articleTitle) {
		act.click();
		createja.click();
		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(arttitle));
		arttitle.sendKeys(articleTitle);
		wait.until(ExpectedConditions.visibilityOf(createJAarticle));
		createJAarticle.click();
	}
}
