package com.mystore.pageObjects;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import com.mystore.base.BaseClass;

public class PaymentPage extends BaseClass {

	@FindBy(xpath = "//a[contains(text(),'Pay by bank wire')]")
	private WebElement bankWireMethod;
	
	@FindBy(xpath = "//a[contains(text(),'Pay by check')]")
	private WebElement payByCheckMethod;
	
	public PaymentPage() {
		PageFactory.initElements(driver, this);
	}
	
	public OrderSummaryPage clickOnPaymentMethod() throws Throwable {
		action.click(driver, bankWireMethod);
		return new OrderSummaryPage();
	}
}
