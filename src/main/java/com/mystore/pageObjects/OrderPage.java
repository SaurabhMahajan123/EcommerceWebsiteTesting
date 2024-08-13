package com.mystore.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.base.BaseClass;

public class OrderPage extends BaseClass {

//	@FindBy(xpath = "//tr[@id='product_6_40_0_7431']/td[4]")
//	WebElement unitPrice;

	@FindBy(css="li[class='price']")
	 WebElement unitPrice;

	
	@FindBy(xpath="//td[@class='cart_total']")
	 WebElement totalPrice;
	


	@FindBy(xpath = "//span[text()='Proceed to checkout']")
	WebElement proceedToCheckOut;
	
	
	public OrderPage() {
		PageFactory.initElements(getDriver(), this);
		
	}

	public double getUnitPrice() {

		String unitPrice1 = unitPrice.getText();

		String unit = unitPrice1.replaceAll("[^a-zA-Z0-9]", "");
		double finalUnitPrice = Double.parseDouble(unit);
		return finalUnitPrice;
	}

	public double getTotalPrice() {

		String totalPrice1 = totalPrice.getText();
		String tot = totalPrice1.replaceAll("[^a-zA-Z0-9]", "");
		double finalTotalPrice = Double.parseDouble(tot);
		return finalTotalPrice;
	}

	public LoginPage clickOnCheckOut() throws Throwable {
		action.click(getDriver(), proceedToCheckOut);
		return new LoginPage();
	}

}
