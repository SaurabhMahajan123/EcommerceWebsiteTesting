	package com.mystore.base;
	
	import java.io.FileInputStream;
	import java.io.FileNotFoundException;
	import java.io.IOException;
	import java.util.Properties;
	
	import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.firefox.FirefoxDriver;
	import org.openqa.selenium.firefox.GeckoDriverInfo;
	import org.openqa.selenium.ie.InternetExplorerDriver;
	import org.testng.annotations.BeforeMethod;
	import org.testng.annotations.BeforeTest;
	
	public class BaseClass {
	
		public static WebDriver driver;
		public static Properties prop;
		
	@BeforeTest
	public static void loadConfig() {
		try {
			 prop = new Properties();
			System.out.println("super constructor invoked");
			
			FileInputStream fs = new FileInputStream(System.getProperty("user.dir") + "configuration\\Config.properties");
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
		}else if(browserName.contains("IE")) {}
		driver = new InternetExplorerDriver();
		
	}


	
	
	
	
	
	}
