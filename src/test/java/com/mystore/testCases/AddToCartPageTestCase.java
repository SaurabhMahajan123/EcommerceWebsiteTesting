package com.mystore.testCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pageObjects.AddToCartPage;
import com.mystore.pageObjects.IndexPage;
import com.mystore.pageObjects.SearchResultPage;

public class AddToCartPageTestCase extends BaseClass {
	IndexPage indexPage;
	SearchResultPage searchResult;
	AddToCartPage addToCartPage;
	
	@BeforeMethod
	public void setup() {
		launchApp();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	@Test
	public void addToCartTest() throws Throwable {

		indexPage= new IndexPage();
		searchResult=indexPage.searchProduct("Printed Summer Dress");
		addToCartPage=searchResult.clickOnProduct();
	
		addToCartPage.enterColor();
		addToCartPage.enterQuantity("1");
		addToCartPage.selectSize("M");
		addToCartPage.clickOnAddToCart();
		boolean result=addToCartPage.validateAddtoCart();
		Assert.assertTrue(result);

	}
}
