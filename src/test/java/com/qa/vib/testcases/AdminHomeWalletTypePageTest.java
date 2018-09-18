package com.qa.vib.testcases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.vib.base.TestBase;
import com.qa.vib.pages.AdminHomePage;
import com.qa.vib.pages.AdminHomeWalletTypePage;
import com.qa.vib.pages.AdminLoginPage;
import com.qa.vib.util.TestUtil;

public class AdminHomeWalletTypePageTest extends TestBase{

	AdminLoginPage aLoginPage;   
	AdminHomePage aHomePage;
	AdminHomeWalletTypePage walletTypePage;
	TestUtil testUtil;


	public AdminHomeWalletTypePageTest(){
		super(); 
	}

	@BeforeMethod
	public void setUp() throws Throwable
	{
		initialization();
		testUtil = new TestUtil();
		aLoginPage = new AdminLoginPage();
		aHomePage = aLoginPage.adminLogin(prop.getProperty("username"), prop.getProperty("password"));
		walletTypePage = new AdminHomeWalletTypePage();
		walletTypePage = aHomePage.clickonMasterWalletType();
	}

	@Test(priority = 1)
	public void verifyWalletTypeTitleTest() {
		boolean title = walletTypePage.validateWalletTypeTitle();
		Assert.assertTrue(title);
	}

	@DataProvider
	public Object[][] getWalletTypeTestData() {
		Object data[][] = TestUtil.getTestData("WalletTypeData");
		return data;
	}

	@Test(priority = 2, dataProvider = "getWalletTypeTestData")
	public void verifyAddNewWalletTypeTest(String walletTypeName)  {
		walletTypePage.addNewWalletType(walletTypeName);
		String walletTypeSearch =  driver.findElement(By.xpath("//td[contains(text(),'"+walletTypeName+"')]")).getText();
		Assert.assertEquals(walletTypeSearch, walletTypeName);
	}

	@Test(priority = 3, dataProvider = "getWalletTypeTestData")
	public void verifyWalletTypeSearchResult(String walletTypeName) {
		walletTypePage.validateWalletTypeNameBySearch(walletTypeName);
		String servicesSearch =  driver.findElement(By.xpath("//td[contains(text(),'"+walletTypeName+"')]")).getText();
		Assert.assertEquals(servicesSearch, walletTypeName, '"'+walletTypeName+"'" +"Wallet Type Name not Available");
	}

	@AfterMethod
	public void adminLogout() {
		aHomePage.clickonLogOut();
	}

	public void shutDown(){
		driver.quit();
	}	


}
