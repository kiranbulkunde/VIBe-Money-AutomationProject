package com.qa.vib.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.qa.vib.util.TestUtil;
import com.qa.vib.util.WebEventListener;



public class TestBase {


	public static WebDriver driver;
	public static Properties prop;
	public static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
	
	//This constructor creates to read properties File
	public TestBase(){
		try{
			prop = new Properties();
			FileInputStream ip = new FileInputStream("G:\\TESTING PROJECT\\VIBe-Money_TestAutomationProject\\src\\main\\java\\com\\qa\\vib\\config\\config.properties");
			prop.load(ip);
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}
	}

	//In this method Browser get initialize:

	public static void initialization()   {

		String browserName = prop.getProperty("browser");

		if(browserName.equals("chrome")){
			System.setProperty("webdriver.chrome.driver", "G:\\TESTING PROJECT\\VIBe-Money_AutomationProject\\chromedriver.exe");
			driver = new ChromeDriver();
		}else
			if(browserName.equals("FF")){
				System.setProperty("webdriver.gecko.driver", "G:\\\\TESTING PROJECT\\\\JAR FILE\\\\UpdatedJar\\\\geckodriver-v0.21.0-win64\\\\geckodriver.exe");
				driver = new FirefoxDriver();
			}else
				if(browserName.equals("IE")){
					System.setProperty("webdriver.ie.driver", "G:\\TESTING PROJECT\\JAR FILE\\IEDriverServer_x64_3.0.0\\IEDriverServer.exe");
					driver = new InternetExplorerDriver();
				}
		
		//WebDriver Fire Events
		e_driver = new EventFiringWebDriver(driver);
		//create object of EventListenerHandler to register it with EventFiringWebDriver
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver = e_driver;
		
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		//driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);	
		//For Launch URL
		driver.get(prop.getProperty("url"));
		
	}



}
