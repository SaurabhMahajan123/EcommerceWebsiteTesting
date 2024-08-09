package com.mystore.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actionDrivers.Action;
import com.mystore.base.BaseClass;

public class IndexPage extends BaseClass{

	
	
	@FindBy(xpath = "//a[@class='login']")
	WebElement signInBtn;
	
	@FindBy(xpath = "//img[@class='logo img-responsive']")
	WebElement logo;
	
//	@FindBy(id = "header_logo")
//	WebElement logo;
	
	
	@FindBy(xpath = "//div[@id='search_block_top']/child::form/input[4]")
	WebElement searchBox;
	
	@FindBy(xpath = "//div[@id='search_block_top']/child::form/button")
	WebElement searchBtn;
	
	
	// we are using pagefactory constructor to intialise he objects
	
	public IndexPage() {
		PageFactory.initElements(driver, this);
		
	}
	
	// functional methods for index page
	
	public LoginPage  clickOnSignIn() {
		action.click(driver, signInBtn);
		return new LoginPage();
	}
	
	public boolean validateLogo() {
//		System.out.println(driver.findElement(By.xpath("//div[@id='header_logo']")));
		return action.isDisplayed(driver, logo);
	}
	
	public String getMyStoreTitle() {
		return action.getTitle(driver);
	}
	
	public SearchResultPage searchProduct(String productname) {
		action.type(searchBox, productname);
		action.click(driver,searchBtn);
		return new SearchResultPage();
	}
	
	
	
	
}
