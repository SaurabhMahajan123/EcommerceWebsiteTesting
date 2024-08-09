package com.mystore.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.base.BaseClass;

public class LoginPage extends BaseClass {

	
	// when user already registered
	
	@FindBy(xpath="//form[@id='login_form']/child::div/child::div[1]/input")
	WebElement userNameEmailId;
	
	@FindBy(xpath="//form[@id='login_form']/child::div/child::div[2]/input")
	WebElement userPassword;
	
	@FindBy(id="SubmitLogin")
	WebElement signInBtn;
	
	// when user is not registered
	
	@FindBy(id="email_create")
	WebElement emailForNewAcct;
	
	@FindBy(id="SubmitCreate")
	WebElement createNewAccountBtn;
	
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
		
	}
	
	// user sign in methods
	
	public HomePage login(String uname , String pass) {
		action.type(userNameEmailId, uname);
		action.type(userPassword, pass);
		action.click(driver, signInBtn);
		
		return new HomePage();
	}
	
	public AddressPage login1(String uname, String pswd,AddressPage addressPage) throws Throwable {
		action.scrollByVisibiltyOfElement(driver, userNameEmailId);
		action.type(userNameEmailId, uname);
		action.type(userPassword, pswd);
		action.click(driver, signInBtn);
		Thread.sleep(2000);
		
		return  new AddressPage();
	}
	
	
	
	
	// user register methods
	
	public AccountCreationPage createNewAccount(String email) {
		action.type(emailForNewAcct, email);
		action.click(driver, createNewAccountBtn);
		return new AccountCreationPage();
		
	}
	
	
	
	
}
