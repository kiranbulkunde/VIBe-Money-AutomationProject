package com.qa.vib.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.vib.base.TestBase;
import com.qa.vib.pages.AdminHomePage;
import com.qa.vib.pages.AdminLoginPage;
import com.qa.vib.util.TestUtil;

public class AdminLoginPageTest extends TestBase {

	AdminLoginPage aLoginPage;   
	AdminHomePage homePage;
	TestUtil testUtil;
	
	
	public AdminLoginPageTest(){
		super(); //to call super class constructor
	}
	
	@BeforeMethod
	public void setUp() throws InterruptedException
	{
		initialization();
		aLoginPage = new AdminLoginPage();
		testUtil = new TestUtil();
	}
	
	@Test(priority=1)
	public void aLoginPageTitleTest(){
		String title = aLoginPage.validateLoginTitle();
		Assert.assertEquals(title, "Vibemoney","Login Page Title not Matched");
	}
	
	@Test(priority=2)
	public void vibemLogoImageTest(){
		boolean img = aLoginPage.validateVibemLogo();
		Assert.assertTrue(img);
	}
	
	@DataProvider
	public Object[][] getLoginData() {
		Object data[][] = TestUtil.getTestData("LoginData");
		return data;
	}
	
	@Test(priority=3, dataProvider = "getLoginData")
	public void adminLoginTest(String username, String password){
		homePage = aLoginPage.adminLogin(prop.getProperty("userName"), prop.getProperty("password"));
		//homePage = aLoginPage.adminLogin(username, password);
	}
	
	@AfterMethod
	public void shutDown(){
		driver.quit();
	}


}
