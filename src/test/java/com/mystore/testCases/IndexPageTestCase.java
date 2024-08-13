	package com.mystore.testCases;
	
	import org.testng.annotations.AfterMethod;
	import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pageObjects.IndexPage;

import junit.framework.Assert;
	
	public class IndexPageTestCase extends BaseClass{
	
	IndexPage index = new IndexPage();	
		
		
	@Parameters("browser")
	@BeforeMethod
	public void setup(String browser) {
		launchApp(browser);
	}
	
	@AfterMethod
	public void tearDown() {
		getDriver().quit();
	}
	
	@Test
	public void verifylogo() throws Throwable {
		boolean result = index.validateLogo();
		
		Assert.assertTrue(result);
	}
	
	
	@Test
	public void verifyTitle() {
	
		String actTitle=index.getMyStoreTitle();
		
		Assert.assertEquals(actTitle, "My Shop");
		
	}
	
	
	
	
	
	}
