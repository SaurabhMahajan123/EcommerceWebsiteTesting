package com.mystore.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actionDrivers.Action;
import com.mystore.base.BaseClass;

public class IndexPage extends BaseClass{

	
	
	@FindBy(xpath= "//a[@class='login']")
	WebElement signInBtn;
	
	@FindBy(xpath="//img[@class='logo img-responsive']")
	WebElement myShoplogo;

	@FindBy(xpath= "//div[@id='search_block_top']/child::form/input[4]")
	WebElement searchBox;
	
	@FindBy(xpath= "//div[@id='search_block_top']/child::form/button")
	WebElement searchBtn;
	
//	public WebElement logo =  driver.findElement(By.xpath("//img[@class='logo img-responsive']"));
	
	// we are using pagefactory constructor to intialise he objects
	
	public IndexPage() {
		PageFactory.initElements(getDriver(), this);
		
	}
	
	// functional methods for index page
	
	public LoginPage  clickOnSignIn() {
		action.click(getDriver(), signInBtn);
		return new LoginPage();
		
	}
	
	public boolean validateLogo()  {

		return action.isDisplayed(getDriver(),getDriver().findElement(By.xpath("//img[@class='logo img-responsive']")));
	}
	
	public String getMyStoreTitle() {
		return action.getTitle(getDriver());
	}
	
	public SearchResultPage searchProduct(String productname) {
		action.fluentWait(getDriver(), searchBox, 5);
		action.type(searchBox, productname);
		action.click(getDriver(),searchBtn);
		return new SearchResultPage();
	}
	
	
	
	
}
