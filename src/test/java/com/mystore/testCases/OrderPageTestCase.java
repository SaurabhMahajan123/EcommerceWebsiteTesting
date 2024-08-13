package com.mystore.testCases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pageObjects.AddToCartPage;
import com.mystore.pageObjects.IndexPage;
import com.mystore.pageObjects.OrderPage;
import com.mystore.pageObjects.SearchResultPage;

import junit.framework.Assert;

public class OrderPageTestCase extends BaseClass {

	IndexPage indexPage;
	SearchResultPage searchResult;
	AddToCartPage addToCartPage;
	OrderPage orderPage;
	
	@BeforeMethod
	public void setup() {
		launchApp();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	@Test
	public void verifyTotalPrice() throws Throwable {
		indexPage= new IndexPage();
		searchResult=indexPage.searchProduct("Printed Summer Dress");
		addToCartPage=searchResult.clickOnProduct();
		addToCartPage.enterColor();
		addToCartPage.enterQuantity("1");
		addToCartPage.selectSize("M");
		addToCartPage.clickOnAddToCart();
		orderPage=addToCartPage.clickOnCheckOut();
		double unitPrice=orderPage.getUnitPrice();
		double totalPrice=orderPage.getTotalPrice();
		double totalExpectedPrice = (unitPrice*1);
		Assert.assertEquals(totalPrice, totalExpectedPrice);
	}
}
