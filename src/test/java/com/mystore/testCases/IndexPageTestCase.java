	package com.mystore.testCases;
	
	import org.testng.annotations.AfterMethod;
	import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pageObjects.IndexPage;
import com.mystore.utility.Log;

import junit.framework.Assert;
	
	public class IndexPageTestCase extends BaseClass{
	
	IndexPage index = new IndexPage();	
		
		
	@Parameters("browser")
	@BeforeMethod
	public void setup(String browser ) {
		System.out.println(browser);
		launchApp(browser);
	}
	
	@AfterMethod
	public void tearDown() {
		getDriver().quit();
	}
	
	@Test
	public void verifylogo() throws Throwable {
		Log.startTestCase("verifyLogo");
		boolean result = index.validateLogo();
		
		Assert.assertTrue(result);
		Log.endTestCase("verifyLogo");
	}
	
	
	@Test
	public void verifyTitle() {
		Log.startTestCase("verifyTitle");
		String actTitle=index.getMyStoreTitle();
		Assert.assertEquals(actTitle, "My Shop");
		Log.endTestCase("verifyTitle");
		
	}
	
	
	
	
	
	}
