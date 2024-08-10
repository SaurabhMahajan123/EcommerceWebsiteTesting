	package com.mystore.base;
	
	import java.io.FileInputStream;
	import java.io.FileNotFoundException;
	import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
	
	import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.firefox.FirefoxDriver;
	import org.openqa.selenium.firefox.GeckoDriverInfo;
	import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
	import org.testng.annotations.BeforeTest;
import org.testng.reporters.jq.Main;

import com.mystore.actionDrivers.Action;
	
	public class BaseClass {
	
		public static WebDriver driver;
		public static Properties prop;
		public static Action action  = new Action();
		
		
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
	
	
	public static void launchApp() {
		
	 
		String browserName = prop.getProperty("browser");
		
		if(browserName.contains("Chrome")) {
			driver= new ChromeDriver();
			
		}else if(browserName.contains("FireFox")) {
			driver = new FirefoxDriver();
		}else if(browserName.contains("IE")) {
			driver = new InternetExplorerDriver();
		}
		
		action.implicitWait(driver, 10);
		action.pageLoadTimeOut(driver, 30);
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		
		
		
	}


	
	
	
	
	
	}
