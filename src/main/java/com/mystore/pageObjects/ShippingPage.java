package com.mystore.pageObjects;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import com.mystore.base.BaseClass;


public class ShippingPage extends BaseClass{
	
	@FindBy(id="cgv")
	private WebElement terms;
	
	@FindBy(xpath="//form[@id='form']/child::p/button")
	private WebElement proceedToCheckOutBtn;
	
	public ShippingPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void checkTheTerms() throws Throwable {
		action.click(driver, terms);
	}
	
	public PaymentPage clickOnProceedToCheckOut() throws Throwable {
		action.click(driver, proceedToCheckOutBtn);
		return new PaymentPage();
	}
	
}
