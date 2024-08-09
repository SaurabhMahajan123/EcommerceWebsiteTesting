package com.mystore.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.base.BaseClass;

public class HomePage extends BaseClass{

	@FindBy(xpath="//div[@id='center_column']/child::div/div/ul/li[1]/a")
	WebElement addMyFirstAddress;
	
	@FindBy(xpath="//div[@id='center_column']/child::div/div/ul/li[2]/a")
	WebElement orderHistoryDetails;
	
	@FindBy(xpath="//div[@id='center_column']/child::div/div/ul/li[3]/a")
	WebElement myCreditSlips;
	
	@FindBy(xpath="//div[@id='center_column']/child::div/div/ul/li[4]/a")
	WebElement myAddress;
	
	@FindBy(xpath="//div[@id='center_column']/child::div/div/ul/li[5]/a")
	WebElement myPersonalInformation;
	
	
	public HomePage() {
		PageFactory.initElements(driver, this);
		
	}
	
	
	public boolean validateOrderHistory() throws Throwable {
		return action.isDisplayed(driver, orderHistoryDetails);
	}
	
	public String getCurrURL() throws Throwable {
		String homePageURL=action.getCurrentURL(driver);
		return homePageURL;
	}
	
}
