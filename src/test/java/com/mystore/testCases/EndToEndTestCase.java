package com.mystore.testCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pageObjects.AddToCartPage;
import com.mystore.pageObjects.AddressPage;
import com.mystore.pageObjects.IndexPage;
import com.mystore.pageObjects.LoginPage;
import com.mystore.pageObjects.OrderConfirmationPage;
import com.mystore.pageObjects.OrderPage;
import com.mystore.pageObjects.OrderSummaryPage;
import com.mystore.pageObjects.PaymentPage;
import com.mystore.pageObjects.SearchResultPage;
import com.mystore.pageObjects.ShippingPage;

public class EndToEndTestCase extends BaseClass{

	IndexPage index;
	LoginPage loginPage;
	SearchResultPage searchResultPage;
	AddToCartPage addToCartPage;
	OrderPage orderPage;
	OrderConfirmationPage orderConfirmationPage;
	OrderSummaryPage orderSummary;
	PaymentPage paymentPage;
	AddressPage addressPage;
	ShippingPage shippingPage;
	
	
	@BeforeMethod
	public void setup() {
		launchApp();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	@Test
	public void endToEndTest() throws Throwable {
//		Log.startTestCase("endToEndTest");
		index= new IndexPage();
		searchResultPage=index.searchProduct("Printed Summer Dress");
		addToCartPage=searchResultPage.clickOnProduct();
		addToCartPage.enterQuantity("1");
		addToCartPage.selectSize("M");
		addToCartPage.clickOnAddToCart();
		orderPage=addToCartPage.clickOnCheckOut();
		loginPage=orderPage.clickOnCheckOut();
		addressPage=loginPage.login1(prop.getProperty("username"), prop.getProperty("password"),addressPage);
		shippingPage=addressPage.clickOnCheckOut();
		shippingPage.checkTheTerms();
		paymentPage=shippingPage.clickOnProceedToCheckOut();
		orderSummary=paymentPage.clickOnPaymentMethod();
		orderConfirmationPage=orderSummary.clickOnconfirmOrderBtn();
		String actualMessage=orderConfirmationPage.validateConfirmMessage();
		String expectedMsg="Your order on My Shop is complete.";
		Assert.assertEquals(actualMessage, expectedMsg);
//		Log.endTestCase("endToEndTest");
	}
	
}
