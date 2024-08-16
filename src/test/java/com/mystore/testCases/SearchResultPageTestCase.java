package com.mystore.testCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.dataproviders.DataproviderMethods;
import com.mystore.pageObjects.IndexPage;
import com.mystore.pageObjects.SearchResultPage;
import com.mystore.utility.Log;

public class SearchResultPageTestCase extends BaseClass{

	IndexPage indexPage;
	SearchResultPage searchResult;
	
	@Parameters("browser")
	@BeforeMethod
	public void setup(String browser) {
		launchApp(browser);
	}

	@AfterMethod
	public void tearDown() {
		getDriver().quit();
	}
	
	@Test(dataProvider = "searchProduct", dataProviderClass = DataproviderMethods.class)
	public void productAvialabilityTest(String product) throws Throwable {
		Log.startTestCase("productAvailabilityTest");
		indexPage = new IndexPage();
		searchResult = indexPage.searchProduct(product);
		boolean result = searchResult.isProductAvailable();
		Assert.assertTrue(result);
		Log.endTestCase("productAvailabilityTest");
	
	}
}
