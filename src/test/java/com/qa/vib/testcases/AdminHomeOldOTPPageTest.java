package com.qa.vib.testcases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.qa.vib.base.TestBase;
import com.qa.vib.pages.AdminHomeOldOTPPage;
import com.qa.vib.pages.AdminHomePage;
import com.qa.vib.pages.AdminLoginPage;
import com.qa.vib.util.TestUtil;

public class AdminHomeOldOTPPageTest extends TestBase {

	AdminLoginPage aLoginPage;   
	AdminHomePage aHomePage;
	AdminHomeOldOTPPage oldOTPPage;
	TestUtil testUtil;


	public AdminHomeOldOTPPageTest(){
		super(); 
	}

	@BeforeMethod
	public void setUp() throws Throwable
	{
		initialization();
		testUtil = new TestUtil();
		aLoginPage = new AdminLoginPage();
		aHomePage = aLoginPage.adminLogin(prop.getProperty("username"), prop.getProperty("password"));
		oldOTPPage = new AdminHomeOldOTPPage();
		oldOTPPage = aHomePage.clickonConfigOldOTP();
	}

	@Test(priority = 1)
	public void verifyServicesPageTitleTest() {
		boolean title = oldOTPPage.validateOldOTPTitle();
		Assert.assertTrue(title);
	}

	@DataProvider
	public Object[][] getOldOTPTestData() {
		Object data[][] = TestUtil.getTestData("OldOTPData");
		return data;
	}


	@Test(priority = 2, dataProvider = "getOldOTPTestData")
	public void verifyOldOTPSearchResult(String oldOTP) {
		oldOTPPage.validateOldOTPBySearch(oldOTP);
		String oldOTPSearch =  driver.findElement(By.xpath("//td[contains(text(),'"+oldOTP+"')]")).getText();
		Assert.assertEquals(oldOTPSearch, oldOTP, '"'+oldOTP+"'" +"Old OTP not Available in Search Result");
	}

	@AfterMethod
	/*public void adminLogout() {
		aHomePage.clickonLogOut();
	}*/

	public void shutDown(){
		driver.quit();
	}	



}
