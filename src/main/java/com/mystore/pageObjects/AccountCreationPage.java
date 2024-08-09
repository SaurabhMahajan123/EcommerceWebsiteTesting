package com.mystore.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.base.BaseClass;

public class AccountCreationPage extends  BaseClass{

	
	//*[contains(text(),'Create an account')]
	@FindBy(xpath="//*[contains(text(),'Create an account')]")
	WebElement formTitle;
	
	
	public AccountCreationPage() {
		PageFactory.initElements(driver, this);
		
	}
	
	
	public boolean validateAcountCreatePage() throws Throwable {
		 return action.isDisplayed(driver, formTitle);
	}
}
