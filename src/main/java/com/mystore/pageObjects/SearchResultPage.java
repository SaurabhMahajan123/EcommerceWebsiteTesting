package com.mystore.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.base.BaseClass;

public class SearchResultPage extends BaseClass {
	
	
	@FindBy(xpath="//*[@id=\"center_column\"]//img")
	private WebElement productResult;
	
	public SearchResultPage() {
		PageFactory.initElements(driver, this);
	}

	public boolean isProductAvailable() throws Throwable {
		return action.isDisplayed(driver, productResult);
	}
	
	
	public AddToCartPage clickOnProduct() throws Throwable {
		action.click(driver, productResult);
		return new AddToCartPage();
	}
	
	
	
}
