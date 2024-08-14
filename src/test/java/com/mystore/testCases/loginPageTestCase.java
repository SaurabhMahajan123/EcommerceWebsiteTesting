package com.mystore.testCases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.mystore.base.BaseClass;
import com.mystore.pageObjects.HomePage;
import com.mystore.pageObjects.IndexPage;
import com.mystore.pageObjects.LoginPage;
import com.mystore.utility.Log;

import junit.framework.Assert;

public class loginPageTestCase extends BaseClass {

	IndexPage indexPage;
	LoginPage loginPage;
	HomePage homePage;

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
	public void loginTest() throws Throwable {
		Log.startTestCase("loginTest");
		indexPage = new IndexPage();
		Log.info("user is going to click on SignIn");
		loginPage = indexPage.clickOnSignIn();
		Log.info("Enter Username and Password");
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		String actualURL = homePage.getCurrURL();
		String expectedURL = "http://www.automationpractice.pl/index.php?controller=my-account";
		Log.info("Verifying if user is able to login");
		Assert.assertEquals(actualURL, expectedURL);
		Log.info("Login is Sucess");
		Log.endTestCase("loginTest");
	}

}
