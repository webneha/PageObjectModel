package com.mla.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mla.qa.base.TestBase;

public class SearchPublisherPage extends TestBase{

	@FindBy(xpath ="//input[@search-constraint=\"publisherName|publisherParCom|publisherImpr\"]")
	WebElement PublisherName;
	
	@FindBy(id ="search_publisher")
	WebElement SearchButton;

	public SearchPublisherPage(){
		PageFactory.initElements(driver, this);
		
		}

	public void SearchPublisherfunctionality() {
	PublisherName.sendKeys("*");
    SearchButton.click();
	}
	
	public void SelectAndDeletePublisher(String pubid) {
		driver.findElement(By.xpath(
				".//table[@id='publisher-content-table']/tbody//td[@class='text-center']//input[@data-id='"+pubid+"']")).click();
	}
}