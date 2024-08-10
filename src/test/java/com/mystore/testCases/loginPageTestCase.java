package com.mystore.testCases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.mystore.base.BaseClass;
import com.mystore.pageObjects.HomePage;
import com.mystore.pageObjects.IndexPage;
import com.mystore.pageObjects.LoginPage;

import junit.framework.Assert;

public class loginPageTestCase extends  BaseClass {

	
	IndexPage indexPage;
	LoginPage loginPage;
	HomePage homePage;
	
	
	@BeforeMethod
	public void setup() {
		launchApp();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
		
	@Test
	public void loginTest() throws Throwable {
		indexPage = new IndexPage();
		loginPage = indexPage.clickOnSignIn();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	    String actualURL=homePage.getCurrURL();
	    
	    System.out.println(actualURL);
	    String expectedURL="http://www.automationpractice.pl/index.php?controller=my-account";
	   // Log.info("Verifying if user is able to login");
	    Assert.assertEquals(actualURL, expectedURL);	
	}
	
	
	
	
	
	
	
}
