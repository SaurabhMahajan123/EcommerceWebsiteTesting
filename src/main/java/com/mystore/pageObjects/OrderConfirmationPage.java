package com.mystore.pageObjects;

import com.mystore.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderConfirmationPage extends BaseClass {

	@FindBy(xpath="//p[@class='alert alert-success']")
	private WebElement confirmMessag;
	
	public OrderConfirmationPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String validateConfirmMessage() {
		action.fluentWait(driver, confirmMessag, 10);
		String confirmMsg=confirmMessag.getText();
		return confirmMsg;
	}
}
