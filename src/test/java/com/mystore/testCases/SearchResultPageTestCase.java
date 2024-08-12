package com.mystore.testCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pageObjects.IndexPage;
import com.mystore.pageObjects.SearchResultPage;

public class SearchResultPageTestCase extends BaseClass{

	IndexPage indexPage;
	SearchResultPage searchResult;
	
	@BeforeMethod
	public void setup() {
		launchApp();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	@Test
	public void productAvialabilityTest() throws Throwable {
		indexPage = new IndexPage();
		searchResult = indexPage.searchProduct("Printed Summer Dress");
		boolean result = searchResult.isProductAvailable();
		Assert.assertTrue(result);
	
	}
}
