package com.mystore.pageObjects;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.base.BaseClass;

public class OrderPage  extends BaseClass{

//	@FindBy(xpath="//tr[@id='product_6_40_0_7431']/child::td[4]/ul")
//	 WebElement unitPrice;
	
	@FindBy(xpath="//td[@class='cart_unit']/span/span")
	 WebElement unitPrice;
	
	@FindBy(id="total_price")
	 WebElement totalPrice;
	
	@FindBy(xpath="//span[text()='Proceed to checkout']")
	 WebElement proceedToCheckOut;
	
	public double getUnitPrice() {
		
		action.fluentWait(driver, unitPrice, 10);
		String unitPrice1=unitPrice.getText();
		
		String unit=unitPrice1.replaceAll("[^a-zA-Z0-9]","");
		double finalUnitPrice=Double.parseDouble(unit);
		return finalUnitPrice/100;
	}
	
	public double getTotalPrice() {
		String totalPrice1=totalPrice.getText();
		String tot=totalPrice1.replaceAll("[^a-zA-Z0-9]","");
		double finalTotalPrice=Double.parseDouble(tot);
		return finalTotalPrice/100;
	}
	
	public LoginPage clickOnCheckOut() throws Throwable {
		action.click(driver, proceedToCheckOut);
		return new LoginPage();
	} 
	
	
}
