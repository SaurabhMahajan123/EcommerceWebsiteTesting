	package com.mystore.base;
	import io.github.bonigarcia.wdm.WebDriverManager;
	import java.io.FileInputStream;
	import java.io.FileNotFoundException;
	import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.firefox.FirefoxDriver;
	import org.openqa.selenium.firefox.GeckoDriverInfo;
	import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeMethod;
	import org.testng.annotations.BeforeTest;
import org.testng.reporters.jq.Main;

import com.mystore.actionDrivers.Action;
	
	public class BaseClass {
	
		
		public static Properties prop;
		public static Action action  = new Action();
		public static ThreadLocal<RemoteWebDriver> driver = new ThreadLocal();
		
	@BeforeTest
	public static void loadConfig() {
		try {
			 prop = new Properties();
			System.out.println("super constructor invoked");
			
			FileInputStream fs = new FileInputStream("./configuration/Config.properties");
			
//			InputStream fs = Main.class.getClassLoader().getResourceAsStream("configuration/config.properties");
			
			prop.load(fs);
			
			
		} catch (FileNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public static WebDriver getDriver() {
		// Get Driver from threadLocalmap
		return driver.get();
	}
	
	public static void launchApp(String browserName) {
		
	 
		// String browserName = prop.getProperty("browser");
				if (browserName.equalsIgnoreCase("Chrome")) {
					WebDriverManager.chromedriver().setup();
					// Set Browser to ThreadLocalMap
					driver.set(new ChromeDriver());
				} else if (browserName.equalsIgnoreCase("FireFox")) {
					WebDriverManager.firefoxdriver().setup();
					driver.set(new FirefoxDriver());
				} else if (browserName.equalsIgnoreCase("IE")) {
					WebDriverManager.iedriver().setup();
					driver.set(new InternetExplorerDriver());
				}
				//Maximize the screen
				getDriver().manage().window().maximize();
				//Delete all the cookies
				getDriver().manage().deleteAllCookies();
				//Implicit TimeOuts
				getDriver().manage().timeouts().implicitlyWait
				(Integer.parseInt(prop.getProperty("implicitWait")),TimeUnit.SECONDS);
				//PageLoad TimeOuts
				getDriver().manage().timeouts().pageLoadTimeout
				(Integer.parseInt(prop.getProperty("pageLoadTimeOut")),TimeUnit.SECONDS);
				//Launching the URL
				getDriver().get(prop.getProperty("url"));
		
		
		
	}


	
	
	
	
	
	}
